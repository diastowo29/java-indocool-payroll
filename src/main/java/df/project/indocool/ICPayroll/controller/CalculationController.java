package df.project.indocool.ICPayroll.controller;

import df.project.indocool.ICPayroll.model.DTSSummaryResults;
import df.project.indocool.ICPayroll.repository.DTSSummaryResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@SpringBootApplication
public class CalculationController {

	@Autowired
	DTSSummaryResultRepository summaryResult;

	@RequestMapping("/calculation")
	String loadDtsInput(Model model) {
		List<DTSSummaryResults> sums = summaryResult.findAll();
		model.addAttribute("sums", sums);
		return "calculation";
	}

}
