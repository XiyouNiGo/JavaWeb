package xupt.se.ttms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xupt.se.ttms.entity.Customer;
import xupt.se.ttms.service.CustomerService;

@WebServlet("CustomerServlet")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        int id = 0;
        if (type.equalsIgnoreCase("login"))
            login(req, resp, false);
        else if (type.equalsIgnoreCase("delete"))
            setImformation(req, resp);
//        else if (type.equalsIgnoreCase("update"))
//            update(req, resp);
//        else if (type.equalsIgnoreCase("search"))
//            search(req, resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp, boolean forward) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        try {
            CustomerService customerService = new CustomerService();
            customerService.login(req, resp, forward);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            resp.getWriter().write("操作错误，请重试");
        }
    }

    private void setImformation(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=utf-8");
        try {
            String name = req.getParameter("name");
            Long gender = Long.valueOf(req.getParameter("gender"));
            String telnum = req.getParameter("telnum");
            String email = req.getParameter("email");
            String uid = req.getParameter("uid");
            Customer customer = null;

        } catch (Exception exception) {

        }
    }
}
