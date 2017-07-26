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

/*var beaches = [ [ 'Bondi Beach', 22.890542, 77.274856, 4 ],
		[ 'Coogee Beach', 22.00, 77.259052, 5 ],
		[ 'Cronulla Beach', 22.028249, 77.157507, 3 ],
		[ 'Manly Beach', 22.80010128657071, 77.28747820854187, 2 ],
		[ 'Maroubra Beach', 22.950198, 77.259302, 1 ] ];
*/
//var vehicles = "${vehicleList}";

function setMarkers(map) {
	
	var url = window.location;
	//var data;
	 $.ajax({
         type : "GET",
        // url : url.host + "/NRG-User/vehicleList",
         url : "http://localhost:8080/NRG-User/vehicleList",
         //data : data,
         processData: false, //prevent jQuery from automatically transforming the data into a query string
         contentType: false,
         cache: false,
         timeout: 600000,
         success : function(result) {
          if(result.status=='success'){
           if(jQuery.isEmptyObject(result))
               return;
            
           loadMap(result.data,map);
          }else{
          // BootstrapDialog.alert(result.resonCode);
          } 
         },
         /*error : function(e) {
          $("#"+objectName+"").hide();
             console.log("ERROR: ", e);
         }*/
     });
	
}
	function loadMap(list,map){
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
	for (var i = 0; i < list.length; i++) {
		var vehicle = list[i];
		var marker = new google.maps.Marker({
			position : {
				lat : parseFloat(vehicle.longitude),
				lng : parseFloat(vehicle.latitude)
			},
			map : map,
			icon : image,
			shape : shape,
			title : vehicle.vehicleNumber,
			zIndex :parseInt(vehicle.index)
		});

		marker.infowindow = new google.maps.InfoWindow({
			content : vehicle.vehicleNumber
		});
		google.maps.event.addListener(marker, 'click', function() {
			this.infowindow.open(map, this);
		});
	}

	//*********************************************************************
	  // Track vehicle 
	//*********************************************************************
	function initMap() {
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 6,
          center: {lat: 41.85, lng: -87.65}
        });
        directionsDisplay.setMap(map);

        document.getElementById('submit').addEventListener('click', function() {
          calculateAndDisplayRoute(directionsService, directionsDisplay);
        });
      }

      function calculateAndDisplayRoute(directionsService, directionsDisplay) {
        var waypts = [];
        var checkboxArray = document.getElementById('waypoints');
        for (var i = 0; i < checkboxArray.length; i++) {
          if (checkboxArray.options[i].selected) {
            waypts.push({
              location: checkboxArray[i].value,
              stopover: true
            });
          }
        }

        directionsService.route({
          origin: document.getElementById('start').value,
          destination: document.getElementById('end').value,
          waypoints: waypts,
          optimizeWaypoints: true,
          travelMode: 'DRIVING'
        }, function(response, status) {
          if (status === 'OK') {
            directionsDisplay.setDirections(response);
            var route = response.routes[0];
            var summaryPanel = document.getElementById('googleMap');
            summaryPanel.innerHTML = '';
            // For each route, display summary information.
            for (var i = 0; i < route.legs.length; i++) {
              var routeSegment = i + 1;
              summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
                  '</b><br>';
              summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
              summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
              summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
            }
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
      }
	
	}
