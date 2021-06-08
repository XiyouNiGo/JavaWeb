package xupt.se.ttms.dao.factory;

import xupt.se.ttms.dao.EmployeeDAO;
import xupt.se.ttms.dao.idao.IEmployeeDAO;

public class EmployeeDAOFactory {
    private static IEmployeeDAO employeeDao = null;

    public static synchronized IEmployeeDAO creatEmployeeDAO() {
        if (null == employeeDao)
            employeeDao = new EmployeeDAO();
        return employeeDao;
    }
}
