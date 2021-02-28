package df.project.indocool.ICPayroll.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import df.project.indocool.ICPayroll.model.DTSSummaryResults;
import df.project.indocool.ICPayroll.model.Employee;
import df.project.indocool.ICPayroll.repository.DTSSummaryResultRepository;
import df.project.indocool.ICPayroll.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class RestCalculationController {

	@Autowired
	DTSSummaryResultRepository dtsSummaryRepo;
	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/calculation/{summary_name}")
	public ResponseEntity<Object> getAllDts(@PathVariable(value = "summary_name") String summaryName) {
		List<DTSSummaryResults> dtsSummary = dtsSummaryRepo.findAll();
		List<Employee> employeeList = empRepo.findAll();
		ArrayList<HashMap<String, Object>> calcList = new ArrayList<>();
		HashMap<String, Object> dtsMap = new HashMap<>();
		for (DTSSummaryResults dtsSummaryResults : dtsSummary) {
			if (dtsSummaryResults.getSummaryName().equals(summaryName)) {
				System.out.println(dtsSummaryResults.getSummaryName());
				JSONArray summaryArray = new JSONArray(dtsSummaryResults.getSummaryResult());
				for (int i = 0; i < summaryArray.length(); i++) {
					String employeeId = summaryArray.getJSONObject(i).get("employee_id").toString();
					String employeeName = summaryArray.getJSONObject(i).get("employee_name").toString();
					double mealsSummary = (double) summaryArray.getJSONObject(i).getInt("meal");
					double productivitySummary = (double) summaryArray.getJSONObject(i).getInt("productivity");
					double transportSummary = (double) summaryArray.getJSONObject(i).getInt("transport");
					double awaySummary = (double) summaryArray.getJSONObject(i).getInt("away");
					double weekdayHours = (double) summaryArray.getJSONObject(i).getInt("weekday_hours");
					double weekendHours = (double) summaryArray.getJSONObject(i).getInt("weekend_hours");
					double workingDay = (double) summaryArray.getJSONObject(i).getInt("workingDay");
					double overtimeSummary = weekdayHours - ((9 * workingDay) + weekendHours);
					if (overtimeSummary < 0) {
						overtimeSummary = (double) 0;
					}
					System.out.println(summaryArray.getJSONObject(i).get("employee_name"));
					for (Employee employee : employeeList) {
						if (employeeId.equals(employee.getEmployeeId())) {
							dtsMap = new HashMap<>();

							double basicSalary = employee.getEmployeeBasicSalary();
							double mealsAllowance = employee.getEmployeeMeal() * mealsSummary;
							double productivityAllowance = employee.getEmployeeProductivity() * productivitySummary;
							double transportAllowance = employee.getEmployeeTransport() * transportSummary;
							double awayAllowance = employee.getEmployeeAway() * awaySummary;

							double overtime = employee.getEmployeeOvertime() * (overtimeSummary);
							dtsMap.put("name", employeeName);
							dtsMap.put("basic_salary", basicSalary);
							dtsMap.put("meals", mealsAllowance);
							dtsMap.put("productivity", productivityAllowance);
							dtsMap.put("transport", transportAllowance);
							dtsMap.put("away", awayAllowance);
							dtsMap.put("overtime", overtime);

							calcList.add(dtsMap);
						}
					}
				}
			}
		}
		return new ResponseEntity<Object>(calcList, HttpStatus.OK);
	}
}
