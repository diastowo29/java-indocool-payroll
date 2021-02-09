package df.project.indocool.ICPayroll.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import df.project.indocool.ICPayroll.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByEmployeeId(String emp_id);
}
