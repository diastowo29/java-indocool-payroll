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

function saveSummary () {
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
            var summaryData = {
                summaryName: 'Summary - ' + Math.random().toString(36).slice(2),
                summaryResult: JSON.stringify(result)
            }
            $.ajax({
                url: apiPrefix  + '/dts-summary/add',
                contentType: "application/json",
                dataType: 'json',
                method: 'post',
                data: JSON.stringify(summaryData),
                success: function(summaySaveResult) {
                    // location.reload();
                    console.log(summaySaveResult);
                }
            })
		}
	})
}

function doCalculate () {
    var summaryData = $('#summary-data-input').val();
    $.ajax({
		url: apiPrefix  + '/calculation/' + summaryData,
		contentType: "application/json",
		dataType: 'json',
		method: 'get',
		success: function(result) {
			console.log(result);
            result.forEach(dts => {
                generateCalculationRow(dts);
            });
		}
	})
}

function generateCalculationRow (calc) {
    var table = document.getElementById("calculation_table_body");

    var row = table.insertRow(0);
    var cell_emp_id = row.insertCell(0);
    var cell_emp_name = row.insertCell(1);
    var cell_days_worked = row.insertCell(2);
    var cell_meal = row.insertCell(3);
    var cell_transport = row.insertCell(4);
    var cell_productivity = row.insertCell(5);
    var cell_away = row.insertCell(6);
    var call_overtime = row.insertCell(7);
    var cell_minus = row.insertCell(8);
    var cell_total = row.insertCell(9);

    cell_emp_id.innerHTML = calc.employee_id;
    cell_emp_name.innerHTML = calc.employee_name;
    cell_days_worked.innerHTML = calc.workingDay;
    cell_meal.innerHTML = calc.meals;
    cell_transport.innerHTML = calc.transport;
    cell_productivity.innerHTML = calc.productivity;
    cell_away.innerHTML = calc.away;
    call_overtime.innerHTML = calc.overtime;
    cell_minus.innerHTML = 0;
    cell_total.innerHTML = calc.total_amount;
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
    var cell_overtime_wd = row.insertCell(7);
    var cell_overtime_we = row.insertCell(8);
    var cell_minus = row.insertCell(9);

    cell_emp_id.innerHTML = dts.employee_id;
    cell_emp_name.innerHTML = dts.employee_name;
    cell_days_worked.innerHTML = dts.workingDay;
    cell_meal.innerHTML = dts.meal;
    cell_transport.innerHTML = dts.transport;
    cell_productivity.innerHTML = dts.productivity;
    cell_away.innerHTML = dts.away;
    cell_overtime_we.innerHTML = dts.weekend_hours;
    cell_overtime_wd.innerHTML = dts.weekday_hours - (9*dts.workingDay);

    var minusCalculate = (9*dts.workingDay) - dts.weekday_hours;
    if (minusCalculate < 0) {
        minusCalculate = 0;
    }
    cell_minus.innerHTML = minusCalculate;
    

}