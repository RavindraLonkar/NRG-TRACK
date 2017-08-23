var table;
$(document).ready(function() {
	table = $('#vehicleDt').DataTable({
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
		"rowId": 'vehicleid',
		"columns" : [ {
            "render": function ( data, type, row ) {
                return "<a href='#editVehicleModal' data-toggle='modal'><span class = 'glyphicon glyphicon-edit' id='" 
                + row.insuranceid + "' onclick='setModelData(this.id)'></span></a>";
            },
            "targets": 1
        }, {
			"data" : "vechiclenumber"
		}, {
			"data" : "vechiclename"
		},{
			"data" : "insurancename"
		},{
			"data" : "startdate"
		},
		{
			"data" : "enddate"
		},
		{
            "render": function ( data, type, row ) {
                return "<a href='#'><span class = 'glyphicon glyphicon-trash' id='" + row.insuranceid + "' onclick='confirmdeleteVehicle(this.id);'></span></a>";
            },
            "targets": 4
        }],
        "buttons": [
            {
                text: 'Add Vehicle',
                className: 'green',
                action: function ( e, dt, node, config ) {
                	addclassHide();
                	$('#addVehicleModal').modal('show');
                }
            },
            {
                text: 'Delete Selected Vehicles',
                className: 'red',
                action: function ( e, dt, node, config ) {
                	confirmdeleteVehicles();
                }
            }
        ]
	});
});

function addVehicle() {
	var validation = false;
	var validation = addVehicleRegFormValidation();
	if (validation == false)
		return;

	var data = {
		vechiclenumber : $("#addVechicleNumber").val(),
		vechiclename : $("#addVechicleName").val()
	}
	$.ajax({
		type : "POST",
		url : $("#contextPath").val() + "/vehicle/save",
		data : JSON.stringify(data),
		processData : false, //prevent jQuery from automatically transforming the data into a query string
		contentType : 'application/json',
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == '1') {
				$('#addVehicleModal').modal('hide');
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

function setModelData(vehicleid) {
	var data = table.row('#' + vehicleid).data();
	$("#editVehicleId").val(data.vehicleid);
	$("#editVechicleNumber").val(data.vechiclenumber);
	$("#editVechicleName").val(data.vechiclename);
}

function editVedhicle() {
	var validation = false;
	var validation = editVehicleRegFormValidation();
	if (validation == false)
		return;
	var data = {
		vehicleid : $("#editVehicleId").val(),
		vechiclenumber : $("#editVechicleNumber").val(),
		vechiclename : $("#editVechicleName").val()
	}
	$.ajax({
		type : "PUT",
		url : $("#contextPath").val() + "/vehicle/update",
		data : JSON.stringify(data),
		processData : false, //prevent jQuery from automatically transforming the data into a query string
		contentType : 'application/json',
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == '1') {
				$('#editVehicleModal').modal('hide');
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

function confirmdeleteVehicle(vehicleid) {
	var data = new Array();
	data.push(table.row('#' + vehicleid).data());
	
	if(!(data.length > 0)){
		bootMessage('Confirm','Please select vehicle to delete');
		return;
	} else{
		BootstrapDialog.show({
			title : "Confirm",
			message : "Are you sure! Wants to delete.",
			buttons : [ {
				label : "OK",
				action : function(dialog) {
					dialog.close();
					deleteVehicles(data);
				},
			}]
		});
	}
}

function confirmdeleteVehicles() {
	var data = new Array();
	table.rows('.selected').every(function(rowIdx, tableLoop, rowLoop) {
		data.push(this.data());
	});
	
	if(!(data.length > 0)){
		bootMessage('Confirm','Please select vehicle to delete');
		return;
	}else{
		BootstrapDialog.show({
			title : "Confirm",
			message : "Are you sure! Wants to delete.",
			buttons : [ {
				label : "OK",
				action : function(dialog) {
					dialog.close();
					deleteVehicles(data)							
				},
			}]
		});
	}
}

function deleteVehicle(data){
	$.ajax({
		type : "DELETE",
		url : $("#contextPath").val() + "/vehicle/delete",
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

function deleteVehicles(data) {			

	$.ajax({
		type : "DELETE",
		url : $("#contextPath").val() + "/vehicle/delete",
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