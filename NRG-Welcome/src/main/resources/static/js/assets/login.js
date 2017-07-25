function passwordRequest() {
	$('#forgotpass').modal('show');
}
$(document).ready(function() {
	var validation = false;
	$("#Passwordrequest").click(function(event) {
		var validation = forgotformvalidation();
		if (validation == true) {
			$.ajax({
				type : "POST",
				enctype : 'multipart/form-data',
				url : url + "upload?objectName=" + objectName,
				data : data,
				processData : false, // prevent jQuery from automatically
				// transforming the data into a query string
				contentType : false,
				cache : false,
				timeout : 600000,
				success : function(result) {
					if (result.status == '1') {

					} else {

					}
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
		}

	});
});