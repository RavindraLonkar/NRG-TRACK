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

	 $('#startDate').datetimepicker({
		 format: 'DD/MM/YYYY hh:mm:ss'
	 });
     $('#endDate').datetimepicker({
         useCurrent: false,
         format: 'DD/MM/YYYY hh:mm:ss'
     });
     $("#startDate").on("dp.change", function (e) {
         $('#endDate').data("DateTimePicker").minDate(e.date);
     });
     $("#datetimepicker7").on("dp.change", function (e) {
         $('#startDate').data("DateTimePicker").maxDate(e.date);
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
			var url=window.location;
			var vehicleId=$("#vehicleId").val(); 
			var startDate=$("#trackStartDate").val(); 
			var endDate=$("#trackEndDate").val(); 	
			$.ajax({
    	         type : "GET",
    	         url : url.origin + "/NRG-User/vehicle/trackingCoordinatesByDate?vehicleId="+vehicleId+"&startDate="+startDate+"&endDate="+endDate,
    	         processData: false, 
    	         contentType: false,
    	         cache: false,
    	         timeout: 600000,
    	         success : function(result) {
    	          if(result.status=='1'){
    	           if(jQuery.isEmptyObject(result))
    	               return;
    	            
    	           list=result.data;
    	           calculateAndDisplayRoute(directionsService, directionsDisplay,list)
    	          }else{
    	          // BootstrapDialog.alert(result.resonCode);
    	          } 
    	         },
    	         
    	     });
		}

      function calculateAndDisplayRoute(directionsService, directionsDisplay,list) {
    	  var waypts = [];
    	  getStartLocationName(list[0].longitude,list[0].latitude);
    	  getEndLocationName(list[list.length-1].longitude,list[list.length-1].latitude);
    	  var start=list[0].latitude+','+list[0].longitude;
    	  var end=list[list.length-1].latitude+','+list[list.length-1].longitude;
    	  
        for (var i = 1; i < list.length-1; i++) {
          
            waypts.push({
              location: list[i].latitude+','+list[i].longitude,
              stopover: false 	
            });
          
        }

        directionsService.route({
        	origin:start,
        	destination:end,
          waypoints: waypts,
          optimizeWaypoints: true,
          travelMode: 'DRIVING'
        }, function(response, status) {
          if (status === 'OK') {
            directionsDisplay.setDirections(response);
            var route = response.routes[0];
            $('.distance-km').text('');
            var totalDist=0;
            for (var i = 0; i < route.legs.length; i++) {
                var routeSegment = i + 1;
                totalDist=totalDist+parseInt(route.legs[i].distance.value);
            }
            $('.distance-km').text(totalDist/1000+'  KM');
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
      }
      

      //start point of track
     function getStartLocationName(longitude,latitude) {
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
				}else{
					$('.startpoint').text('');
				}
			},
		});
}
     
     //end point of track
     function getEndLocationName(longitude,latitude) {
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
				}else{
					$('.endpoint').text('');
				}
			},
		});
}    