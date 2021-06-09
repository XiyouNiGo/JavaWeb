package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.dao.idao.ICustomerDAO;
import xupt.se.ttms.entity.Customer;
import xupt.se.util.DBUtil;

public class CustomerDAO implements ICustomerDAO {
    @Override
    public int update_balance(int amount, Customer customer) {
        int result = 0;
        try {
            DBUtil db = new DBUtil();
            db.openConnection();
            String sql = String.format("select * from customer where cus_name = '%s' and cus_paypwd = '%s'",
                    customer.getCusName(), customer.getCusPaypwd());
            ResultSet rst = db.execQuery(sql);
            if (rst == null || !rst.next()) {
                return 0;
            }
            db.close(rst);
            sql = String.format("update customer set cus_balance = cus_balance + %d where "
                    + "cus_name = '%s' and cus_paypwd = '%s'", amount, customer.getCusName(),
                    customer.getCusPaypwd());

            result = db.execCommand(sql);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @Override
    public int insert(Customer customer) {
        int result = 0;
        try {
            String sql = String.format("insert into customer(cus_name, cus_gender, cus_telnum, "
                            + "cus_email, cus_pwd, cus_status, cus_balance, cus_paypwd)"
                            + " values('%s', '%d', '%s', '%s', '%s', '%d', '%d', '%s')",
                    customer.getCusName(),
                    customer.getCusGender(), customer.getCusTelnum(),
                    customer.getCusEmail(), customer.getCusPwd(), 1, 0,
                    customer.getCusPaypwd());
            DBUtil db = new DBUtil();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDs(sql);
            if (rst != null && rst.first()) {
                customer.setCusId(rst.getInt(1));
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
    public int update(Customer customer) {
        int result = 0;
        try {
            String sql = String.format("update customer set cus_name = '%s', cus_gender = '%s', "
                            + "cus_telnum = '%s', cus_email = '%s' where cus_id = '%ld'", customer.getCusName(),
            customer.getCusGender(), customer.getCusTelnum(), customer.getCusEmail(), customer.getCusId());
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
    public List<Customer> select(String uname) {
        DBUtil db = null;
        List<Customer> customerList = new LinkedList<Customer>();
        try {
            uname.trim();
            String sql = "select * from customer where cus_name like '%" + uname + "%'";
            db = new DBUtil();
            if (!db.openConnection()) {
                System.out.print("fail to connect database");
                return null;
            }
            ResultSet rst = db.execQuery(sql);
            if (rst != null) {
                while (rst.next()) {
                    Customer customer = new Customer();
                    customer.setCusName(rst.getString("cus_name"));
                    customer.setCusGender(rst.getLong("cus_gender"));
                    customer.setCusTelnum(rst.getString("cus_telnum"));
                    customer.setCusEmail(rst.getString("cus_email"));
                    customer.setCusUid(rst.getString("cus_uid"));
                    customer.setCusPwd(rst.getString("cus_pwd"));
                    customer.setCusBalance(rst.getDouble("cus_balance"));
                    customer.setCusPaypwd(rst.getString("cus_paypwd"));
                    customerList.add(customer);
                }
            }
            db.close(rst);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return customerList;
        }
    }
}
