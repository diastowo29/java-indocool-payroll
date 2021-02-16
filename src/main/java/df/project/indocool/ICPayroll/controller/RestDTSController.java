package df.project.indocool.ICPayroll.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import df.project.indocool.ICPayroll.model.custom.DTSCount;
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

	@GetMapping("/dts/count")
	public List<DTSCount> getDtsCount() {
		return dtsRepo.countDtsByDate();
	}

	@GetMapping("/dts/{period}/{working_days}")
	public List<DTS> summaryDts(@PathVariable(value = "period") String period,
			@PathVariable(value = "working_days") String workingDays) throws ParseException {
		int year = Integer.valueOf(period.split("-")[1]);
		int month = Integer.valueOf(period.split("-")[0]);
		
		int yearFrom = year;
		int yearTo = year;
		
		int monthFrom = month;
		int monthTo = month;
		
		if (month == 1) {
			yearFrom = year - 1;
			monthFrom = 13;
		}
		
		String from = "" + yearFrom + "-" + String.format("%02d", (monthFrom-1)) + "-20";
		String to = "" + yearTo + "-" + String.format("%02d", monthTo) + "-21";
		
		System.out.println(from);
		System.out.println(to);
				
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		
	    java.util.Date dateFrom = formatter2.parse(from);  
	    java.util.Date dateTo = formatter2.parse(to);

		return dtsRepo.summarizeDts(dateFrom, dateTo);
	}

	@PutMapping("/dts/{id}")
	public DTS updateDts(@PathVariable(value = "id") Long id, @RequestBody Map<String, String> param) {
		DTS updateDts = dtsRepo.findById(id).orElse(new DTS());
		updateDts.setEmployeeId(param.get("employeeId"));
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
