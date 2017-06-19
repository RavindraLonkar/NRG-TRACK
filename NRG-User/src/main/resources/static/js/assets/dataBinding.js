function datasetToDataTable(dataSet,objectName,dataTableHeader,tableName){

	$('#tableName').empty();
	$('#tableName').append("<h4><b>"+tableName+"</b></h4>");
	$("#"+objectName+"").show();
	$("#"+objectName+"").dataTable( {
        "data": dataSet,
        "scrollX": true,
        "bDestroy": true,
        "bLengthChange": false,
        "columns": dataTableHeader,
    } );
	
}

function dataTableColumns(dataTableHeader) {

	var dataColumns = dataTableHeader.split(',');
	var dataArray = new Array();
	for (column = 0; column < dataColumns.length; column++) {
		var obj={
			"data" :""+dataColumns[column]+""
		};
		dataArray.push(obj);
	}
	return dataArray;
}

function DataTableHeaderBind(dataTableHeader,objectName){
	
	$('#dataTableDiv').empty();

	var tableHtml="<table id='"+objectName+"' class='table table-striped table-bordered' " +
			"cellspacing='0' width='100%' th:fragment='"+objectName+'1'+"'><thead><tr>";
	var dataHeaders = dataTableHeader.split(',');
	for (header = 0; header < dataHeaders.length; header++) {
		tableHtml+="<th>"+dataHeaders[header]+"</th>"
	}
	tableHtml+="</tr></thead><tbody></tbody></table>";
	$('#dataTableDiv').append(tableHtml);
}
