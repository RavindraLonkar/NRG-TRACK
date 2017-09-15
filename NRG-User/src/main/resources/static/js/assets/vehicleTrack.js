$(document).ready(
		function() {
			var url = window.location;
			$.ajax({
				type : "GET",
				url : url.origin + "/NRG-User/vehicle/tracker/list",
				processData : false,
				contentType : false,
				cache : false,
				timeout : 600000,
				success : function(result) {
					if (result.status == '1') {
						var dataSet = result.data;
						$(dataSet).each(
								function(i, obj) {
									var vehicleid = obj.vehicleid;
									var vechiclename = obj.vechiclename;
									var vechiclenumber = obj.vechiclenumber;
									$('#vehicleId').append(
											'<option value="' + vehicleid
													+ '">' + vechiclename
													+ '/ ' + vechiclenumber
													+ '</option>');
								});
					}
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});

			$('#startDate').datetimepicker({
				format : 'DD/MM/YYYY hh:mm:ss',
				ignoreReadonly : true
			});
			$('#endDate').datetimepicker({
				useCurrent : false,
				format : 'DD/MM/YYYY hh:mm:ss',
				ignoreReadonly : true
			});
			$("#startDate").on("dp.change", function(e) {
				$('#endDate').data("DateTimePicker").minDate(e.date);
			});
			$("#endDate").on("dp.change", function(e) {
				$('#startDate').data("DateTimePicker").maxDate(e.date);
			});
		});

function initMap() {
	document.getElementById('submit').addEventListener('click', function() {
		getCoordinates();
	});
}

function getCoordinates() {
	var validation = false;
	var validation = trackFormValidation();
	if (validation == false)
		return;
	
	var vehicleId = $("#vehicleId").val();
	var startDate = $("#trackStartDate").val();
	var endDate = $("#trackEndDate").val();
	$
			.ajax({
				type : "GET",
				url : $("#contextPath").val()
						+ "vehicle/trackingCoordinatesByDate?vehicleId="
						+ vehicleId + "&startDate=" + startDate + "&endDate="
						+ endDate,
				processData : false,
				contentType : false,
				cache : false,
				timeout : 600000,
				success : function(result) {
					if (result.status == '1') {
						if (jQuery.isEmptyObject(result))
							return;

						list = result.data;
						initialize(list);
					} else {
						bootMessage('sucess', 'There is not have any data for given dates');
					}
				},

			});
}

function initialize(stations) {
	var service = new google.maps.DirectionsService;
	var map = new google.maps.Map(document.getElementById('map'));

	var lngs = stations.map(function(station) {
		return Number(station.longitude);
	});
	var lats = stations.map(function(station) {
		return Number(station.latitude);
	});
	map.fitBounds({
		west : Math.min.apply(null, lngs),
		east : Math.max.apply(null, lngs),
		north : Math.min.apply(null, lats),
		south : Math.max.apply(null, lats),
	});

	for (var i = 0; i < stations.length; i++) {
		if (i == 0 || i == stations.length - 1) {
			var title = "";
			var icon = "";
			if (i == 0) {
				getStartLocationName(stations[i].longitude,
						stations[i].latitude);
				title = "Start";
			} else {
				getEndLocationName(stations[i].longitude, stations[i].latitude);
				title = "End";
			}
			new google.maps.Marker({
				position : new google.maps.LatLng(Number(stations[i].latitude),
						Number(stations[i].longitude)),
				map : map,
				title : title
			});
		}
	}

	// Divide route to several parts because max stations limit is
	// 25 (23 waypoints + 1 origin + 1 destination)
	var totalDist = 0;
	for (var i = 0, parts = [], max = 25 - 1; i < stations.length; i = i + max)
		parts.push(stations.slice(i, i + max + 1));

	// Service callback to process service results
	var service_callback = function(response, status) {
		if (status != 'OK') {
			console.log('Directions request failed due to ' + status);
			return;
		}
		var route = response.routes[0];
		$('.distance-km').text('');
		for (var i = 0; i < route.legs.length; i++) {
			var routeSegment = i + 1;
			totalDist = totalDist + parseInt(route.legs[i].distance.value);
		}
		$('.distance-km').text(totalDist / 1000 + '  KM');
		var renderer = new google.maps.DirectionsRenderer;
		renderer.setMap(map);
		renderer.setOptions({
			suppressMarkers : true,
			preserveViewport : true
		});
		renderer.setDirections(response);
	};

	// Send requests to service to get route (for stations count <= 25 only one
	// request will be sent)
	for (var i = 0; i < parts.length; i++) {
		// Waypoints does not include first station (origin) and last station
		// (destination)
		var waypoints = [];
		for (var j = 1; j < parts[i].length - 1; j++)
			waypoints.push({
				location : new google.maps.LatLng(Number(parts[i][j].latitude),
						Number(parts[i][j].longitude)),
				stopover : false
			});
		// Service options
		var service_options = {
			origin : new google.maps.LatLng(Number(parts[i][0].latitude),
					Number(parts[i][0].longitude)),
			destination : new google.maps.LatLng(
					Number(parts[i][parts[i].length - 1].latitude),
					Number(parts[i][parts[i].length - 1].longitude)),
			waypoints : waypoints,
			travelMode : 'DRIVING'
		};
		// Send request
		service.route(service_options, service_callback);
	}
}

// start point of track
function getStartLocationName(longitude, latitude) {
	$.ajax({
		type : "GET",
		url : 'http://maps.googleapis.com/maps/api/geocode/json?latlng='
				+ latitude + ',' + longitude + '&sensor=false',
		processData : false,
		async : true,
		contentType : false,
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == 'OK') {
				$('.startpoint').text(result.results[0].formatted_address);
			} else {
				$('.startpoint').text('');
			}
		},
	});
}

// end point of track
function getEndLocationName(longitude, latitude) {
	$.ajax({
		type : "GET",
		url : 'http://maps.googleapis.com/maps/api/geocode/json?latlng='
				+ latitude + ',' + longitude + '&sensor=false',
		processData : false,
		async : true,
		contentType : false,
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == 'OK') {
				$('.endpoint').text(result.results[0].formatted_address);
			} else {
				$('.endpoint').text('');
			}
		},
	});
}