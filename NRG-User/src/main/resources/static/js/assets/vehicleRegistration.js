$(document).ready(function() {
	var data = null;
	var objectName = "VEHICLE";
	var dataTableHeader = tableHeaderObject.VEHICLE_HEADERS;
	var dataTableColumns = tableColumnObject.VEHICLE_COLUMNS;
	var tableName = "VEHICLE";

	ajaxPost(data, objectName, dataTableHeader, tableColumnObject, tableName)
});

function ajaxPost(data, objectName, dataTableHeader, dataTableColumns,
		tableName) {

	//var url = /*[[@{/vehicle/list}]]*/ 'list';
	$.ajax({
		type : "GET",
		url : "[[@{/vehicle/list}]]/list",
		data : data,
		processData : false, // prevent jQuery from automatically
								// transforming the data into a query string
		contentType : false,
		cache : false,
		timeout : 600000,
		success : function(result) {
			if (result.status == '1') {
				var dataSet = result.data;
				if (jQuery.isEmptyObject(dataSet))
					return;
				DataTableHeaderBind(dataTableHeader, objectName);
				datasetToDataTable(dataSet, objectName,
						dataTableColumnsBind(dataTableColumns), tableName);
				BootstrapDialog.alert(result.resonCode);
			} else {
				BootstrapDialog.alert(result.resonCode);
			}
		},
		error : function(e) {
			$("#" + objectName + "").hide();
			console.log("ERROR: ", e);
		}
	});

}