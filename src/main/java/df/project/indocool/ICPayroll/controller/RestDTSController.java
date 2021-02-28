package df.project.indocool.ICPayroll.controller;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
import df.project.indocool.ICPayroll.model.Employee;
import df.project.indocool.ICPayroll.model.custom.DTSCount;
import df.project.indocool.ICPayroll.repository.DTSRepository;
import df.project.indocool.ICPayroll.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class RestDTSController {
	@Autowired
	DTSRepository dtsRepo;
	@Autowired
	EmployeeRepository empRepo;

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
	public ResponseEntity<Object> summaryDts(@PathVariable(value = "period") String period,
			@PathVariable(value = "working_days") String workingDays) throws ParseException {
	    DecimalFormat doubleFormat = new DecimalFormat("#.##");
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

		String from = "" + yearFrom + "-" + String.format("%02d", (monthFrom - 1)) + "-20";
		String to = "" + yearTo + "-" + String.format("%02d", monthTo) + "-21";

		System.out.println(from);
		System.out.println(to);

		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");

		java.util.Date dateFrom = formatter2.parse(from);
		java.util.Date dateTo = formatter2.parse(to);
		List<DTS> dtsList = dtsRepo.summarizeDts(dateFrom, dateTo);
		List<Employee> empList = empRepo.findAll();
		ArrayList<HashMap<String, Object>> aList = new ArrayList<>();
		HashMap<String, Object> dtsMap = new HashMap<>();

		for (DTS dts : dtsList) {
			int meal = 0;
			if (dts.getEmployeeMeal()) {
				meal = 1;
			}
			int transport = 0;
			if (dts.getEmployeeTransport()) {
				transport = 1;
			}
			int away = 0;
			if (dts.getEmployeeAway()) {
				away = 1;
			}
			int productivity = 0;
			if (dts.getEmployeeProductivity()) {
				productivity = 1;
			}
			int workingDay = 0;
			double workingWeekendHours = 0;
			double workingWeekdayHours = 0;
			if (dts.getPresenceStatus().equals("Working")) {
				String time1 = dts.getStartWorking();
				String time2 = dts.getFinishWorking();
				
				SimpleDateFormat format = new SimpleDateFormat("HH:mm");
				java.util.Date date1 = format.parse(time1);
				java.util.Date date2 = format.parse(time2);
				double difference = date2.getTime() - date1.getTime();
				double diffHours = (difference / (60 * 1000) / 60);
				if (dts.getWorkingDay().equals("WD")) {
					workingDay = 1;
					String time12 = "12:00";
					java.util.Date date12 = format.parse(time12);
					if ((date12.getTime() - date1.getTime()) > 0) {
						if ((date2.getTime() - date12.getTime()) < 0) {
							diffHours = diffHours + 1;
						}
					}
					workingWeekdayHours = diffHours;
				} else {
					String time12 = "12:00";
					java.util.Date date12 = format.parse(time12);
					if ((date12.getTime() - date1.getTime()) > 0) {
						if ((date2.getTime() - date12.getTime()) > 0) {
							diffHours = diffHours - 1;
						}
					}
					workingWeekendHours = diffHours;	
				}
			}
			String empName = "";
			for (Employee employee : empList) {
				if (dts.getEmployeeId().equals(employee.getEmployeeId())) {
					empName = employee.getEmployeeName();
					dtsMap.put("employee_name", empName);
				}
			}
			
			
			dtsMap = new HashMap<>();
			dtsMap.put("employee_id", dts.getEmployeeId());

			boolean isExist = false;
			int existIndex = 0;
			for (int i = 0; i < aList.size(); i++) {
				if (aList.get(i).get("employee_id").equals(dts.getEmployeeId())) {
					isExist = true;
					existIndex = i;
				}
			}
			if (!isExist) {
				dtsMap.put("weekday_hours", workingWeekdayHours);
				dtsMap.put("weekend_hours", workingWeekendHours);
				dtsMap.put("meal", meal);
				dtsMap.put("productivity", productivity);
				dtsMap.put("away", away);
				dtsMap.put("transport", transport);
				dtsMap.put("workingDay", workingDay);
				aList.add(dtsMap);
			} else {
				aList.get(existIndex).put("meal", Integer.valueOf(aList.get(existIndex).get("meal").toString()) + meal);
				aList.get(existIndex).put("productivity",
						Integer.valueOf(aList.get(existIndex).get("productivity").toString()) + productivity);
				aList.get(existIndex).put("away", Integer.valueOf(aList.get(existIndex).get("away").toString()) + away);
				aList.get(existIndex).put("transport",
						Integer.valueOf(aList.get(existIndex).get("transport").toString()) + transport);
				aList.get(existIndex).put("workingDay",
						Integer.valueOf(aList.get(existIndex).get("workingDay").toString()) + workingDay);
				aList.get(existIndex).put("weekend_hours",
						Double.valueOf(aList.get(existIndex).get("weekend_hours").toString()) + workingWeekendHours);
				aList.get(existIndex).put("weekday_hours",
						Double.valueOf(aList.get(existIndex).get("weekday_hours").toString()) + workingWeekdayHours);
			}
		}

		return new ResponseEntity<Object>(aList, HttpStatus.OK);
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
