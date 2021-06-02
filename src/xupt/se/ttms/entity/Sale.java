package xupt.se.ttms.entity;

public class Sale {
    private long saleId;
    private long empId;
    private long cusId;
    private java.sql.Timestamp saleTime;
    private double salePayment;
    private double saleChange;
    private long saleType;
    private long saleStatus;
    private long saleSort;

    public long getSaleId() {
        return saleId;
    }

    public void setSaleId(long saleId) {
        this.saleId = saleId;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public long getCusId() {
        return cusId;
    }

    public void setCusId(long cusId) {
        this.cusId = cusId;
    }

    public java.sql.Timestamp getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(java.sql.Timestamp saleTime) {
        this.saleTime = saleTime;
    }

    public double getSalePayment() {
        return salePayment;
    }

    public void setSalePayment(double salePayment) {
        this.salePayment = salePayment;
    }

    public double getSaleChange() {
        return saleChange;
    }

    public void setSaleChange(double saleChange) {
        this.saleChange = saleChange;
    }

    public long getSaleType() {
        return saleType;
    }

    public void setSaleType(long saleType) {
        this.saleType = saleType;
    }

    public long getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(long saleStatus) {
        this.saleStatus = saleStatus;
    }

    public long getSaleSort() {
        return saleSort;
    }

    public void setSaleSort(long saleSort) {
        this.saleSort = saleSort;
    }
}
