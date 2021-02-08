package df.project.indocool.ICPayroll.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class DTSController {

	@RequestMapping("/dts-new")
	String loadDtsInput() {
		return "dts-new";
	}
}
