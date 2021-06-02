package xupt.se.ttms.dao.factory;

import xupt.se.ttms.dao.CustomerDAO;
import xupt.se.ttms.dao.idao.ICustomerDAO;

public class CustomerDAOFactory {
    private static ICustomerDAO customerDAO = null;

    public static synchronized ICustomerDAO createCustomerDAO() {
        if (null == customerDAO)
            customerDAO = new CustomerDAO();
        return customerDAO;
    }
}
