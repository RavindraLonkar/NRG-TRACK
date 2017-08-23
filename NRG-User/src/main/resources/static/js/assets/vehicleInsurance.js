var table;
$(document).ready(function() {
	table = $('#insuranceDt').DataTable({
        "dom": 'Bfrtip',
		"processing" : true,
		"scrollX": true,
        "bDestroy": true,
        "bLengthChange": false,
        "select": true,
		"ajax" : {
			"url" : $("#contextPath").val() + "insurance/list",
			"type" : "GET",				
		},
		"language": {
	        "zeroRecords": "No Record Found!",
	    },
		"rowId": 'insuranceid',
		"columns" : [ {
            "render": function ( data, type, row ) {
                return "<a href='#editInsuranceModal' data-toggle='modal'><span class = 'glyphicon glyphicon-edit' id='" 
                + row.insuranceid + "' onclick='setModelData(this.id)'></span></a>";
            },
            "targets": 1
        }, {
			"data" : "vechiclenumber"
		}, {
			"data" : "insurancename"
		},{
			"data" : "startdate"
		},
		{
			"data" : "enddate"
		},
		{
            "render": function ( data, type, row ) {
                return "<a href='#'><span class = 'glyphicon glyphicon-trash' id='" + row.insuranceid + "' onclick='confirmdeleteInsurance(this.id);'></span></a>";
            },
            "targets": 4
        }],
        "buttons": [
            {
                text: 'Add Insurance',
                className: 'green',
                action: function ( e, dt, node, config ) {
                	addclassHide();
                	$('#addInsuranceModal').modal('show');
                	getVehicles();
                }
            },
            {
                text: 'Delete Selected Insurances',
                className: 'red',
                action: function ( e, dt, node, config ) {
                	confirmdeleteInsurances();
                }
            }
        ]
	});
	
	//add form Date pickers
	$('#addStartDate').datetimepicker({
		 format: 'DD/MM/YYYY hh:mm:ss'
	 });
    $('#addEndDate').datetimepicker({
        useCurrent: false,
        format: 'DD/MM/YYYY hh:mm:ss'
    });
    $("#addStartDate").on("dp.change", function (e) {
        $('#addEndDate').data("DateTimePicker").minDate(e.date);
    });
    $("#datetimepicker7").on("dp.change", function (e) {
        $('#addStartDate').data("DateTimePicker").maxDate(e.date);
    });
    
    //edit form Date pickers
	$('#editStartDate').datetimepicker({
		 format: 'DD/MM/YYYY hh:mm:ss'
	 });
    $('#editEndDate').datetimepicker({
        useCurrent: false,
        format: 'DD/MM/YYYY hh:mm:ss'
    });
    $("#editStartDate").on("dp.change", function (e) {
        $('#editEndDate').data("DateTimePicker").minDate(e.date);
    });
    $("#datetimepicker7").on("dp.change", function (e) {
        $('#editStartDate').data("DateTimePicker").maxDate(e.date);
    });
});

function getVehicles(vehicleNoField,vehicleNameField){
	$.ajax({
		type : "GET",
		url : $("#contextPath").val() + "/vehicle/tracker/list",
		processData : false,
		contentType : false,
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == '1') {
				var dataSet = result.data;
				$(dataSet).each(function(i,obj) {		
    				$('#addVehicleNumber').append('<option value="'+obj.vehicleid+'">'+ obj.vechiclenumber+'</option>');
    			});	
			} 
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});	

}

function addInsurance() {
	var validation = false;
	var validation = addInsuranceRegFormValidation();
	if (validation == false)
		return;

	var data = {
		insurancenumber : $("#addInsuranceNumber").val(),
		insurancename : $("#addInsuranceName").val()
	}
	$.ajax({
		type : "POST",
		url : $("#contextPath").val() + "/insurance/save",
		data : JSON.stringify(data),
		processData : false, //prevent jQuery from automatically transforming the data into a query string
		contentType : 'application/json',
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == '1') {
				$('#addInsuranceModal').modal('hide');
				bootMessage('sucess', result.resonCode);
				table.ajax.reload();
			} else {
				bootMessage('Error', result.resonCode);
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});

}

function setModelData(insuranceid) {
	var data = table.row('#' + insuranceid).data();
	$("#editInsuranceId").val(data.insuranceid);
	$("#editInsuranceNumber").val(data.insurancenumber);
	$("#editInsuranceName").val(data.insurancename);
}

function editInsurance() {
	var validation = false;
	var validation = editInsuranceRegFormValidation();
	if (validation == false)
		return;
	var data = {
		insuranceid : $("#editInsuranceId").val(),
		insurancenumber : $("#editInsuranceNumber").val(),
		insurancename : $("#editInsuranceName").val()
	}
	$.ajax({
		type : "PUT",
		url : $("#contextPath").val() + "/insurance/update",
		data : JSON.stringify(data),
		processData : false, //prevent jQuery from automatically transforming the data into a query string
		contentType : 'application/json',
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == '1') {
				$('#editInsuranceModal').modal('hide');
				bootMessage('sucess', result.resonCode);
				table.ajax.reload();
			} else {
				bootMessage('Error', result.resonCode);
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});

}

function confirmdeleteInsurance(insuranceid) {
	var data = new Array();
	data.push(table.row('#' + insuranceid).data());
	
	if(!(data.length > 0)){
		bootMessage('Confirm','Please select insurance to delete');
		return;
	} else{
		BootstrapDialog.show({
			title : "Confirm",
			message : "Are you sure! Wants to delete.",
			buttons : [ {
				label : "OK",
				action : function(dialog) {
					dialog.close();
					deleteInsurances(data);
				},
			}]
		});
	}
}

function confirmdeleteInsurances() {
	var data = new Array();
	table.rows('.selected').every(function(rowIdx, tableLoop, rowLoop) {
		data.push(this.data());
	});
	
	if(!(data.length > 0)){
		bootMessage('Confirm','Please select insurance to delete');
		return;
	}else{
		BootstrapDialog.show({
			title : "Confirm",
			message : "Are you sure! Wants to delete.",
			buttons : [ {
				label : "OK",
				action : function(dialog) {
					dialog.close();
					deleteInsurances(data)							
				},
			}]
		});
	}
}

function deleteInsurance(data){
	$.ajax({
		type : "DELETE",
		url : $("#contextPath").val() + "/insurance/delete",
		data : JSON.stringify(data),
		processData : false, //prevent jQuery from automatically transforming the data into a query string
		contentType : 'application/json',
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == '1') {
				bootMessage('sucess', result.resonCode);
				table.ajax.reload();
			} else {
				bootMessage('Error', result.resonCode);
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});

}

function deleteInsurances(data) {			

	$.ajax({
		type : "DELETE",
		url : $("#contextPath").val() + "/insurance/delete",
		data : JSON.stringify(data),
		processData : false, //prevent jQuery from automatically transforming the data into a query string
		contentType : 'application/json',
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == '1') {
				bootMessage('sucess', result.resonCode);
				table.ajax.reload();
			} else {
				bootMessage('Error', result.resonCode);
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});

}