$(document).ready(function() {
	$.ajax({
		type : "GET",
		url : $("#contextPath").val() + "/notification/list",
		processData : false,
		contentType : false,
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == '1') {
				if (jQuery.isEmptyObject(result))
					return;
				var notificationcount;
				var dataSet = result.data;
				$(dataSet).each(function(i,obj) {
    				var insurancename=obj.insurancename;
    				var vechiclename=obj.vechiclename;
    				var vechiclenumber=obj.vechiclenumber;
    				var enddate=obj.enddate;
    				var remainingdays=obj.remainingdays;
    				notificationcount=obj.notificationcount;
    				var startdate=obj.startdate;
    				$('#notificationdetails').append('<li><a href="#" onClick ="showNotification('+vechiclename+','+vechiclenumber+','+enddate+','+insurancename+');"> <span class="label label-primary"><i class="icon_profile"></i></span>' +vechiclename+'/'+vechiclenumber+'</a></li>');
    			});
				
				$('#notificationCount').html(notificationcount);
				$('#notifCount').html("You have "+notificationcount+" new notifications");
				 	
				
				
				
			} else {
			}
		},
	});
	
	function showNotification(vechiclename,vechiclenumber,enddate,insurancename){
	
	}
	
});

