package df.project.indocool.ICPayroll.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
}
