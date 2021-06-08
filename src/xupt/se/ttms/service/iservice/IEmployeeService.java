package xupt.se.ttms.service.iservice;

import java.util.List;

import xupt.se.ttms.entity.Employee;

public interface IEmployeeService {
    public int add(Employee employee);

    public int modify(Employee employee);

    public int delete(int ID);

    public List<Employee> Fetch(String condt);

    public List<Employee> FetchAll();
}
