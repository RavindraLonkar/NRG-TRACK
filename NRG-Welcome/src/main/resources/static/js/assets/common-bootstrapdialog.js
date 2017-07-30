function bootMessageRedirect(title, label, redirectUrl,message) {
	BootstrapDialog.show({
		title : title,
		message : message,
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