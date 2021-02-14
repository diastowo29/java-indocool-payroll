package df.project.indocool.ICPayroll.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import df.project.indocool.ICPayroll.model.DTS;
import df.project.indocool.ICPayroll.model.custom.DTSCount;

public interface DTSRepository extends JpaRepository<DTS, Long> {

	@Query("SELECT new df.project.indocool.ICPayroll.model.custom.DTSCount(id.dtsDate, COUNT(id.dtsDate)) "
			+ "FROM DTS AS id GROUP BY id.dtsDate ")
	List<DTSCount> countDtsByDate();

	@Query("SELECT id FROM DTS id WHERE id.dtsDate > ?1 and id.dtsDate < ?2 " + "ORDER BY id.employeeId, id.dtsDate")
	List<DTS> summarizeDts(Date dateFrom, Date dateTo);

}
