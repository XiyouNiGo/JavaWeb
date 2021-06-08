package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.dao.factory.EmployeeDAOFactory;
import xupt.se.ttms.dao.idao.IEmployeeDAO;
import xupt.se.ttms.entity.Employee;

public class EmployeeService {
    private IEmployeeDAO employeeDAO = EmployeeDAOFactory.creatEmployeeDAO();

    public int add(Employee employee) {
        return employeeDAO.insert(employee);
    }

    public int modify(Employee employee) {
        return employeeDAO.update(employee);
    }

    public List<Employee> Fetch(String condt) {
        return employeeDAO.select(condt);
    }

    public List<Employee> FetchAll() {
        return employeeDAO.select("");
    }
}
