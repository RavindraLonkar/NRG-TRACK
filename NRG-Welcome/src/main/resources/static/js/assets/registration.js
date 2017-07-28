$(document).ready(function() {
	var validation = false;
	var url = window.location;
	$("#signuprequest").click(function(event) {
		var validation = registrationformvalidation();
		if (validation == true) {

			var user = new Object();
			user.firstname = $('#firstname').val();
			user.lastname = $('#lastname').val();
			user.emailid = $('#emailid').val();
			user.contactmobile = $('#contactNo').val();
			user.password = $('#password').val();

			var jsonUser = JSON.stringify(user);
			$.ajax({
				type : "POST",
				url : url.origin + "/NRG-Welcome/registration",
				contentType : 'application/json',
				data : jsonUser,
				processData : false, // prevent jQuery from automatically
				// transforming the data into a query string
				cache : false,
				timeout : 600000,
				success : function(result) {
					if (result.status == '0') {
						$('#email_error').removeClass('hide');
						$('#email_error').html(result.resonCode);
					} else {
						BootstrapDialog.alert(result.resonCode);
					}
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
		}

	});
});