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

$(document).ready(
		function() {
			var validation = false;
			var url = window.location;
			$("#userprofile").click(function(event) {
				var validation = profileformvalidation();
				if (validation == true) {

					var user = new Object();
					user.salutation = $('#salutationId').val();
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
						url : url.origin + "/NRG-User/user/profile",
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

			// for salutation call
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
									var codeValueID = obj.codeValueID;
									var codeValue = obj.codeValue;
									$('#salutationId').append(
											'<option value="' + codeValueID
													+ '">' + codeValue
													+ '</option>');
								});
					}
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
			
			// for gender call
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
									var codeValueID = obj.codeValueID;
									var codeValue = obj.codeValue;
									$('#gender').append(
											'<option value="' + codeValueID
													+ '">' + codeValue
													+ '</option>');
								});
					}
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
		});