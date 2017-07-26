$(document).ready(function() {
	var validation = false;
	var url = window.location;
	$("#signuprequest").click(function(event) {
		var validation = registrationformvalidation();
		if (validation == true) {
			  x = $("registration").serializeArray();
			$.ajax({
				type : "POST",
				url : url.origin + "/NRG-Welcome/registration",
				data :  x ,
				accepts : 'application/json',
				processData : false, // prevent jQuery from automatically
				// transforming the data into a query string
				cache : false,
				timeout : 600000,
				success : function(result) {
					if (result.status == '1') {
						$('#email_error').addClass('hide');
						BootstrapDialog.alert(result.resonCode);
					} else {
						$('#email_error').removeClass('hide');
						$('#email_error').html(result.resonCode);
					}
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
		}

	});
});