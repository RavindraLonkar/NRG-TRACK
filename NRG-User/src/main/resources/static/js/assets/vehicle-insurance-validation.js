function addInsuranceRegFormValidation() {
	addclassHide();
	var validation = true;

	// vehicle number validation
	if ($.trim($('#addVehicleNumber').val()) == '0') {
		$('#addvehiclenumber_error').removeClass('hide');
		$('#addvehiclenumber_error').html("Please enter valid Vehicle Number.");
		validation = false;
	}

	// vehicle insurance name validation
	if ($.trim($('#addInsuranceName').val()) == '') {
		$('#addinsurancename_error').removeClass('hide');
		$('#addinsurancename_error').html("Please enter valid Vehicle Number.");
		validation = false;
	}
	
	// insurance start date validation
	if ($.trim($('#addStartDate').val()) == '') {
		$('#addstartdate_error').removeClass('hide');
		$('#addstartdate_error').html("Please enter valid Vehicle Number.");
		validation = false;
	}
	
	// insurance end date validation
	if ($.trim($('#addEndDate').val()) == '') {
		$('#addenddate_error').removeClass('hide');
		$('#addenddate_error').html("Please enter valid Vehicle Number.");
		validation = false;
	}
	
	// insurance reminder validation
	if ($.trim($('#addReminder').val()) == '0') {
		$('#addreminder_error').removeClass('hide');
		$('#addreminder_error').html("Please enter valid Vehicle Number.");
		validation = false;
	}
	return validation;
}

function addclassHide() {

	$('#addvehiclenumber_error').addClass('hide');
	$('#addinsurancename_error').addClass('hide');
	$('#addstartdate_error').addClass('hide');
	$('#addenddate_error').addClass('hide');
	$('#addreminder_error').addClass('hide');
	
	$('#addvehiclenumber_error').html('');
	$('#addinsurancename_error').html('');
	$('#addstartdate_error').html('');
	$('#addenddate_error').html('');
	$('#addreminder_error').html('');
	
}


function editInsuranceRegFormValidation() {
	editclassHide();
	var validation = true;
	// vehicle number validation
	if ($.trim($('#editVehicleNumber').val()) == '0') {
		$('#vehiclenumber_error').removeClass('hide');
		$('#vehiclenumber_error').html("Please enter valid Vehicle Number.");
		validation = false;
	}

	// vehicle insurance name validation
	if ($.trim($('#editInsuranceName').val()) == '') {
		$('#editinsurancename_error').removeClass('hide');
		$('#editinsurancename_error').html("Please enter valid Vehicle Number.");
		validation = false;
	}
	
	// insurance start date validation
	if ($.trim($('#editStartDate').val()) == '') {
		$('#editstartdate_error').removeClass('hide');
		$('#editstartdate_error').html("Please enter valid Vehicle Number.");
		validation = false;
	}
	
	// insurance end date validation
	if ($.trim($('#editEndDate').val()) == '') {
		$('#editenddate_error').removeClass('hide');
		$('#editenddate_error').html("Please enter valid Vehicle Number.");
		validation = false;
	}
	
	// insurance reminder validation
	if ($.trim($('#editReminder').val()) == '0') {
		$('#editreminder_error').removeClass('hide');
		$('#editreminder_error').html("Please enter valid Vehicle Number.");
		validation = false;
	}

	return validation;
}

function editclassHide() {
	$('#editvehiclenumber_error').addClass('hide');
	$('#editinsurancename_error').addClass('hide');
	$('#editstartdate_error').addClass('hide');
	$('#editenddate_error').addClass('hide');
	$('#editreminder_error').addClass('hide');
	
	$('#editvehiclenumber_error').html('');
	$('#editinsurancename_error').html('');
	$('#editstartdate_error').html('');
	$('#editenddate_error').html('');
	$('#editreminder_error').html('');
}

$('#menu-vehicle').addClass('active');
$('#CMRegistrationLink').addClass('active');	