package df.project.indocool.ICPayroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import df.project.indocool.ICPayroll.model.DTS;
import df.project.indocool.ICPayroll.repository.DTSRepository;

@RestController
@RequestMapping("/api/v1")
public class RestDTSController {
	@Autowired
	DTSRepository dtsRepo;

	@GetMapping("/dts")
	public List<DTS> getAllDts() {
		return dtsRepo.findAll();
	}

	@PostMapping("/dts/add")
	public DTS createDts(@Validated @RequestBody DTS dts) {
		return dtsRepo.save(dts);
	}
}
