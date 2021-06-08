package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.dao.idao.IEmployeeDAO;
import xupt.se.ttms.entity.Employee;
import xupt.se.util.DBUtil;

public class EmployeeDAO implements IEmployeeDAO {
    @Override
    public int insert(Employee employee) {
        int result = 0;
        try {
            String sql = String.format("insert into employee(emp_name, emp_gender, emp_telnum, "
                            + "emp_email, emp_pwd)"
                            + " values('%s', '%ld', '%s', '%s', '%s')", employee.getEmpName(),
                    employee.getEmpGender(), employee.getEmpTelnum(),
                    employee.getEmpEmail(), employee.getEmpPwd());
            DBUtil db = new DBUtil();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDs(sql);
            if (rst != null && rst.first()) {
                employee.setEmpId(rst.getInt(1));
            }
            db.close(rst);
            db.close();
            result = 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @Override
    public int update(Employee employee) {
        int result = 0;
        try {
            String sql = String.format("update employee set emp_name = '%s', emp_gender = '%s', "
                            + "emp_telnum = '%s', emp_email = '%s' where emp_id = '%ld'", employee.getEmpName(),
                    employee.getEmpGender(), employee.getEmpTelnum(), employee.getEmpEmail(), employee.getEmpId());
            DBUtil db = new DBUtil();
            db.openConnection();
            result = db.execCommand(sql);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @Override
    public List<Employee> select(String employeeName) {
        DBUtil db = null;
        List<Employee> employeeList = new LinkedList<Employee>();
        try {
            employeeName.trim();
            String sql = "select * from employee where emp_name like '%" + employeeName + "%'";
            db = new DBUtil();
            if (!db.openConnection()) {
                System.out.print("fail to connect database");
                return null;
            }
            ResultSet rst = db.execQuery(sql);
            if (rst != null) {
                while (rst.next()) {
                    Employee employee = new Employee();
                    employee.setEmpName(rst.getString("emp_name"));
                    employee.setEmpGender(rst.getLong("emp_gender"));
                    employee.setEmpTelnum(rst.getString("emp_telnum"));
                    employee.setEmpEmail(rst.getString("emp_email"));
                    employee.setEmpPwd(rst.getString("emp_pwd"));
                    employeeList.add(employee);
                }
            }
            db.close(rst);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return employeeList;
        }
    }
}
