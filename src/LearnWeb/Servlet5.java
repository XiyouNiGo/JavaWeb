package LearnWeb;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/serv5")
public class Servlet5 extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * Servlet6 -> Servlet5
         * 请求转发用的是一个请求
         */
        String uname = req.getParameter("uname");
        if (!uname.isEmpty()) {
            System.out.println("uname: " + uname);
        }
    }
}
