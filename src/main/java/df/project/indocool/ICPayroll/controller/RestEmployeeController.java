package df.project.indocool.ICPayroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
