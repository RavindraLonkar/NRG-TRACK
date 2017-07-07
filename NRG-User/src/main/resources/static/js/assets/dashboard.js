function myMap() {
	var myCenter = new google.maps.LatLng(51.508742, -0.120850);
	var mapCanvas = document.getElementById("googleMap");
	var mapOptions = {
		center : myCenter,
		zoom : 5
	};
	var map = new google.maps.Map(mapCanvas, mapOptions);
	var marker = new google.maps.Marker({
		position : myCenter,
		animation: google.maps.Animation.BOUNCE
	});
	marker.setMap(map);
}
