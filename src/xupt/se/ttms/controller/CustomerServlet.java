package xupt.se.ttms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xupt.se.ttms.entity.Customer;
import xupt.se.ttms.service.CustomerService;
import xupt.se.util.MD5Utils;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        int id = 0;
        if (type.equalsIgnoreCase("login"))
            login(req, resp, false);
        else if (type.equalsIgnoreCase("setimfo"))
            setImformation(req, resp);
        else if (type.equalsIgnoreCase("register"))
            register(req, resp);
        else if (type.equalsIgnoreCase("recharge"))
            recharge(req, resp);
    }

    private void recharge(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        try {
            int amount = Integer.valueOf(req.getParameter("amount"));
            Customer customer = new Customer();
            customer.setCusName(req.getParameter("uname"));
            customer.setCusPaypwd(MD5Utils.MD5(req.getParameter("paypwd")).substring(0, 20));

            if (new CustomerService().recharge(amount, customer) == 1) {
                out.write("true");
            } else {
                out.write("false");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            out.write("false");
        } finally {
            out.close();
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp, boolean forward) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        try {
            CustomerService customerService = new CustomerService();
            customerService.login(req, resp, forward);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            resp.getWriter().write("false");
        }
    }

    private void setImformation(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        try {
            String name = req.getParameter("uname");
            Long gender = Long.valueOf(req.getParameter("gender"));
            String telnum = req.getParameter("telnum");
            String email = req.getParameter("email");
            String uid = req.getParameter("uid");
            Customer customer = new Customer(name, gender, telnum, email, uid);
            PrintWriter out = resp.getWriter();

            if (new CustomerService().modify(customer) == 1)
                out.write("数据修改成功");
            else
                out.write("数据修改失败，请重试");

            out.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            resp.getWriter().write("操作错误，请重试");
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Customer customer = null;
        try {
            customer = new Customer();
            customer.setCusName(request.getParameter("uname"));
            customer.setCusGender(Long.valueOf(request.getParameter("gender")));
            customer.setCusTelnum(request.getParameter("telnum"));
            customer.setCusEmail(request.getParameter("email"));
            customer.setCusPwd(MD5Utils.MD5(request.getParameter("passwd")).substring(0, 20));
            System.out.println(customer.getCusPwd());
            customer.setCusPaypwd(MD5Utils.MD5(request.getParameter("paypwd")).substring(0, 20));
            PrintWriter out = response.getWriter();

            if (new CustomerService().add(customer) == 1)
                out.write("true");
            else
                out.write("false");

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("false");
        }
    }
}