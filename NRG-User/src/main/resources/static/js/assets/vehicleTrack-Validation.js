function trackFormValidation() {
	addclassHide();
	var validation = true;

	// vehicle select
	if ($.trim($('#vehicleId').val()) == '0') {
		$('#vehicleId_error').removeClass('hide');
		$('#vehicleId_error').html("Please select Vehicle.");
		validation = false;
	}

	// start date select
	if ($.trim($('#trackStartDate').val()) == '') {
		$('#startDate_error').removeClass('hide');
		$('#startDate_error').html("Please select Start Date.");
		validation = false;
	}
	
	//end date select
	if ($.trim($('#trackEndDate').val()) == '') {
		$('#endDate_error').removeClass('hide');
		$('#endDate_error').html("Please select End Date.");
		validation = false;
	}
	return validation;
}

function addclassHide() {

	$('#vehicleId_error').addClass('hide');
	$('#startDate_error').addClass('hide');
	$('#endDate_error').addClass('hide');

	$('#vehicleId_error').html('');
	$('#startDate_error').html('');
	$('#endDate_error').addClass('hide');
}
