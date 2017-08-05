$('#image_click').click(function() {
	$('#file_click').click();
});

$('#file_click').change(
		function() {

			var extensionToCheck = $('#file_click').val().substring(
					($('#file_click').val().lastIndexOf('.') + 1));

			if (extensionToCheck != '') {
				if (extensionToCheck == 'jpg' || extensionToCheck == 'jpeg'
						|| extensionToCheck == 'png'
						|| extensionToCheck == 'gif'
						|| extensionToCheck == 'ioc'
						|| extensionToCheck == 'bmp'
						|| extensionToCheck == 'psd'
						|| extensionToCheck == 'tif'
						|| extensionToCheck == 'pspimage'
						|| extensionToCheck == 'thm'
						|| extensionToCheck == 'yuv'
						|| extensionToCheck == 'ai'
						|| extensionToCheck == 'drw'
						|| extensionToCheck == 'eps'
						|| extensionToCheck == 'ps'
						|| extensionToCheck == 'svg'

						|| extensionToCheck == 'JPG'
						|| extensionToCheck == 'JPEG'
						|| extensionToCheck == 'PNG'
						|| extensionToCheck == 'GIF'
						|| extensionToCheck == 'IOC'
						|| extensionToCheck == 'BMP'
						|| extensionToCheck == 'PSD'
						|| extensionToCheck == 'TIF'
						|| extensionToCheck == 'PSPIMAGE'
						|| extensionToCheck == 'THM'
						|| extensionToCheck == 'YUV'
						|| extensionToCheck == 'AI'
						|| extensionToCheck == 'DRW'
						|| extensionToCheck == 'EPS'
						|| extensionToCheck == 'PS'
						|| extensionToCheck == 'SVG') {
					$('#photoFileName').html(
							$('#file_click').val()
									.substring(
											$('#file_click').val().lastIndexOf(
													'\\') + 1));
					isImageSelected = 1;
					var fileupload = window.location;
					$.ajax({
						type : "POST",
						enctype : 'multipart/form-data',
						url : fileupload.origin + "/NRG-User/profileUpload",
						data : new FormData($('#uploadFile')[0]),
						processData : false, // prevent jQuery from
						// automatically
						contentType : false,
						cache : false,
						timeout : 600000,
						success : function(result) {
							if (result.status == '1') {
								BootstrapDialog.alert(result.resonCode);
							} else {
								BootstrapDialog.alert(result.resonCode);
							}
						},
						error : function(e) {
							console.log("ERROR: ", e);
						}
					});
				} else {
					bootMessage('Error',
							'Please select a valid Image Extension like .JPG')
					$('#file_click').val('');
					$('#photoFileName').val('');
					isImageSelected = 0;
				}
			} else {
				windows.location.reload();
			}
		});

$(document).ready(function() {

	$("#dobdatetimepicker").datetimepicker({
		format : 'DD-MM-YYYY',
	});

	var validation = false;
	var url = window.location;
	$("#clientprofile").click(function(event) {
		var validation = profileformvalidation();
		if (validation == true) {

			var user = new Object();
			user.salutationid = $('#salutationId').val();
			user.firstname = $('#firstname').val();
			user.middlename = $('#middlename').val();
			user.lastname = $('#lastname').val();
			user.genderid = $('#gender').val();
			user.contactmobile = $('#contactmobile').val();
			user.contactmobile2 = $('#contactmobile2').val();
			user.dob = $('#dob').val();
			var jsonUser = JSON.stringify(user);
			$.ajax({
				type : "POST",
				url : url.origin + "/NRG-User/client/profile",
				contentType : 'application/json',
				data : jsonUser,
				processData : false, // prevent jQuery from
				cache : false,
				timeout : 600000,
				success : function(result) {
					if (result.status == '0') {
						bootMessage('Error', result.resonCode);
					} else {
						bootMessage('sucess', result.resonCode);
					}
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
		}

	});

	getSalutaion(url);

});

// for get client profile
function getprofile(url) {
	$.ajax({
		type : "GET",
		url : url.origin + "/NRG-User/client/get/profile",
		processData : false,
		contentType : false,
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == '1') {
				var dataSet = result.data;

				if (dataSet.salutationid != null) {
					$('#salutationId').val(dataSet.salutationid);
				}
				if (dataSet.firstname != null) {
					$('#firstname').val(dataSet.firstname);
				}
				if (dataSet.middlename != null) {
					$('#middlename').val(dataSet.middlename);
				}
				if (dataSet.lastname != null) {
					$('#lastname').val(dataSet.lastname);
				}
				if (dataSet.genderid != null) {
					$('#gender').val(dataSet.genderid);
				}
				if (dataSet.contactmobile != null) {
					$('#contactmobile').val(dataSet.contactmobile);
				}
				if (dataSet.contactmobile2 != null) {
					$('#contactmobile2').val(dataSet.contactmobile2);
				}
				if (dataSet.dob != null) {
					$('#dob').val(dataSet.dob);
				}
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});
}

// for salutation call
function getSalutaion(url) {

	$.ajax({
		type : "GET",
		url : url.origin + "/NRG-User/common/codevalue?codetypeId=3",
		processData : false,
		contentType : false,
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == '1') {
				var dataSet = result.data;
				$(dataSet).each(
						function(i, obj) {
							var codeValueID = obj.codevalueid;
							var codeValue = obj.codevalue;
							$('#salutationId').append(
									'<option value="' + codeValueID + '">'
											+ codeValue + '</option>');
						});
				getGender(url);
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});
}

// for gender call
function getGender(url) {

	$.ajax({
		type : "GET",
		url : url.origin + "/NRG-User/common/codevalue?codetypeId=4",
		processData : false,
		contentType : false,
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == '1') {
				var dataSet = result.data;
				$(dataSet).each(
						function(i, obj) {
							var codeValueID = obj.codevalueid;
							var codeValue = obj.codevalue;
							$('#gender').append(
									'<option value="' + codeValueID + '">'
											+ codeValue + '</option>');
						});
				getprofile(url);
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});
}
