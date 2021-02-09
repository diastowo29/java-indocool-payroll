package df.project.indocool.ICPayroll.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/dts/{id}")
	public DTS getDts(@PathVariable(value = "id") Long id) {
		return dtsRepo.findById(id).orElse(new DTS());
	}

	@PutMapping("/dts/{id}")
	public DTS updateDts(@PathVariable(value = "id") Long id, @RequestBody Map<String, String> param) {
		DTS updateDts = dtsRepo.findById(id).orElse(new DTS());
		updateDts.setEmployeeId(Long.valueOf(param.get("employeeId")));
		updateDts.setPresenceStatus(param.get("presenceStatus"));
		updateDts.setDtsDate(Date.valueOf(param.get("dtsDate")));
		updateDts.setJobNumber(param.get("jobNumber"));
		updateDts.setWorkingDay(param.get("workingDay"));
		updateDts.setStartWorking(param.get("startWorking"));
		updateDts.setFinishWorking(param.get("finishWorking"));
		updateDts.setJobDesc(param.get("jobDesc"));
		updateDts.setEmployeeMeal(Boolean.valueOf(param.get("employeeMeal")));
		updateDts.setEmployeeTransport(Boolean.valueOf(param.get("employeeTransport")));
		updateDts.setEmployeeProductivity(Boolean.valueOf(param.get("employeeProductivity")));
		updateDts.setEmployeeAway(Boolean.valueOf(param.get("employeeAway")));

		return dtsRepo.save(updateDts);
	}

	@DeleteMapping("/dts/{id}")
	public ResponseEntity<String> deleteDts(@PathVariable(value = "id") Long id) {
		dtsRepo.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PostMapping("/dts/add")
	public DTS createDts(@Validated @RequestBody DTS dts) {
		return dtsRepo.save(dts);
	}
}
