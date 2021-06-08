package xupt.se.ttms.dao.idao;

import java.util.List;

import xupt.se.ttms.entity.Customer;

public interface ICustomerDAO {
    public int insert(Customer customer);

    public int update(Customer customer);

    public List<Customer> select(String uname);

    public int update_balance(int amount, Customer customer);
}
