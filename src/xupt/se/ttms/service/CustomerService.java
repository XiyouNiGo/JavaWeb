package xupt.se.ttms.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xupt.se.ttms.dao.factory.CustomerDAOFactory;
import xupt.se.ttms.dao.idao.ICustomerDAO;
import xupt.se.ttms.entity.Customer;
import xupt.se.ttms.service.iservice.ICustomerService;

import xupt.se.util.MD5Utils;

public class CustomerService implements ICustomerService {
    @Override
    public int pay(int amount, Customer customer) {
        return customerDAO.update_balance(-amount, customer);
    }

    @Override
    public int recharge(int amount, Customer customer) {
        return customerDAO.update_balance(amount, customer);
    }

    private ICustomerDAO customerDAO = CustomerDAOFactory.createCustomerDAO();

    @Override
    public void login(HttpServletRequest req, HttpServletResponse resp, boolean forward) throws IOException {
        String uname = null, passwd = null;
        boolean uname_cookie = false, passwd_cookie = false;

        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("uname")) {
                    uname = cookie.getValue();
                    uname_cookie = true;
                } else if (cookie.getName().equals("passwd")) {
                    passwd = cookie.getValue();
                    passwd_cookie = true;
                }
            }
        }
        if (uname_cookie == false && passwd_cookie == false) {
            uname = req.getParameter("uname");
//            passwd = req.getParameter("passwd");
            passwd = MD5Utils.MD5(req.getParameter("passwd")).substring(0, 20);
        }
        try {
            List<Customer> customerList = customerDAO.select(uname);
            if (customerList.size() < 1) {
                throw new Exception("No such uname");
            }
            String real_pwd = customerList.get(0).getCusPwd();
            if (passwd.equals(real_pwd)) {
                resp.getWriter().write("true");
                resp.addCookie(new Cookie("uname", uname));
                resp.addCookie(new Cookie("passwd", passwd));
            } else {
                resp.getWriter().write("false");
                if (forward) {
                    req.getRequestDispatcher("login.html").forward(req, resp);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            resp.getWriter().write("false");
        }
    }

    @Override
    public int add(Customer customer) {
        return customerDAO.insert(customer);
    }

    @Override
    public int modify(Customer customer) {
        return customerDAO.update(customer);
    }

    @Override
    public List<Customer> Fetch(String condt) {
        return customerDAO.select(condt);
    }

    @Override
    public List<Customer> FetchAll() {
        return customerDAO.select("");
    }
}
