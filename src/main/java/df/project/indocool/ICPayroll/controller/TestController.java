package df.project.indocool.ICPayroll.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

	@GetMapping("/test")
	public List<String> getAllDppu() {
		List<String> a = new ArrayList<String>();
		return a;
	}

}
