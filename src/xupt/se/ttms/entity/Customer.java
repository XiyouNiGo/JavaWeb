package xupt.se.ttms.entity;


public class Customer {
    private long cusId;
    private String cusName;
    private long cusGender;
    private String cusTelnum;
    private String cusEmail;
    private String cusUid;
    private String cusPwd;
    private long cusStatus;
    private double cusBalance;
    private String cusPaypwd;

    public long getCusId() {
        return cusId;
    }

    public void setCusId(long cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public long getCusGender() {
        return cusGender;
    }

    public void setCusGender(long cusGender) {
        this.cusGender = cusGender;
    }

    public String getCusTelnum() {
        return cusTelnum;
    }

    public void setCusTelnum(String cusTelnum) {
        this.cusTelnum = cusTelnum;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusUid() {
        return cusUid;
    }

    public void setCusUid(String cusUid) {
        this.cusUid = cusUid;
    }

    public String getCusPwd() {
        return cusPwd;
    }

    public void setCusPwd(String cusPwd) {
        this.cusPwd = cusPwd;
    }

    public long getCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(long cusStatus) {
        this.cusStatus = cusStatus;
    }

    public double getCusBalance() {
        return cusBalance;
    }

    public void setCusBalance(double cusBalance) {
        this.cusBalance = cusBalance;
    }

    public String getCusPaypwd() {
        return cusPaypwd;
    }

    public void setCusPaypwd(String cusPaypwd) {
        this.cusPaypwd = cusPaypwd;
    }
}
