package LearnWeb;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/serv7")
public class Servlet7 extends HttpServlet{
    /**
     * 在一个请求内传递数据
     * 只在一次服务器跳转中有效
     * 配合jsp，在页面和后台中传递代码
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
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
