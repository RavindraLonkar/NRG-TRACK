$(document).ready(function() {
	var validation = false;
	var url = window.location;
	$("#resetpassword").click(function(event) {
		var validation = changePasswordFormValidation();
		if (validation == true) {

			var user = {
				token : $('#token').val(),
				password : $('#password').val()
			}

			var jsonUser = JSON.stringify(user);
			$.ajax({
				type : "POST",
				url : url.origin + "/NRG-Welcome/changepassword",
				contentType : 'application/json',
				data : jsonUser,
				processData : false,
				cache : false,
				timeout : 600000,
				success : function(result) {
					if (result.status == '0') {
						bootMessage('Error',result.resonCode);
					} else {
						bootMessageRedirect('sucess','Ok',url.origin + "/NRG-Welcome/login")
					}
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
		}

	});

});