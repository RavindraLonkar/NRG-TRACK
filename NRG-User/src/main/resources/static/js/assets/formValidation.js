function uploadFormValidation(filename){
	$('#file_error').addClass('hide');
	$('#fileType_error').addClass('hide');
	$('#shift_error').addClass('hide');
	var validation = true;
	var extensionToCheck=$('#file').val().substring(($('#file').val()
			.lastIndexOf('.') + 1));
	
	// For file
	if(filename==''){
		$('#file_error').removeClass('hide');
		$('#fileType_error').addClass('hide');
		validation=false;
		return validation;
	}else{
		$('#file_error').addClass('hide');
		if(extensionToCheck !='' && extensionToCheck != 'txt'){
			$('#file').val('');
			$('#inputFileName').val('');
			$('#fileType_error').removeClass('hide');
			validation=false;
			return validation;
		}else{
			$('#fileType_error').addClass('hide');
		}
	}
	//For Shift
	if($('#shift').val()==0){
		$('#shift_error').removeClass('hide');
		validation=false;
		return validation;
		
	}else{
		$('#shift_error').addClass('hide');
	}
	return validation;
}

function matchFileName(filename){
	
	var filename=filename.split('.');
	fileName=filename[0].split('_');

	var matchFile="";
	for(filecount=0;filecount<fileName.length;filecount++){
		
		if(checkFileContains(fileName[filecount])==false){
			if(matchFile!=""){
				matchFile=matchFile+"_"+fileName[filecount];	
			}else{
				matchFile=fileName[filecount];
			}
				
		}else{
			return matchFile;
		}
	}
	return matchFile;
}

function checkFileContains(fileSplitValue){
    var t = fileSplitValue.match(/^(\d{2})\-(\d{2})\-(\d{4})$/);
    if(t===null) return false;
    var d=parseInt(t[1]), m=parseInt(t[2],10), y=parseInt(t[3],10);
    //below should be more acurate algorithm
    if(m>=1 && m<=12 && d>=1 && d<=31){
            return true;   
    }
    return false;
}


function hideDataTable(){
	jQuery('#dataTableDiv').children('table').hide();
}