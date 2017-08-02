$('#image_click').click(function() {
	$('#file_click').click();
});

$('#file_click')
		.change(
				function() {

					var extensionToCheck = $('#file_click').val().substring(
							($('#file_click').val().lastIndexOf('.') + 1));

					if (extensionToCheck != '') {
						if (extensionToCheck == 'jpg'
								|| extensionToCheck == 'jpeg'
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
									$('#file_click').val().substring(
											$('#file_click').val().lastIndexOf(
													'\\') + 1));

							isImageSelected = 1;
						} else {
							bootMessage('Error','Please select a valid Image Extension like .JPG')
							$('#file_click').val('');
							$('#photoFileName').val('');
							isImageSelected = 0;
						}
					} else {
						windows.location.reload();
					}
				});