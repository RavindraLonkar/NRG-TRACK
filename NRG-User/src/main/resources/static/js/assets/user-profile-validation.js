function profileformvalidation() {
	addclassHide();
	var validation = true;

	// salutation name validation
	if ($.trim($('#salutationId').val()) == '0') {
		$('#salutationId_error').removeClass('hide');
		$('#salutationId_error').html("Please select Salutation.");
		validation = false;
	}

	// first name validation
	if ($.trim($('#firstname').val()) == '') {
		$('#firstname_error').removeClass('hide');
		$('#firstname_error').html("Please enter valid First Name.");
		validation = false;
	}

	// middle name validation
	if ($.trim($('#middlename').val()) == '') {
		$('#middlename_error').removeClass('hide');
		$('#middlename_error').html("Please enter valid Middle Name.");
		validation = false;
	}

	// last name validation
	if ($.trim($('#lastname').val()) == '') {
		$('#lastname_error').removeClass('hide');
		$('#lastname_error').html("Please enter valid Last Name.");
		validation = false;
	}

	// gender validation
	if ($.trim($('#gender').val()) == '0') {
		$('#gender_error').removeClass('hide');
		$('#gender_error').html("Please select Gender.");
		validation = false;
	}

	// contact no
	if ($('#contactmobile').val().length != 0) {
		if ($('#contactmobile').val().length < 10) {
			validation = false;
			$('#contactmobile_error').removeClass('hide');
			$('#contactmobile_error').html(
					"Please enter valid contact Mobile No.");
		}
	}
	if ($('#contactmobile').val() == "") {
		validation = false;
		$('#contactmobile_error').removeClass('hide');
		$('#contactmobile_error').html("Please enter valid Contact No.");
	}

	// alternate mobile no.
	if ($('#contactmobile2').val().length != 0) {
		if ($('#contactmobile2').val().length < 10) {
			validation = false;
			$('#contactmobile2_error').removeClass('hide');
			$('#contactmobile2_error').html(
					"Please enter valid Alternate Mobile No.");
		}
	}

	return validation;
}

function addclassHide() {

	$('#salutationId_error').addClass('hide');
	$('#firstname_error').addClass('hide');
	$('#middlename_error').addClass('hide');
	$('#lastname_error').addClass('hide');
	$('#gender_error').addClass('hide');
	$('#contactmobile_error').addClass('hide');
	$('#contactmobile2_error').addClass('hide');

	$('#salutationId_error').html('');
	$('#firstname_error').html('');
	$('#lastname_error').html('');
	$('#middlename_error').html('');
	$('#gender_error').html('');
	$('#contactmobile_error').html('');
	$('#contactmobile2_error').html('');

}