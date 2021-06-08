package xupt.se.ttms.dao.idao;

import java.util.List;

import xupt.se.ttms.entity.Employee;

public interface IEmployeeDAO {
    public int insert(Employee employee);

    public int update(Employee employee);

    public List<Employee> select(String employeeName);
}
