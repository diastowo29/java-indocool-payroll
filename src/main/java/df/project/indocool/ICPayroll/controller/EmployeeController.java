package df.project.indocool.ICPayroll.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class EmployeeController {

	@RequestMapping("/emp")
	String loadEmployeeNew() {
		return "employee";
	}
	
	@RequestMapping("/emp-list")
	String loadEmployeeList() {
		return "employee-list";
	}
}
