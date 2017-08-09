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
         url : "http://localhost:8080/NRG-User/vehicle/current/Position",
         //data : data,
         processData: false, //prevent jQuery from automatically transforming the data into a query string
         contentType: false,
         cache: false,
         timeout: 600000,
         success : function(result) {
          if(result.status=='1'){
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
		var marker = new google.maps.Marker({
			position : {
				lat : parseFloat(vehicle.longitude),
				lng : parseFloat(vehicle.latitude)
			},
			map : map,
			icon : image,
			shape : shape,
			title : vehicle.vehiclenumber,
			zIndex :parseInt(i+1)
		});

		marker.infowindow = new google.maps.InfoWindow({
			content : vehicle.vehiclenumber
		});
		google.maps.event.addListener(marker, 'click', function() {
			this.infowindow.open(map, this);
		});
	}
	}
	
