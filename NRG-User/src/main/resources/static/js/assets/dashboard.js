function myMap() {
	var latLong = new google.maps.LatLng(51.508742, -0.120850);
	var mapCanvas = document.getElementById("googleMap");
	var mapOptions = {
		center : {
			lat : 22.0,
			lng : 77.0
		},
		zoom : 5
	};
	var map = new google.maps.Map(mapCanvas, mapOptions);
	setMarkers(map);
}

function setMarkers(map) {

	var url = window.location;
	$.ajax({
		type : "GET",
		url : $("#contextPath").val() + "/vehicle/current/Position",
		processData : false,
		contentType : false,
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == '1') {
				if (jQuery.isEmptyObject(result))
					return;

				loadMap(result.data, map);
			} else {
			}
		},
	});

}
function loadMap(list, map) {
	var image = {
		url : './img/vehicle.jpg',
		size : new google.maps.Size(40, 20),
		origin : new google.maps.Point(0, 0),
		anchor : new google.maps.Point(0, 35)
	};
	var shape = {
		coords : [ 1, 1, 1, 20, 18, 20, 18, 1 ],
		type : 'poly'
	};
	for (var i = 0; i < list.length; i++) {
		var vehicle = list[i];
		var vehiclenumber = vehicle.vehiclenumber;
		var vehiclename = vehicle.vehiclename;
		var location = '';
		var marker = '';
		var title = '';
		$
				.ajax({
					type : "GET",
					url : 'http://maps.googleapis.com/maps/api/geocode/json?latlng='
							+ vehicle.latitude
							+ ','
							+ vehicle.longitude
							+ '&sensor=false',
					processData : false,
					async : false,
					contentType : false,
					cache : false,
					timeout : 600000,
					success : function(result) {
						if (result.status == 'OK') {
							location = result.results[0].formatted_address;
						}
						title = "<html><head></head><body><table border='1'><tr><td>Vehicle No:</td><td> "
								+ vehiclenumber
								+ "</td></tr><tr><td> Vehicle Name:</td><td> "
								+ vehiclename
								+ "</td></tr><tr><td> Location Name:</td><td> "
								+ location + "</td></tr></table></body></html>";
						marker = new google.maps.Marker({
							position : {
								lat : parseFloat(vehicle.latitude),
								lng : parseFloat(vehicle.longitude)
							},
							map : map,
							icon : image,
							shape : shape,
							title : vehicle.vehiclenumber,
							zIndex : parseInt(1)
						});

						marker.infowindow = new google.maps.InfoWindow({
							content : title
						});
						google.maps.event.addListener(marker, 'click',
								function() {
									this.infowindow.open(map, this);
								});
					},
				});

	}
}