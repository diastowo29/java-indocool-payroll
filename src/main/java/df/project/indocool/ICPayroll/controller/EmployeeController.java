package df.project.indocool.ICPayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import df.project.indocool.ICPayroll.model.Employee;
import df.project.indocool.ICPayroll.repository.EmployeeRepository;

@Controller
@SpringBootApplication
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;

	@RequestMapping("/emp")
	String loadEmployeeNew() {
		return "employee";
	}
	
	@RequestMapping("/emp-list")
	String loadEmployeeList() {
		return "employee-list";
	}
	
	@RequestMapping("/emp-update")
	String loadEmployeeUpdate (Model model, @RequestParam(value = "id") Long id) {
		Employee emp = empRepo.getOne(id);
		model.addAttribute("emp", emp);
		return "employee-update";
	}
}
