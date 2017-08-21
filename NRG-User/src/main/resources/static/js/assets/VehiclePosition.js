$(document).ready(
		function() {
			var url = window.location;
			$.ajax({
				type : "GET",
				url : $("#contextPath").val() + "/vehicle/tracker/list",
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

			$('#vehicleTrackDate').datetimepicker({
				format : 'DD/MM/YYYY HH:mm:ss',
				ignoreReadonly : true
			});
			
			 $("#vehicleTrackDate").on("dp.change", function (e) {
				  jQuery('#vehicleTrackDate').data("DateTimePicker").maxDate(new Date());
			     });
		});

function myMap() {
	document.getElementById('submit').addEventListener(
			'click',
			function() {

				var validation = false;
				var validation = positionFormValidation();
				if (validation == false)
					return;

				var vehicleId = $("#vehicleId").val();
				var trackDate = $("#trackDate").val();
				$.ajax({
					type : "GET",
					url : $("#contextPath").val()
							+ "/vehicle/date/position?vehicleId=" + vehicleId
							+ "&trackDate=" + trackDate,
					processData : false,
					contentType : false,
					cache : false,
					timeout : 600000,
					success : function(result) {
						if (result.status == '1') {
							if (jQuery.isEmptyObject(result))
								return;

							initMap(result.data);
						} else {
						}
					},
					error : function(e) {
						console.log("ERROR: ", e);
					}
				});
			});

}

function initMap(data) {
	var lon = parseFloat(data[0].longitude);
	var lat = parseFloat(data[0].latitude);
	var map = new google.maps.Map(document.getElementById('map'), {
		center : {
			lat : lat,
			lng : lon
		},
		zoom : 20
	});

	var geocoder = new google.maps.Geocoder;
	var infowindow = new google.maps.InfoWindow;
	geocodeLatLng(geocoder, map, infowindow, lat + ',' + lon);

}
function geocodeLatLng(geocoder, map, infowindow, latlng) {
	var input = latlng;
	var latlngStr = input.split(',', 2);
	var latlng = {
		lat : parseFloat(latlngStr[0]),
		lng : parseFloat(latlngStr[1])
	};
	geocoder.geocode({
		'location' : latlng
	}, function(results, status) {
		if (status === 'OK') {
			if (results[0]) {
				map.setZoom(11);
				var marker = new google.maps.Marker({
					position : latlng,
					map : map
				});
				$('.position').text(results[0].formatted_address);
				infowindow.setContent(results[0].formatted_address);
				infowindow.open(map, marker);
			} else {
				$('.position').text('');
				window.alert('No results found');
			}
		} else {
			$('.position').text('');
			window.alert('Geocoder failed due to: ' + status);
		}
	});
}

function positionFormValidation() {
	addclassHide();
	var validation = true;

	// vehicle select
	if ($.trim($('#vehicleId').val()) == '0') {
		$('#vehicleId_error').removeClass('hide');
		$('#vehicleId_error').html("Please select Vehicle.");
		validation = false;
	}

	// date select
	if ($.trim($('#trackDate').val()) == '') {
		$('#trackDate_error').removeClass('hide');
		$('#trackDate_error').html("Please select Date.");
		validation = false;
	}
	return validation;
}

function addclassHide() {

	$('#vehicleId_error').addClass('hide');
	$('#trackDate_error').addClass('hide');

	$('#vehicleId_error').html('');
	$('#trackDate_error').html('');
}
