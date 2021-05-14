package LearnWeb;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/serv18")
public class Servlet18 extends HttpServlet{
    /**
     * Session销毁：
     * 默认：Tomcat/conf/web.xml中可修改
     * 手动：setMaxInactiveInterval、invalidate、关闭浏览器或服务器
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(30);
        session.invalidate();
    }
}
