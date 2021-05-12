package LearnWeb;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/serv8")
public class Servlet8 extends HttpServlet{
    /**
     * 重定向：
     * 服务器指导的客户端行为
     * 两次请求
     * 原理：
     * HTML Location
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        if (!uname.isEmpty() && uname.equals("right_name")) {
            req.getRequestDispatcher("index.html").forward(req, resp);
        } else {
            req.setAttribute("err_msg", "incorrect user name");
            resp.sendRedirect("login.jsp");
        }
    }
}
