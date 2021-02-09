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

function openModalUpdate (dts_id) {
    $.ajax({
		url: apiPrefix  + '/dts/' + dts_id,
		contentType: "application/json",
		dataType: 'json',
		method: 'get',
		success: function(result) {
            console.log(result)
            $('#update-emp-id-input').val(result.employeeId);
            $('#update-presence-input').val(result.presenceStatus);
            $('#update-dts-date-input').val(result.dtsDate);
            $('#update-job-number-input').val(result.jobNumber);
            $('#update-working-day-input').val(result.workingDay);
            $('#update-start-work-input').val(result.startWorking);
            $('#update-finish-work-input').val(result.finishWorking);
            $('#update-job-desc-input').val(result.jobDesc);
            $('#update-meals-check-input').prop('checked', result.employeeMeal);
            $('#update-transport-check-input').prop('checked', result.employeeTransport);
            $('#update-productivity-check-input').prop('checked', result.employeeProductivity);
            $('#update-away-check-input').prop('checked', result.employeeAway);

            $('#update-confirm-btn').attr('onClick', 'confirmUpdate(' + result.id + ');');

            $('#update-modal').modal('show');
		}
	})
}

function openModalDelete (dts_id) {
    $('#delete-modal').modal('show');
    $('#delete-confirm-btn').removeAttr('onclick');
    $('#delete-confirm-btn').attr('onClick', 'confirmDelete(' + dts_id + ');');
}

function confirmUpdate (dts_id) {
    var emp_id = $('#update-emp-id-input').val();
    var presence = $('#update-presence-input').val();
    var dts_date = $('#update-dts-date-input').val();
    var job_number = $('#update-job-number-input').val();
    var working_day = $('#update-working-day-input').val();
    var start = $('#update-start-work-input').val();
    var finish = $('#update-finish-work-input').val();
    var job_desc = $('#update-job-desc-input').val();
    var meals = $('#update-meals-check-input').is(":checked");
    var transport = $('#update-transport-check-input').is(":checked");
    var productivity = $('#update-productivity-check-input').is(":checked");
    var away = $('#update-away-check-input').is(":checked");

    var updatedDts = {
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

    $.ajax({
		url: apiPrefix + '/dts/' + dts_id,
		contentType: "application/json",
		dataType: 'json',
		method: 'put',
        data: JSON.stringify(updatedDts),
		success: function(result) {
			console.log(result)
		}
	})
}

function confirmDelete (dts_id) {
    $.ajax({
		url: apiPrefix  + '/dts/' + dts_id,
		contentType: "application/json",
		dataType: 'json',
		method: 'delete',
		success: function(result) {
			location.reload();
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

    var buttonEdit = `
    <button class="btn btn-sm btn-primary" onclick="openModalUpdate(` + dts.id + `)"><i class="fa fa-edit"></i></button>
    <button class="btn btn-sm btn-warning" onclick="openModalDelete(` + dts.id + `)"><i class="fa fa-trash-alt"></i></button>`;

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