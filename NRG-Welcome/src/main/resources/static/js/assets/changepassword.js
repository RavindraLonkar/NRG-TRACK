$(document).ready(function() {
	var validation = false;
	var url = window.location;
	$("#resetpassword").click(function(event) {
		var validation = changePasswordFormValidation();
		if (validation == true) {

			var user = new Object();
			user.token = $('#token').val();
			user.password = $('#password').val();

			var jsonUser = JSON.stringify(user);
			$.ajax({
				type : "POST",
				url : url.origin + "/NRG-Welcome/changepassword",
				contentType : 'application/json',
				data : jsonUser,
				processData : false, // prevent jQuery from automatically
				// transforming the data into a query string
				cache : false,
				timeout : 600000,
				success : function(result) {
					if (result.status == '1') {
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