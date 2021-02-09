/**
 * 
 */

 function idChange () {
	 console.log('id change')
	 var id = $('#employee-id-input').val()
	 $.ajax({
		url: '/api/v1/employee/get/'  + id,
		contentType: "application/json",
		dataType: 'json',
		method: 'get',
		success: function(result) {
			if (result.id == 0) {
				$("#employee-id-input").removeClass("is-invalid");
				$('#save-emp-button').prop('disabled', false);
			} else {
				$("#employee-id-input").addClass("is-invalid");
				$('#save-emp-button').prop('disabled', true);
			}
		}
	})
 }

 function updateEmployee (id) {
	var fullname = $('#fullname-input').val();
	var email = $('#email-input').val();
	var phone = $('#phone-input').val();
	var nik = $('#nik-input').val();
	var kk = $('#kk-input').val();
	var pob = $('#pob-input').val();
	var dob = $('#dob-input').val();
	var mother = $('#mother-input').val();
	var blood = $('#blood-input').val();
	var marital = $('#marital-input').val();
	var address = $('#address-input').val();
	var work_domicile = $('#work-domicile-input').val();
	var job_pos = $('#job-pos-input').val();
	var division = $('#division-input').val();
	var emp_status = $('#emp-status-input').val();
	var bpjs_ks = $('#bpjs-ks-input').val();
	var bpjs_tk = $('#bpjs-tk-input').val();
	var npwp = $('#npwp-input').val();
	var join_date = $('#join-date-input').val();
	var basic_salary = $('#basic-salary-input').val();
	var meal = $('#meal-input').val();
	var transport = $('#transport-input').val();
	var attendance = $('#attendance-input').val();
	var ontime = $('#ontime-input').val();
	var hse = $('#hse-input').val();
	var productivity = $('#productivity-input').val();
	var fix = $('#fix-input').val();
	var overtime = $('#overtime-input').val();
	var away = $('#away-input').val();

	var thisEmployee = {
		id: id,
		workingSite : work_domicile,
		employeeStatus : emp_status,
		employeeName : fullname,
		placeofBirth : pob,
		dateofBirth : dob,
		employeeNik : nik,
		employeeKk : kk,
		employeeNpwp : npwp,
		employeeMaritalStatus : marital,
		motherName : mother,
		bpjsTk : bpjs_tk,
		bpjsKs : bpjs_ks,
		employeeAddress : address,
		employeeEmail : email,
		employeePhone : phone,
		employeeDivision : division,
		employeeJoinDate : join_date,
		employeeJobPosition : job_pos,
		employeeBasicSalary : basic_salary,
		employeeMeal : meal,
		employeeTransport : transport,
		employeeAttendance : attendance,
		employeeOntime : ontime,
		employeeHse : hse,
		employeeProductivity : productivity,
		employeeFix : fix,
		employeeOvertime : overtime,
		employeeAway : away
	 }

	 $.ajax({
		url: '/api/v1/employee/update',
		contentType: "application/json",
		dataType: 'json',
		method: 'post',
		data: JSON.stringify(thisEmployee),
		success: function(result) {
			// location.reload();
			console.log(result)
		}
	})
 }
 
 function saveNewEmployee () {
	 var emp_id = $('#employee-id-input').val();
	 var fullname = $('#fullname-input').val();
	 var email = $('#email-input').val();
	 var phone = $('#phone-input').val();
	 var nik = $('#nik-input').val();
	 var kk = $('#kk-input').val();
	 var pob = $('#pob-input').val();
	 var dob = $('#dob-input').val();
	 var mother = $('#mother-input').val();
	 var blood = $('#blood-input').val();
	 var marital = $('#marital-input').val();
	 var address = $('#address-input').val();
	 var work_domicile = $('#work-domicile-input').val();
	 var job_pos = $('#job-pos-input').val();
	 var division = $('#division-input').val();
	 var emp_status = $('#emp-status-input').val();
	 var bpjs_ks = $('#bpjs-ks-input').val();
	 var bpjs_tk = $('#bpjs-tk-input').val();
	 var npwp = $('#npwp-input').val();
	 var join_date = $('#join-date-input').val();
	 var basic_salary = $('#basic-salary-input').val();
	 var meal = $('#meal-input').val();
	 var transport = $('#transport-input').val();
	 var attendance = $('#attendance-input').val();
	 var ontime = $('#ontime-input').val();
	 var hse = $('#hse-input').val();
	 var productivity = $('#productivity-input').val();
	 var fix = $('#fix-input').val();
	 var overtime = $('#overtime-input').val();
	 var away = $('#away-input').val();

	 var newEmployee = {
		employeeId: emp_id,
		workingSite : work_domicile,
		employeeStatus : emp_status,
		employeeName : fullname,
		placeofBirth : pob,
		dateofBirth : dob,
		employeeNik : nik,
		employeeKk : kk,
		employeeNpwp : npwp,
		employeeMaritalStatus : marital,
		motherName : mother,
		bpjsTk : bpjs_tk,
		bpjsKs : bpjs_ks,
		employeeAddress : address,
		employeeEmail : email,
		employeePhone : phone,
		employeeDivision : division,
		employeeJoinDate : join_date,
		employeeJobPosition : job_pos,
		employeeBasicSalary : basic_salary,
		employeeMeal : meal,
		employeeTransport : transport,
		employeeAttendance : attendance,
		employeeOntime : ontime,
		employeeHse : hse,
		employeeProductivity : productivity,
		employeeFix : fix,
		employeeOvertime : overtime,
		employeeAway : away
	 }

	 $.ajax({
		url: '/api/v1/employee/add',
		contentType: "application/json",
		dataType: 'json',
		method: 'post',
		data: JSON.stringify(newEmployee),
		success: function(result) {
			location.reload();
		}
	})
 }