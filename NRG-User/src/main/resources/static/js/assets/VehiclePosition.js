$( document ).ready(function() {
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
				$(dataSet).each(function(i,obj) {
    				var vehicleid=obj.vehicleid;
    				var vechiclename=obj.vechiclename;
    				var vechiclenumber=obj.vechiclenumber;		
    					$('#vehicleId').append('<option value="'+vehicleid+'">'+vechiclename+ '/ '+ vechiclenumber+'</option>');
    			});	
			} 
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});	

	 $('#vehicleTrackDate').datetimepicker({
		 format: 'DD/MM/YYYY hh:mm:ss'
	 });
});

/*function myMap() {
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
	
	 document.getElementById('submit').addEventListener('click', function() {
		 setMarkers(map);
	 });
	
}

function setMarkers(map) {
	
	var url = window.location;
	//var data;
	 $.ajax({
         type : "GET",
        // url : url.host + "/NRG-User/vehicleList",
         url : "http://localhost:8080/NRG-User/vehiclePosition",
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
         error : function(e) {
          $("#"+objectName+"").hide();
             console.log("ERROR: ", e);
         }
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
	}
	
*/
function myMap() {
	document.getElementById('submit').addEventListener('click', function() {
		var vehicleId=$("#vehicleId").val(); 
		var trackDate=$("#trackDate").val(); 
		 $.ajax({
	         type : "GET",
	         url : "http://localhost:8080/NRG-User/vehicle/date/position?vehicleId="+vehicleId+"&trackDate="+trackDate,
	         processData: false, 
	         contentType: false,
	         cache: false,
	         timeout: 600000,
	         success : function(result) {
	          if(result.status == '1'){
	           if(jQuery.isEmptyObject(result))
	               return;
	            
	           initMap(result.data);
	          }else{
	          } 
	         },
	         error : function(e) {
	 			console.log("ERROR: ", e);
	 		}
	     });
	 });
	
}


function initMap(data) {
	    var lon=parseFloat(data[0].longitude);
	    var lat=parseFloat(data[0].latitude);
        var map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: lat, lng: lon},
          zoom: 15
        });

        var infowindow = new google.maps.InfoWindow();
        var service = new google.maps.places.PlacesService(map);

        service.getDetails({
          placeId: 'ChIJN1t_tDeuEmsRUsoyG83frY4'
        }, function(place, status) {
          if (status === google.maps.places.PlacesServiceStatus.OK) {
            var marker = new google.maps.Marker({
              map: map,
              position: place.geometry.location
            });
            google.maps.event.addListener(marker, 'click', function() {
              infowindow.setContent('<div><strong>' + place.name + '</strong><br>' +
                'Place ID: ' + place.place_id + '<br>' +
                place.formatted_address + '</div>');
              infowindow.open(map, this);
            });
          }
        });
      }