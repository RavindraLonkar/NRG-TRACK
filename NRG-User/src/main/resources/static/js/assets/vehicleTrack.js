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
       	//map();
	    //mapId=document.getElementById('map')
        document.getElementById('submit').addEventListener('click', function() {
        	getCoordinates();
        	//initialize();
        });
      }

		function getCoordinates(){
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
    	           //calculateAndDisplayRoute(directionsService, directionsDisplay,list)
    	           initialize(list);
    	          }else{
    	          // BootstrapDialog.alert(result.resonCode);
    	          } 
    	         },
    	         
    	     });
		}

		 function initialize(stations) {
			    var service = new google.maps.DirectionsService;
			    var map = new google.maps.Map(document.getElementById('map'));

			   /* var stations=[];
			    for (var i = 0; i < stations.length; i++){
			    	stations.push({lat: Number(station.latitude), Number(station.longitude), name: 'Station'})
			    }*/
			    
			   /* // list of points
			    var stations = [
			        {lat: 48.9812840, lng: 21.2171920, name: 'Station 1'},
			        {lat: 48.9832841, lng: 21.2176398, name: 'Station 2'},
			        {lat: 48.9856443, lng: 21.2209088, name: 'Station 3'},
			        {lat: 48.9861461, lng: 21.2261563, name: 'Station 4'},
			        {lat: 48.9874682, lng: 21.2294855, name: 'Station 5'},
			        {lat: 48.9909244, lng: 21.2295512, name: 'Station 6'},
			        {lat: 48.9928871, lng: 21.2292352, name: 'Station 7'},
			        {lat: 48.9921334, lng: 21.2246742, name: 'Station 8'},
			        {lat: 48.9943196, lng: 21.2234792, name: 'Station 9'},
			        {lat: 48.9966345, lng: 21.2221262, name: 'Station 10'},
			        {lat: 48.9981191, lng: 21.2271386, name: 'Station 11'},
			        {lat: 49.0009168, lng: 21.2359527, name: 'Station 12'},
			        {lat: 49.0017950, lng: 21.2392890, name: 'Station 13'},
			        {lat: 48.9991912, lng: 21.2398272, name: 'Station 14'},
			        {lat: 48.9959850, lng: 21.2418410, name: 'Station 15'},
			        {lat: 48.9931772, lng: 21.2453901, name: 'Station 16'},
			        {lat: 48.9963512, lng: 21.2525850, name: 'Station 17'},
			        {lat: 48.9985134, lng: 21.2508423, name: 'Station 18'},
			        {lat: 49.0085000, lng: 21.2508000, name: 'Station 19'},
			        {lat: 49.0093000, lng: 21.2528000, name: 'Station 20'},
			        {lat: 49.0103000, lng: 21.2560000, name: 'Station 21'},
			        {lat: 49.0112000, lng: 21.2590000, name: 'Station 22'},
			        {lat: 49.0124000, lng: 21.2620000, name: 'Station 23'},
			        {lat: 49.0135000, lng: 21.2650000, name: 'Station 24'},
			        {lat: 49.0149000, lng: 21.2680000, name: 'Station 25'},
			        {lat: 49.0171000, lng: 21.2710000, name: 'Station 26'},
			        {lat: 49.0198000, lng: 21.2740000, name: 'Station 27'},
			        {lat: 49.0305000, lng: 21.3000000, name: 'Station 28'},
			        // ... as many other stations as you need
			    ];*/

			    // Zoom and center map automatically by stations (each station will be in visible map area)
			    var lngs = stations.map(function(station) { return Number(station.longitude); });
			    var lats = stations.map(function(station) { return Number(station.latitude); });
			    map.fitBounds({
			        west: Math.min.apply(null, lngs),
			        east: Math.max.apply(null, lngs),
			        north: Math.min.apply(null, lats),
			        south: Math.max.apply(null, lats),
			    });

			    // Show stations on the map as markers
			    for (var i = 0; i < stations.length; i++) {
			        new google.maps.Marker({
			        	 position: new google.maps.LatLng( Number(stations[i].latitude), Number(stations[i].longitude)),
			            map: map,
			            title: stations[i].name
			        });
			    }

			    // Divide route to several parts because max stations limit is 25 (23 waypoints + 1 origin + 1 destination)
			    for (var i = 0, parts = [], max = 25 - 1; i < stations.length; i = i + max)
			        parts.push(stations.slice(i, i + max + 1));

			    // Service callback to process service results
			    var service_callback = function(response, status) {
			        if (status != 'OK') {
			            console.log('Directions request failed due to ' + status);
			            return;
			        }
			        var renderer = new google.maps.DirectionsRenderer;
			        renderer.setMap(map);
			        renderer.setOptions({ suppressMarkers: true, preserveViewport: true });
			        renderer.setDirections(response);
			    };

			    // Send requests to service to get route (for stations count <= 25 only one request will be sent)
			    for (var i = 0; i < parts.length; i++) {
			        // Waypoints does not include first station (origin) and last station (destination)
			        var waypoints = [];
			        for (var j = 1; j < parts[i].length - 1; j++)
			            waypoints.push({location: new google.maps.LatLng(Number(parts[i][j].latitude),Number(parts[i][j].longitude)), stopover: false});
			        // Service options
			        var service_options = {
			            origin: new google.maps.LatLng(Number(parts[i][0].latitude),Number(parts[i][0].longitude)),
			            destination: new google.maps.LatLng(Number(parts[i][parts[i].length - 1].latitude),Number(parts[i][parts[i].length - 1].longitude)),
			            waypoints: waypoints,
			            travelMode: 'WALKING'
			        };
			        // Send request
			        service.route(service_options, service_callback);
			    }
			  }
		
		
		
		
		/*function initialize(list) {
			
			var geocoder;
			var map;
			var directionsDisplay;
			var directionsService = new google.maps.DirectionsService();
			  var locations = [
			    ['Manly Beach', 18.59215508481379, 73.76440107822418, 1],
			    ['Bondi Beach', 18.591585624322512, 73.76614987850189, 2],
			    ['Coogee Beach', 18.590202640917642, 73.76954019069672, 5],
			    ['Maroubra Beach', 18.589328101499035, 73.77563416957855, 1],
			    ['Cronulla Beach', 18.591829679051905, 73.78427624702454, 3],
			    ['Tamarama Beach', 18.591590708799604, 73.78585070371628, 6],
			    ['Tamarama Beach', 18.58837220444094, 73.78888964653015, 6],
			    ['Tamarama Beach', 18.586053623337936, 73.79203855991364, 6],
			    ['Tamarama Beach', 18.58310450529598, 73.79659295082092, 6],
			    ['Tamarama Beach', 18.58152314684282, 73.79833370447159, 6]
								   
			  ];
			  directionsDisplay = new google.maps.DirectionsRenderer();


			  var map = new google.maps.Map(document.getElementById('map'), {
			    zoom: 10,
			    center: new google.maps.LatLng(-33.92, 151.25),
			    mapTypeId: google.maps.MapTypeId.ROADMAP
			  });
			  directionsDisplay.setMap(map);
			  var infowindow = new google.maps.InfoWindow();

			  var marker, i;
			  var request = {
			    travelMode: google.maps.TravelMode.DRIVING
			  };
			  for (i = 0; i < list.length; i++) {
			    marker = new google.maps.Marker({
			      position: new google.maps.LatLng( list[i].latitude, list[i].longitude),
			      map: map
			    });

			    google.maps.event.addListener(marker, 'click', (function(marker, i) {
			      return function() {
			        infowindow.setContent(locations[i][0]);
			        infowindow.open(map, marker);
			      }
			    })(marker, i));
			    if (i == 0) request.origin = marker.getPosition();
			    else if (i == locations.length - 1) request.destination = marker.getPosition();
			    else {
			      if (!request.waypoints) request.waypoints = [];
			      request.waypoints.push({
			        location: marker.getPosition(),
			        stopover: true
			      });
			    }

			  }
			  directionsService.route(request, function(result, status) {
			    if (status == google.maps.DirectionsStatus.OK) {
			      directionsDisplay.setDirections(result);
			    }
			  });
			}*/
		
		
		
		/*function map2(){
			var geocoder;
					var map;
					var directionsDisplay;
					var directionsService = new google.maps.DirectionsService();
					  var locations = [
					    ['Manly Beach', 18.59215508481379, 73.76440107822418, 1],
					    ['Bondi Beach', 18.591585624322512, 73.76614987850189, 2],
					    ['Coogee Beach', 18.590202640917642, 73.76954019069672, 5],
					    ['Maroubra Beach', 18.589328101499035, 73.77563416957855, 1],
					    ['Cronulla Beach', 18.591829679051905, 73.78427624702454, 3],
					    ['Tamarama Beach', 18.591590708799604, 73.78585070371628, 6],
					    ['Tamarama Beach', 18.58837220444094, 73.78888964653015, 6],
					    ['Tamarama Beach', 18.586053623337936, 73.79203855991364, 6],
					    ['Tamarama Beach', 18.58310450529598, 73.79659295082092, 6],
					    ['Tamarama Beach', 18.58152314684282, 73.79833370447159, 6]
										   
					  ];

					function initialize() {
					  directionsDisplay = new google.maps.DirectionsRenderer();


					  var map = new google.maps.Map(document.getElementById('map'), {
					    zoom: 10,
					    center: new google.maps.LatLng(-33.92, 151.25),
					    mapTypeId: google.maps.MapTypeId.ROADMAP
					  });
					  directionsDisplay.setMap(map);
					  var infowindow = new google.maps.InfoWindow();

					  var marker, i;
					  var request = {
					    travelMode: google.maps.TravelMode.DRIVING
					  };
					  for (i = 0; i < locations.length; i++) {
					    marker = new google.maps.Marker({
					      position: new google.maps.LatLng(locations[i][1], locations[i][2]),
					      map: map
					    });

					    google.maps.event.addListener(marker, 'click', (function(marker, i) {
					      return function() {
					        infowindow.setContent(locations[i][0]);
					        infowindow.open(map, marker);
					      }
					    })(marker, i));
					    if (i == 0) request.origin = marker.getPosition();
					    else if (i == locations.length - 1) request.destination = marker.getPosition();
					    else {
					      if (!request.waypoints) request.waypoints = [];
					      request.waypoints.push({
					        location: marker.getPosition(),
					        stopover: true
					      });
					    }

					  }
					  directionsService.route(request, function(result, status) {
					    if (status == google.maps.DirectionsStatus.OK) {
					      directionsDisplay.setDirections(result);
					    }
					  });
					}
					//google.maps.event.addDomListener(window, "click", initialize);

					}*/


		
		
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