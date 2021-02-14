package df.project.indocool.ICPayroll.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ic_dts")
public class DTS {
	private long id;
	private String employeeId;
	private String presenceStatus;
	private Date dtsDate;
	private String jobNumber;
	private String workingDay;
	private String startWorking;
	private String finishWorking;
	private String jobDesc;
	private Boolean employeeMeal;
	private Boolean employeeTransport;
	private Boolean employeeProductivity;
	private Boolean employeeAway;

	public DTS() {
	}

	public DTS(String employeeId, String presenceStatus, Date dtsDate, String jobNumber, String workingDay,
			String startWorking, String finishWorking, String jobDesc, Boolean employeeMeal, Boolean employeeTransport,
			Boolean employeeProductivity, Boolean employeeAway) {

		this.employeeId = employeeId;
		this.presenceStatus = presenceStatus;
		this.dtsDate = dtsDate;
		this.jobNumber = jobNumber;
		this.workingDay = workingDay;
		this.startWorking = startWorking;
		this.finishWorking = finishWorking;
		this.jobDesc = jobDesc;

		this.employeeMeal = employeeMeal;
		this.employeeTransport = employeeTransport;
		this.employeeProductivity = employeeProductivity;
		this.employeeAway = employeeAway;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "dts_employee_id", nullable = false)
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "dts_presence", nullable = false)
	public String getPresenceStatus() {
		return presenceStatus;
	}

	public void setPresenceStatus(String presenceStatus) {
		this.presenceStatus = presenceStatus;
	}

	@Column(name = "dts_date", nullable = false)
	public Date getDtsDate() {
		return dtsDate;
	}

	public void setDtsDate(Date dtsDate) {
		this.dtsDate = dtsDate;
	}

	@Column(name = "dts_job_number", nullable = false)
	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	@Column(name = "dts_working_day", nullable = false)
	public String getWorkingDay() {
		return workingDay;
	}

	public void setWorkingDay(String workingDay) {
		this.workingDay = workingDay;
	}

	@Column(name = "dts_start", nullable = false)
	public String getStartWorking() {
		return startWorking;
	}

	public void setStartWorking(String startWorking) {
		this.startWorking = startWorking;
	}

	@Column(name = "dts_finish", nullable = false)
	public String getFinishWorking() {
		return finishWorking;
	}

	public void setFinishWorking(String finishWorking) {
		this.finishWorking = finishWorking;
	}

	@Column(name = "dts_jobdesc", nullable = true)
	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	@Column(name = "dts_meal", nullable = false)
	public Boolean getEmployeeMeal() {
		return employeeMeal;
	}

	public void setEmployeeMeal(Boolean employeeMeal) {
		this.employeeMeal = employeeMeal;
	}

	@Column(name = "dts_away", nullable = false)
	public Boolean getEmployeeAway() {
		return employeeAway;
	}

	public void setEmployeeAway(Boolean employeeAway) {
		this.employeeAway = employeeAway;
	}

	@Column(name = "dts_productivity", nullable = false)
	public Boolean getEmployeeProductivity() {
		return employeeProductivity;
	}

	public void setEmployeeProductivity(Boolean employeeProductivity) {
		this.employeeProductivity = employeeProductivity;
	}

	@Column(name = "dts_transport", nullable = false)
	public Boolean getEmployeeTransport() {
		return employeeTransport;
	}

	public void setEmployeeTransport(Boolean employeeTransport) {
		this.employeeTransport = employeeTransport;
	}

}