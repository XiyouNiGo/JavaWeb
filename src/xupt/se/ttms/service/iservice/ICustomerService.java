package xupt.se.ttms.service.iservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xupt.se.ttms.entity.Customer;

public interface ICustomerService {
    public void login(HttpServletRequest req, HttpServletResponse resp, boolean verify) throws IOException;

    public int add(Customer customer);

    public int modify(Customer customer);

    public List<Customer> Fetch(String condt);

    public List<Customer> FetchAll();
}
