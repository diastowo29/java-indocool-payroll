var apiPrefix = '/api/v1';

function doSummarize () {
    var month = $('#month-summary-input').val();
    var year = $('#year-summary-input').val();
    var workday = $('#workday-summary-input').val();
    console.log(month)
    console.log(year)
    console.log(workday)

    var period = month + '-' + year;
    $.ajax({
		url: apiPrefix  + '/dts/' + period + '/' + workday,
		contentType: "application/json",
		dataType: 'json',
		method: 'get',
		success: function(result) {
			// location.reload();
			console.log(result);
            if (result.length > 0) {
                result.forEach(dts => {
                    generateDtsSummaryRow(dts);
                });
            } else {
                // $('#no-row-tr').hide
            }
            let table1 = document.querySelector('#dts_summary_table');
            let dataTable = new simpleDatatables.DataTable(table1);
		}
	})
}

function generateDtsSummaryRow (dts) {
    var table = document.getElementById("dts_summary_table_body");

    var row = table.insertRow(0);
    var cell_emp_id = row.insertCell(0);
    var cell_emp_name = row.insertCell(1);
    var cell_days_worked = row.insertCell(2);
    var cell_meal = row.insertCell(3);
    var cell_transport = row.insertCell(4);
    var cell_productivity = row.insertCell(5);
    var cell_away = row.insertCell(6);
    var cell_overtime_we = row.insertCell(7);
    var cell_overtime_wd = row.insertCell(8);
    var cell_minus = row.insertCell(9);

    cell_emp_id.innerHTML = dts.employee_id;
    cell_emp_name.innerHTML = dts.employee_name;
    cell_days_worked.innerHTML = dts.workingDay;
    cell_meal.innerHTML = dts.meal;
    cell_transport.innerHTML = dts.transport;
    cell_productivity.innerHTML = dts.productivity;
    cell_away.innerHTML = dts.away;
    cell_overtime_we.innerHTML = dts.weekday_hours - (9*21);
    cell_overtime_wd.innerHTML = 0;
    cell_minus.innerHTML = (9*21) - dts.weekday_hours;
    

}