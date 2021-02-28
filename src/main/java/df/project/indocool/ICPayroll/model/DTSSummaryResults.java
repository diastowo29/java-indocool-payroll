package df.project.indocool.ICPayroll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ic_summary_result")
public class DTSSummaryResults {
	private long id;
	private String summaryName;
	private String summaryResult;

	public DTSSummaryResults() {

	}

	public DTSSummaryResults(String summaryName, String summaryResult) {
		this.summaryName = summaryName;
		this.summaryResult = summaryResult;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "dts_summary_name", nullable = false)
	public String getSummaryName() {
		return summaryName;
	}

	public void setSummaryName(String summaryName) {
		this.summaryName = summaryName;
	}

	@Column(name = "dts_summary_result", nullable = false, columnDefinition = "TEXT")
	public String getSummaryResult() {
		return summaryResult;
	}

	public void setSummaryResult(String summaryResult) {
		this.summaryResult = summaryResult;
	}
}
