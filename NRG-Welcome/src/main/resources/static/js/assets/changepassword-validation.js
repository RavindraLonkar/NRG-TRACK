function changePasswordFormValidation() {
	addclassHide();
	var validation = true;

	// password
	if ($('#password').val() == '') {
		$('#password_error').removeClass('hide');
		$('#password_error').html("Please enter New Password.");
		validation = false;
	}

	// confirm password
	if ($('#confirmpassword').val() == '') {
		$('#confirmpassword_error').removeClass('hide');
		$('#confirmpassword_error').html("Please enter Confirm Password.");
		validation = false;
	} else if ($('#confirmpassword').val() !== '' && $('#password').val() != '') {
		if ($('#password').val().length < 8) {
			Validated = false;
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

	return validation;
}

function addclassHide() {
	$('#password_error').addClass('hide');
	$('#confirmpassword_error').addClass('hide');

	$('#password_error').html('');
	$('#confirmpassword_error').html('');
}