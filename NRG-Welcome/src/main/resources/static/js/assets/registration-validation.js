function registrationformvalidation() {
	addclassHide();
	var validation = true;

	// first name validation
	if ($.trim($('#firstname').val()) == '') {
		$('#firstname_error').removeClass('hide');
		$('#firstname_error').html("Please enter valid First Name.");
		validation = false;
	}

	// last name validation
	if ($.trim($('#lastname').val()) == '') {
		$('#lastname_error').removeClass('hide');
		$('#lastname_error').html("Please enter valid Last Name.");
		validation = false;
	}

	// contact email
	if ($('#contactNo').val().length != 0) {
		if ($('#contactNo').val().length < 10) {
			isValidated = false;
			$('#contactNo_error').removeClass('hide');
			$('#contactNo_error').html("Please enter valid Contact No.");
		}
	}
	if ($('#contactNo').val() == "") {
		isValidated = false;
		$('#contactNo_error').removeClass('hide');
		$('#contactNo_error').html("Please enter valid Contact No.");
	}

	// password
	if ($('#password').val() == '') {
		$('#password_error').removeClass('hide');
		$('#password_error').html("Please enter Password.");
		validation = false;
	}

	// confirm password
	if ($('#confirmpassword').val() == '') {
		$('#confirmpassword_error').removeClass('hide');
		$('#confirmpassword_error').html("Please enter Confirm Password.");
		validation = false;
	} else if ($('#confirmpassword').val() !== '' && $('#password').val() != '') {
		if ($('#password').val().length < 8) {
			isValidated = false;
			$('#password_error').removeClass('hide');
			$('#password_error').html(
					"Please enter Strong password with minimum 8 length");
		} else if ($('#confirmpassword').val() != $('#password').val()) {
			$('#confirmpassword_error').removeClass('hide');
			$('#confirmpassword_error').html(
					"Confirm Password Not match with password.");
			validation = false;
		}
	}

	// email validation
	if (emailvalidation($('#emailid').val()) != true) {
		$('#email_error').removeClass('hide');
		$('#email_error').html("Please enter valid email id.");
		validation = false;
	}

	return validation;
}

function addclassHide() {

	$('#firstname_error').addClass('hide');
	$('#lastname_error').addClass('hide');
	$('#contactNo_error').addClass('hide');
	$('#password_error').addClass('hide');
	$('#confirmpassword_error').addClass('hide');
	$('#email_error').addClass('hide');

	$('#firstname_error').html('');
	$('#lastname_error').html('');
	$('#contactNo_error').html('');
	$('#password_error').html('');
	$('#confirmpassword_error').html('');
	$('#email_error').html('');

}