package LearnWeb;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/serv6")
public class Servlet6 extends HttpServlet{
    /**
     * 请求转发
     * 服务端内部跳转，URL不改变
     * 数据共享，只有一个http请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        if (!uname.isEmpty()) {
            System.out.println(uname);
        }
        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}
