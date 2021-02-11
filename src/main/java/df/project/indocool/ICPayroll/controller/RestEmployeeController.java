package df.project.indocool.ICPayroll.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import df.project.indocool.ICPayroll.model.Employee;
import df.project.indocool.ICPayroll.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class RestEmployeeController {
	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@PostMapping("/employee/add")
	public Employee createEmployee(@Validated @RequestBody Employee employee) {
		return empRepo.save(employee);
	}

	@GetMapping("/employee/{id}")
	public Optional<Employee> findEmployeeById(@PathVariable(value = "id") Long id) {
		return empRepo.findById(id);
	}
	
	@DeleteMapping("/employee/{id}")
	public Employee deleteEmployee(@PathVariable(value = "id") Long id) {
		Employee empToDelete = empRepo.getOne(id);
		empRepo.delete(empToDelete);
		return empToDelete;
	}

	@GetMapping("/employee/get/{emp_id}")
	public Employee findEmployeeByEmpId(@PathVariable(value = "emp_id") String emp_id) {
		return empRepo.findByEmployeeId(emp_id).orElse(new Employee());
	}

	@PostMapping("/employee/update")
	public Employee updateEmployee(@RequestBody Map<String, String> param) {
		long id = Long.valueOf(param.get("id"));
		Employee emp = empRepo.findById(id).orElse(new Employee());
		emp.setWorkingSite(param.get("workingSite"));
		emp.setEmployeeStatus(param.get("employeeStatus"));
		emp.setEmployeeName(param.get("employeeName"));
		emp.setPlaceofBirth(param.get("placeofBirth"));
		emp.setDateofBirth(param.get("dateofBirth"));
		emp.setEmployeeNik(param.get("employeeNik"));
		emp.setEmployeeKk(param.get("employeeKk"));
		emp.setEmployeeNpwp(param.get("employeeNpwp"));
		emp.setEmployeeMaritalStatus(param.get("employeeMaritalStatus"));
		emp.setMotherName(param.get("motherName"));
		emp.setBpjsTk(param.get("bpjsTk"));
		emp.setBpjsKs(param.get("bpjsKs"));
		emp.setEmployeeAddress(param.get("employeeAddress"));
		emp.setEmployeeEmail(param.get("employeeEmail"));
		emp.setEmployeePhone(param.get("employeePhone"));
		emp.setEmployeeDivision(param.get("employeeDivision"));
		emp.setEmployeeJoinDate(param.get("employeeJoinDate"));
		emp.setEmployeeJobPosition(param.get("employeeJobPosition"));
		emp.setEmployeeBasicSalary(Double.valueOf(param.get("employeeBasicSalary")));
		emp.setEmployeeMeal(Double.valueOf(param.get("employeeMeal")));
		emp.setEmployeeTransport(Double.valueOf(param.get("employeeTransport")));
		emp.setEmployeeAttendance(Double.valueOf(param.get("employeeAttendance")));
		emp.setEmployeeOntime(Double.valueOf(param.get("employeeOntime")));
		emp.setEmployeeHse(Double.valueOf(param.get("employeeHse")));
		emp.setEmployeeProductivity(Double.valueOf(param.get("employeeProductivity")));
		emp.setEmployeeFix(Double.valueOf(param.get("employeeFix")));
		emp.setEmployeeOvertime(Double.valueOf(param.get("employeeOvertime")));
		emp.setEmployeeAway(Double.valueOf(param.get("employeeAway")));

		return empRepo.save(emp);
	}
}
