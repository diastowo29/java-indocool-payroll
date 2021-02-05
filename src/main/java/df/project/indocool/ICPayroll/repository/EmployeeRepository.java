package df.project.indocool.ICPayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import df.project.indocool.ICPayroll.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
