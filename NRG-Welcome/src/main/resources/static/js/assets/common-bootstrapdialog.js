function bootMessageRedirect(title, label, redirectUrl) {
	BootstrapDialog.show({
		title : title,
		message : result.resonCode,
		buttons : [ {
			label : label,
			action : function(dialog) {
				window.location.href = redirectUrl;
			},
		} ]
	});
}

function bootMessage(title, message) {
	BootstrapDialog.show({
		title : title,
		message : message
	});
}