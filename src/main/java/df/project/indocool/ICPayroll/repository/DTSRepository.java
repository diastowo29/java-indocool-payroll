package df.project.indocool.ICPayroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import df.project.indocool.ICPayroll.model.DTS;
import df.project.indocool.ICPayroll.model.custom.DTSCount;

public interface DTSRepository extends JpaRepository<DTS, Long>{
	
	@Query("SELECT new df.project.indocool.ICPayroll.model.custom.DTSCount(id.dtsDate, COUNT(id.dtsDate)) "
			+ "FROM DTS AS id GROUP BY id.dtsDate ")
	List<DTSCount> countDtsByDate();

	
}
