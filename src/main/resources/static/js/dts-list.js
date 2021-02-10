var apiPrefix = '/api/v1';

getAllDts(); 

function getAllDts () {
    $.ajax({
		url: apiPrefix  + '/dts',
		contentType: "application/json",
		dataType: 'json',
		method: 'get',
		success: function(result) {
			// location.reload();
			console.log(result);
            if (result.length > 0) {
                result.forEach(dts => {
                    generateDtsRow(dts);
                });
            } else {
                // $('#no-row-tr').hide
            }
            let table1 = document.querySelector('#dts_table');
            let dataTable = new simpleDatatables.DataTable(table1);
		}
	})
}

function generateDtsRow (dts) {
    var table = document.getElementById("dts_table_body");

    var row = table.insertRow(0);
    var cell_emp_id = row.insertCell(0);
    var cell_job_number = row.insertCell(1);
    var cell_date = row.insertCell(2);
    var cell_start = row.insertCell(3);
    var cell_finish = row.insertCell(4);
    var cell_working_day = row.insertCell(5);
    var cell_meal = row.insertCell(6);
    var cell_transport = row.insertCell(7);
    var cell_productivity = row.insertCell(8);
    var cell_away = row.insertCell(9);

    cell_emp_id.innerHTML = dts.employeeId;
    cell_job_number.innerHTML = dts.jobNumber;
    cell_date.innerHTML = dts.dtsDate;
    cell_start.innerHTML = dts.startWorking;
    cell_finish.innerHTML = dts.finishWorking;
    cell_working_day.innerHTML = dts.workingDay;
    cell_meal.innerHTML = dts.employeeMeal;
    cell_transport.innerHTML = dts.employeeTransport;
    cell_productivity.innerHTML = dts.employeeProductivity;
    cell_away.innerHTML = dts.employeeAway;
}
