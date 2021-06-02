package xupt.se.ttms.entity;

public class Employee {
    private long empId;
    private long dictId;
    private String empNo;
    private String empName;
    private long empGender;
    private String empTelnum;
    private String empEmail;
    private String empPwd;
    private long empStatus;

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public long getDictId() {
        return dictId;
    }

    public void setDictId(long dictId) {
        this.dictId = dictId;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public long getEmpGender() {
        return empGender;
    }

    public void setEmpGender(long empGender) {
        this.empGender = empGender;
    }

    public String getEmpTelnum() {
        return empTelnum;
    }

    public void setEmpTelnum(String empTelnum) {
        this.empTelnum = empTelnum;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPwd() {
        return empPwd;
    }

    public void setEmpPwd(String empPwd) {
        this.empPwd = empPwd;
    }

    public long getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(long empStatus) {
        this.empStatus = empStatus;
    }
}
