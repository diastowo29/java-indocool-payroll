package df.project.indocool.ICPayroll.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class FingerprintController {

	@RequestMapping("/fingerprint")
	String loadFingerprint() {
		return "fingerprint";
	}
}
