$( document ).ready(function() {
     
    var url = window.location;
    var validation=false;
    
    // SUBMIT FORM
    $("#btnSubmit").click(function (event) {
        // Prevent the form from submitting via the browser.
       /* event.preventDefault();
        var validation=true;//uploadFormValidation($("#file").val().split("\\").pop(-1));

        if(validation==true){
        	var fileName =matchFileName($("#file").val().split("\\").pop(-1)).toUpperCase().trim();
        	switch(fileName){
	        	case "PGR_ISSUE":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"PGR_ISSUENEW",tableHeaderObject.PGR_ISSUNEW_HEADER,fileName);
	        	break;
	        	case  "PIR1_SCanOpcodeIssue":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"PIR1_SCANOPCODEISSUE",fileName);
	        	break;
	        	case  "PIR2_SCanOpcodeIssue":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"PIR2_SCANOPCODEISSUE",fileName);
	        	break;
	        	case  "PIR3_SCanOpcodeIssue":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"PIR2_SCANOPCODEISSUE",fileName);
	        	break;
	        	case  "CONTAMINATION_HBT":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"CONTAMINATION",tableHeaderObject.CONTAMINATION_HEADER,fileName);
	        	break;
	        	case  "CONTAMINATION_FUNGUS":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"CONTAMINATION",tableHeaderObject.CONTAMINATION_HEADER,fileName);
	        	break;
	        	case  "CONTAMINATION_OTHER":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"CONTAMINATION",tableHeaderObject.CONTAMINATION_HEADER,fileName);
		        break;
	        	case  "PGR_RETURN":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"PGR_RETURNNEW",tableHeaderObject.PGR_RETURNNEW_HEADER,fileName);
		        break;
	        	case  "PGR PRODUCTION":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"PGR_PRODUCTION",tableHeaderObject.PGR_PRODUCTION_HEADER,fileName);
		        break;
	        	case  "PIR_RETURN":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"PIR_RETURN",tableHeaderObject.PIR_RETURN_HEADER,fileName);
		        break;
	        	case  "PIR_PRODUCTION":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"PIR_PRODUCTION",tableHeaderObject.PIR_PRODUCTION_HEADER,fileName);
		        break;
	        	case  "PIR_ISSUE":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"PIR_ISSUE",tableHeaderObject.PIR_ISSUE_HEADER,fileName);
		        break;
	        	case  "DISPATCH_RETURN":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"DISPATCH_RETURN_MASTER",tableHeaderObject.DISPATCH_RETURN_MASTER_HEADER,fileName);
		        break;
	        	case  "DISPATCH_ISSUE":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"DISPATCH",tableHeaderObject.DISPATCH_ISSUE_HEADER,fileName);
		        break;
	        	case  "DISCARD":
	        		ajaxFilePost(new FormData($('#uploadFile')[0]),"DISCARD",tableHeaderObject.DISCARD_HEADER,fileName);
		        break;
	        	default:  
	        		notMatchCase();
	        	break;
	        }        
		   
    	}*/
    	
    	 $.ajax({
             type : "POST",
             url : url + "user/save",
             success : function(result) {
             	
             },
             error : function(e) {
                 console.log("ERROR: ", e);
             }
         });
    }); 
    
    function ajaxFilePost(data,objectName,dataTableHeader,tableName){
              
        $.ajax({
            type : "POST",
            enctype: 'multipart/form-data',
            url : url + "upload?objectName=" + objectName,
            data : data,
            processData: false, //prevent jQuery from automatically transforming the data into a query string
            contentType: false,
            cache: false,
            timeout: 600000,
            success : function(result) {
            	if(result.status=='1'){
            		var dataSet=result.data;
            		if(jQuery.isEmptyObject(dataSet))
                		return;
            		DataTableHeaderBind(dataTableHeader,objectName);
            		hideDataTable();
                	datasetToDataTable(dataSet,objectName,dataTableColumns(dataTableHeader),tableName);
                	BootstrapDialog.alert(result.resonCode);
            	}else{
            		BootstrapDialog.alert(result.resonCode);
            	}	
            },
            error : function(e) {
            	$("#"+objectName+"").hide();
                console.log("ERROR: ", e);
            }
        });
    }
    
    function notMatchCase(){
    	
    	BootstrapDialog.alert('Please Upload Correct File!');
    }
})
