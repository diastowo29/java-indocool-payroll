/**
 * 
 */

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
    var cell_action = row.insertCell(6);

    var buttonEdit = `<a href="#" class="btn icon icon-left btn-primary">
    <i class="bi bi-pencil-square" data-bs-toggle="modal"
    data-bs-target="#xlarge"></i></a>
    <a href="#" class="btn icon icon-left btn-danger" data-bs-toggle="modal"
    data-bs-target="#default">
    <i class="bi bi-trash-fill"></i></a>`

    cell_emp_id.innerHTML = dts.employeeId;
    cell_job_number.innerHTML = dts.jobNumber;
    cell_date.innerHTML = dts.dtsDate;
    cell_start.innerHTML = dts.startWorking;
    cell_finish.innerHTML = dts.finishWorking;
    cell_working_day.innerHTML = dts.workingDay;
    cell_action.innerHTML = buttonEdit;
}

function saveDts () {
    var emp_id = $('#emp-id-input').val();
    var presence = $('#presence-input').val();
    var dts_date = $('#dts-date-input').val();
    var job_number = $('#job-number-input').val();
    var working_day = $('#working-day-input').val();
    var start = $('#start-work-input').val();
    var finish = $('#finish-work-input').val();
    var job_desc = $('#job-desc-input').val();
    var meals = $('#meals-check-input').is(":checked");
    var transport = $('#transport-check-input').is(":checked");
    var productivity = $('#productivity-check-input').is(":checked");
    var away = $('#away-check-input').is(":checked");

    var newDts = {
        employeeId : emp_id,
		presenceStatus : presence,
		dtsDate : dts_date,
		jobNumber : job_number,
		workingDay : working_day,
		startWorking : start,
		finishWorking : finish,
		jobDesc : job_desc,
		employeeMeal : meals,
		employeeTransport : transport,
		employeeProductivity : productivity,
		employeeAway : away
    }

    console.log(newDts)

    $.ajax({
		url: apiPrefix + '/dts/add',
		contentType: "application/json",
		dataType: 'json',
		method: 'post',
        data: JSON.stringify(newDts),
		success: function(result) {
			console.log(result)
		}
	})
}

function idChange () {
    var emp_id = $('#emp-id-input').val();
    $.ajax({
		url: apiPrefix  +'/employee/get/' + emp_id,
		contentType: "application/json",
		dataType: 'json',
		method: 'get',
		success: function(result) {
			// location.reload();
			console.log(result)
            $('#emp-name-input').val(result.employeeName);
		}
	})
}