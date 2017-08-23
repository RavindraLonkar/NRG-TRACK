function addVehicleRegFormValidation() {
	addclassHide();
	var validation = true;

	// vehicle number validation
	if ($.trim($('#addVechicleNumber').val()) == '') {
		$('#vechiclenumber_error').removeClass('hide');
		$('#vechiclenumber_error').html("Please enter valid Vehicle Number.");
		validation = false;
	}

	// vehicle name validation
	if ($.trim($('#addVechicleName').val()) == '') {
		$('#vechiclename_error').removeClass('hide');
		$('#vechiclename_error').html("Please enter valid Vehicle Name.");
		validation = false;
	}
	return validation;
}

function addclassHide() {

	$('#vechiclenumber_error').addClass('hide');
	$('#vechiclename_error').addClass('hide');
	
	$('#vechiclenumber_error').html('');
	$('#vechiclename_error').html('');
}


function editVehicleRegFormValidation() {
	editclassHide();
	var validation = true;
	// vehicle number validation
	if ($.trim($('#editVechicleNumber').val()) == '') {
		$('#editvechiclenumber_error').removeClass('hide');
		$('#editvechiclenumber_error').html("Please enter valid Vehicle Number.");
		validation = false;
	}

	// vehicle name validation
	if ($.trim($('#editVechicleName').val()) == '') {
		$('#editvechiclename_error').removeClass('hide');
		$('#editvechiclename_error').html("Please enter valid Vehicle Name.");
		validation = false;
	}

	return validation;
}

function editclassHide() {
	$('#editvechiclenumber_error').addClass('hide');
	$('#editvechiclename_error').addClass('hide');
	
	$('#editvechiclenumber_error').html('');
	$('#editvechiclename_error').html('');
}

$('#menu-vehicle').addClass('active');
$('#CMRegistrationLink').addClass('active');	