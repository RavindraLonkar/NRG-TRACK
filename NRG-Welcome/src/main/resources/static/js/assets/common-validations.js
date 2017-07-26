//for only alphabet with spaces
function onlyAlphabetsWithSpace(e, t) {
	    try {
	        if (window.event) {
	            var charCode = window.event.keyCode;
	        }
	        else if (e) {
	            var charCode = e.which;
	        }
	        else { return true; }
	        if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123) || charCode == 32)
	            return true;
	        else
	            return false;
	    }
	    catch (err) {
	        alert(err.Description);
	    }
	}

// for only integer
function allowIntegersOnly(id, e) {
	if ($.inArray(e.keyCode, [ 46, 8, 9, 27, 13 ]) !== -1
			|| (e.keyCode == 65 && e.ctrlKey === true)
			|| (e.keyCode >= 35 && e.keyCode <= 39)) {
		return;
	} else {
		if (e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)
				&& (e.keyCode < 96 || e.keyCode > 105)) {
			e.preventDefault();
		}
	}
	try {
		$('input[name="' + id + '"]').removeAttr('checked');
	} catch (e) {
	}
}