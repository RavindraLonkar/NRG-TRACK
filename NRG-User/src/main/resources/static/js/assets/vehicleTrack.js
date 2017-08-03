$( document ).ready(function() {
	var url = window.location;
	$.ajax({
		type : "GET",
		url : url.origin + "/NRG-User/vehicles/list",
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
});

function initMap() {
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 6,
          center: {lat: 41.85, lng: -87.65}
        });
        directionsDisplay.setMap(map);

        document.getElementById('submit').addEventListener('click', function() {
        	getCoordinates(directionsService, directionsDisplay);
        });
      }

		function getCoordinates(directionsService, directionsDisplay){
			var vehicleId=document.getElementById("vehicleId"); 
			$.ajax({
    	         type : "GET",
    	        // url : url.host + "/NRG-User/vehicleList",
    	         url : "http://localhost:8080/NRG-User/vehicles/trackingCoordinates?vehicleId="+vehicleId,
    	         // data : data,
    	         processData: false, // prevent jQuery from automatically
										// transforming the data into a query
										// string
    	         contentType: false,
    	         cache: false,
    	         timeout: 600000,
    	         success : function(result) {
    	          if(result.status=='success'){
    	           if(jQuery.isEmptyObject(result))
    	               return;
    	            
    	           list=result.data;
    	           calculateAndDisplayRoute(directionsService, directionsDisplay,list)
    	          }else{
    	          // BootstrapDialog.alert(result.resonCode);
    	          } 
    	         },
    	         /*
					 * error : function(e) { $("#"+objectName+"").hide();
					 * console.log("ERROR: ", e); }
					 */
    	     });
		}

      function calculateAndDisplayRoute(directionsService, directionsDisplay,list) {
    	  var waypts = [];
    	  var list;
    	  
    	  var start=list[0].longitude+','+list[0].latitude;
    	  var end=list[list.length-1].longitude+','+list[list.length-1].latitude;
    	  
        for (var i = 1; i < list.length-1; i++) {
          
            waypts.push({
              location: list[i].longitude+','+list[i].latitude,
              stopover: false 	
            });
          
        }

        directionsService.route({
         // origin: "Halifax, NS",
        	origin:start,
         // destination: "Vancouver, BC",
        	destination:end,
          waypoints: waypts,
          optimizeWaypoints: true,
          travelMode: 'DRIVING'
        }, function(response, status) {
          if (status === 'OK') {
            directionsDisplay.setDirections(response);
            var route = response.routes[0];
            var summaryPanel = document.getElementById('directions-panel');
            summaryPanel.innerHTML = '';
            var totalDist=0;
            for (var i = 0; i < route.legs.length; i++) {
                var routeSegment = i + 1;
                totalDist=totalDist+parseInt(route.legs[i].distance.value);
            }
            
            summaryPanel.innerHTML ='<h3>Total Dist cover:-'+totalDist/1000+'Km</h3>';
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
      }