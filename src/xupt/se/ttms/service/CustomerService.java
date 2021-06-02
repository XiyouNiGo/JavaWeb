package xupt.se.ttms.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xupt.se.ttms.dao.factory.CustomerDAOFactory;
import xupt.se.ttms.service.iservice.ICustomerService;
import xupt.se.util.EncryptUtil;

public class CustomerService implements ICustomerService {
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
            EncryptUtil encryptUtil = new EncryptUtil();
            uname = req.getParameter("uname");
            passwd = encryptUtil.MD5(req.getParameter("passwd"));
        }
        try {
            if (passwd.equals(CustomerDAOFactory.createCustomerDAO().getPasswd(uname))) {
                resp.getWriter().write("登录成功");
                resp.addCookie(new Cookie("uname", uname));
                resp.addCookie(new Cookie("passwd", passwd));
            } else {
                resp.getWriter().write("登录失败");
                if (forward) {
                    req.getRequestDispatcher("login.html").forward(req, resp);
                }
            }
        } catch (IOException | ServletException ioException) {
            ioException.printStackTrace();
            resp.getWriter().write("操作，请重试");
        }
    }
}
