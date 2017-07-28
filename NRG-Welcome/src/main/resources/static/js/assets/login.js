function passwordRequest() {
	$('#forgotpass').modal('show');
}
$(document).ready(function() {
	var validation = false;
	var url=window.location;
	$("#Passwordrequest").click(function(event) {
		var validation = forgotformvalidation();
		if (validation == true) {
			$.ajax({
				type : "GET",
				url : url.origin + "/NRG-Welcome/passwordrequest?emailid=" +$('#emailid').val() ,
				processData : false, // prevent jQuery from automatically
				// transforming the data into a query string
				contentType : false,
				cache : false,
				timeout : 600000,
				success : function(result) {
					if (result.status == '1') {
						$('#email_error').addClass('hide');
						$('#forgotpass').modal('hide');
						$('#emailid').val('');
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