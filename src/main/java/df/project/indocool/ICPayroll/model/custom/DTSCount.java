package df.project.indocool.ICPayroll.model.custom;

import java.util.Date;

public class DTSCount {
	private Date tanggal;
    private long total;

    public DTSCount(Date tanggal, long total) {
        this.tanggal = tanggal;
        this.total = total;
    }
    
    public Date getTanggal() {
		return tanggal;
	}
    
    public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}
    
    public long getTotal() {
		return total;
	}
    
    public void setTotal(long total) {
		this.total = total;
	}
}
