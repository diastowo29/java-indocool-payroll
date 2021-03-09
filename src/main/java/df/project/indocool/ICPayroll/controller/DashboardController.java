package df.project.indocool.ICPayroll.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class DashboardController {
	
	@RequestMapping("/admin")
	String loadAdminPage() {
		return "dashboard";
	}
	
	@RequestMapping("/")
	String redirectToHome () {
		return "redirect:/admin";
	}
}
