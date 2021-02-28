package df.project.indocool.ICPayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import df.project.indocool.ICPayroll.model.DTSSummaryResults;
import df.project.indocool.ICPayroll.repository.DTSSummaryResultRepository;

@RestController
@RequestMapping("/api/v1")
public class RestDTSSummaryResultController {

	@Autowired
	DTSSummaryResultRepository dtsSummaryRepo;

	@PostMapping("/dts-summary/add")
	public DTSSummaryResults createDts(@Validated @RequestBody DTSSummaryResults dts) {
		return dtsSummaryRepo.save(dts);
	}
}
