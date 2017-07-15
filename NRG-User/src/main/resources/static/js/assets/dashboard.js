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
	/*
	 * var marker = new google.maps.Marker({ position : latLong, animation :
	 * google.maps.Animation.BOUNCE });
	 */
	setMarkers(map);
	/* marker.setMap(map); */
}

var beaches = [ [ 'Bondi Beach', 22.890542, 77.274856, 4 ],
		[ 'Coogee Beach', 22.00, 77.259052, 5 ],
		[ 'Cronulla Beach', 22.028249, 77.157507, 3 ],
		[ 'Manly Beach', 22.80010128657071, 77.28747820854187, 2 ],
		[ 'Maroubra Beach', 22.950198, 77.259302, 1 ] ];

function setMarkers(map) {
	// Adds markers to the map.

	// Marker sizes are expressed as a Size of X,Y where the origin of the image
	// (0,0) is located in the top left of the image.

	// Origins, anchor positions and coordinates of the marker increase in the X
	// direction to the right and in the Y direction down.
	var image = {
		url : './img/vehicle.jpg',
		// This marker is 20 pixels wide by 32 pixels high.
		size : new google.maps.Size(40, 20),
		// The origin for this image is (0, 0).
		origin : new google.maps.Point(0, 0),
		// The anchor for this image is the base of the flagpole at (0, 32).
		anchor : new google.maps.Point(0, 35)
	};
	// Shapes define the clickable region of the icon. The type defines an HTML
	// <area> element 'poly' which traces out a polygon as a series of X,Y
	// points.
	// The final coordinate closes the poly by connecting to the first
	// coordinate.
	var shape = {
		coords : [ 1, 1, 1, 20, 18, 20, 18, 1 ],
		type : 'poly'
	};
	for (var i = 0; i < beaches.length; i++) {
		var beach = beaches[i];
		var marker = new google.maps.Marker({
			position : {
				lat : beach[1],
				lng : beach[2]
			},
			map : map,
			icon : image,
			shape : shape,
			title : beach[0],
			zIndex : beach[3]
		});

		marker.infowindow = new google.maps.InfoWindow({
			content : beach[0]
		});
		google.maps.event.addListener(marker, 'click', function() {
			this.infowindow.open(map, this);
		});
	}
}
