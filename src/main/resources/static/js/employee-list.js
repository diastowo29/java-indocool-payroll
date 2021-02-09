getAllEmployee();

function getAllEmployee () {
    $.ajax({
		url: '/api/v1/employees',
		contentType: "application/json",
		dataType: 'json',
		method: 'get',
		success: function(result) {
			// location.reload();
			console.log(result)
            result.forEach(employee => {
                generateEmpRow(employee);
            });
            let table1 = document.querySelector('#emp-table');
            let dataTable = new simpleDatatables.DataTable(table1);
		}
        
	})
}

function generateEmpRow (employee) {
    var table = document.getElementById("emp-table-body");

    var row = table.insertRow(0);
    var cell_id = row.insertCell(0);
    var cell_name = row.insertCell(1);
    var cell_email = row.insertCell(2);
    var cell_phone = row.insertCell(3);
    var cell_working_city = row.insertCell(4);
    var cell_action = row.insertCell(5);

    var buttonEdit = `
    <a href="emp-update?id=` + employee.id + `" class="btn icon icon-left btn-primary">
        <i class="bi bi-pencil-square"></i>
    </a>
    <a href="#" class="btn icon icon-left btn-danger">
        <i class="bi bi-trash-fill"></i>
    </a>`;

    cell_id.innerHTML = employee.employeeId;
    cell_name.innerHTML = employee.employeeName;
    cell_email.innerHTML = employee.employeeEmail;
    cell_phone.innerHTML = employee.employeePhone;
    cell_working_city.innerHTML = employee.workingSite;
    cell_action.innerHTML = buttonEdit;
}