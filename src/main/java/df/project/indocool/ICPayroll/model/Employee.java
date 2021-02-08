package df.project.indocool.ICPayroll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ic_employee")
public class Employee {
	private long id;
	private String workingSite;
	private String employeeStatus;
	private String employeeName;
	private String placeofBirth;
	private String dateofBirth;
	private String employeeNik;
	private String employeeKk;
	private String employeeNpwp;
	private String employeeMaritalStatus;
	private String motherName;
	private String bpjsTk;
	private String bpjsKs;
	private String employeeAddress;
	private String employeeEmail;
	private String employeePhone;
	private String employeeDivision;
	private String employeeJoinDate;
	private String employeeJobPosition;
	private Double employeeBasicSalary;
	private Double employeeMeal;
	private Double employeeTransport;
	private Double employeeAttendance;
	private Double employeeOntime;
	private Double employeeHse;
	private Double employeeProductivity;
	private Double employeeFix;
	private Double employeeOvertime;
	private Double employeeAway;

	public Employee() {

	}

	public Employee(String workingSite, String employeeStatus, String employeeName, String placeofBirth,
			String dateofBirth, String employeeNik, String employeeKk, String employeeNpwp,
			String employeeMaritalStatus, String motherName, String bpjsTk, String bpjsKs, String employeeAddress,
			String employeeEmail, String employeePhone, String employeeDivision, String employeeJoinDate,
			String employeeJobPosition, Double employeeBasicSalary, Double employeeMeal, Double employeeTransport,
			Double employeeAttendance, Double employeeOntime, Double employeeHse, Double employeeProductivity,
			Double employeeFix, Double employeeOvertime, Double employeeAway) {
		this.workingSite = workingSite;
		this.employeeStatus = employeeStatus;
		this.employeeName = employeeName;
		this.placeofBirth = placeofBirth;
		this.dateofBirth = dateofBirth;
		this.employeeNik = employeeNik;
		this.employeeKk = employeeKk;
		this.employeeNpwp = employeeNpwp;
		this.employeeMaritalStatus = employeeMaritalStatus;
		this.motherName = motherName;
		this.bpjsTk = bpjsTk;
		this.bpjsKs = bpjsKs;
		this.employeeAddress = employeeAddress;
		this.employeeEmail = employeeEmail;
		this.employeePhone = employeePhone;
		this.employeeDivision = employeeDivision;
		this.employeeJoinDate = employeeJoinDate;
		this.employeeJobPosition = employeeJobPosition;
		this.employeeBasicSalary = employeeBasicSalary;
		this.employeeMeal = employeeMeal;
		this.employeeTransport = employeeTransport;
		this.employeeAttendance = employeeAttendance;
		this.employeeOntime = employeeOntime;
		this.employeeHse = employeeHse;
		this.employeeProductivity = employeeProductivity;
		this.employeeFix = employeeFix;
		this.employeeOvertime = employeeOvertime;
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

	@Column(name = "working_site", nullable = false)
	public String getWorkingSite() {
		return workingSite;
	}

	public void setWorkingSite(String workingSite) {
		this.workingSite = workingSite;
	}

	@Column(name = "employee_status", nullable = false)
	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	@Column(name = "employee_name", nullable = false)
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Column(name = "employee_pob", nullable = false)
	public String getPlaceofBirth() {
		return placeofBirth;
	}

	public void setPlaceofBirth(String placeofBirth) {
		this.placeofBirth = placeofBirth;
	}

	@Column(name = "employee_dob", nullable = false)
	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	@Column(name = "employee_nik", nullable = false)
	public String getEmployeeNik() {
		return employeeNik;
	}

	public void setEmployeeNik(String employeeNik) {
		this.employeeNik = employeeNik;
	}

	@Column(name = "employee_kk", nullable = false)
	public String getEmployeeKk() {
		return employeeKk;
	}

	public void setEmployeeKk(String employeeKk) {
		this.employeeKk = employeeKk;
	}

	@Column(name = "employee_npwp", nullable = false)
	public String getEmployeeNpwp() {
		return employeeNpwp;
	}

	public void setEmployeeNpwp(String employeeNpwp) {
		this.employeeNpwp = employeeNpwp;
	}

	@Column(name = "employee_marital_status", nullable = false)
	public String getEmployeeMaritalStatus() {
		return employeeMaritalStatus;
	}

	public void setEmployeeMaritalStatus(String employeeMaritalStatus) {
		this.employeeMaritalStatus = employeeMaritalStatus;
	}

	@Column(name = "employee_mother_name", nullable = false)
	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@Column(name = "employee_bpjs_tk", nullable = false)
	public String getBpjsTk() {
		return bpjsTk;
	}

	public void setBpjsTk(String bpjsTk) {
		this.bpjsTk = bpjsTk;
	}

	@Column(name = "employee_bpjs_ks", nullable = false)
	public String getBpjsKs() {
		return bpjsKs;
	}

	public void setBpjsKs(String bpjsKs) {
		this.bpjsKs = bpjsKs;
	}

	@Column(name = "employee_address", nullable = false)
	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	@Column(name = "employee_email", nullable = false)
	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	@Column(name = "employee_phone", nullable = false)
	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	@Column(name = "employee_division", nullable = false)
	public String getEmployeeDivision() {
		return employeeDivision;
	}

	public void setEmployeeDivision(String employeeDivision) {
		this.employeeDivision = employeeDivision;
	}

	@Column(name = "employee_join_date", nullable = false)
	public String getEmployeeJoinDate() {
		return employeeJoinDate;
	}

	public void setEmployeeJoinDate(String employeeJoinDate) {
		this.employeeJoinDate = employeeJoinDate;
	}

	@Column(name = "employee_job_position", nullable = false)
	public String getEmployeeJobPosition() {
		return employeeJobPosition;
	}

	public void setEmployeeJobPosition(String employeeJobPosition) {
		this.employeeJobPosition = employeeJobPosition;
	}

	@Column(name = "employee_basic_salary", nullable = false)
	public Double getEmployeeBasicSalary() {
		return employeeBasicSalary;
	}

	public void setEmployeeBasicSalary(Double employeeBasicSalary) {
		this.employeeBasicSalary = employeeBasicSalary;
	}

	@Column(name = "employee_meal", nullable = false)
	public Double getEmployeeMeal() {
		return employeeMeal;
	}

	public void setEmployeeMeal(Double employeeMeal) {
		this.employeeMeal = employeeMeal;
	}

	@Column(name = "employee_attendance", nullable = false)
	public Double getEmployeeAttendance() {
		return employeeAttendance;
	}

	public void setEmployeeAttendance(Double employeeAttendance) {
		this.employeeAttendance = employeeAttendance;
	}

	@Column(name = "employee_away", nullable = false)
	public Double getEmployeeAway() {
		return employeeAway;
	}

	public void setEmployeeAway(Double employeeAway) {
		this.employeeAway = employeeAway;
	}

	@Column(name = "employee_fix", nullable = false)
	public Double getEmployeeFix() {
		return employeeFix;
	}

	public void setEmployeeFix(Double employeeFix) {
		this.employeeFix = employeeFix;
	}

	@Column(name = "employee_hse", nullable = false)
	public Double getEmployeeHse() {
		return employeeHse;
	}

	public void setEmployeeHse(Double employeeHse) {
		this.employeeHse = employeeHse;
	}

	@Column(name = "employee_ontime", nullable = false)
	public Double getEmployeeOntime() {
		return employeeOntime;
	}

	public void setEmployeeOntime(Double employeeOntime) {
		this.employeeOntime = employeeOntime;
	}

	@Column(name = "employee_overtime", nullable = false)
	public Double getEmployeeOvertime() {
		return employeeOvertime;
	}

	public void setEmployeeOvertime(Double employeeOvertime) {
		this.employeeOvertime = employeeOvertime;
	}

	@Column(name = "employee_productivity", nullable = false)
	public Double getEmployeeProductivity() {
		return employeeProductivity;
	}

	public void setEmployeeProductivity(Double employeeProductivity) {
		this.employeeProductivity = employeeProductivity;
	}

	@Column(name = "employee_transport", nullable = false)
	public Double getEmployeeTransport() {
		return employeeTransport;
	}

	public void setEmployeeTransport(Double employeeTransport) {
		this.employeeTransport = employeeTransport;
	}

}
