package LearnWeb;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/serv17")
public class Servlet17 extends HttpServlet{
    /**
     * Session：
     * 跨多个连接或来自用户的页面请求
     * Attribute一次会话中有效
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // 一次会话有效
        String sa = (String) session.getAttribute("sa");
        String ra = (String) req.getAttribute("sa");
        if (!sa.isEmpty()) {
            System.out.println("Session Attribute: " + sa);
        }
        if (!ra.isEmpty()) {
            System.out.println("Request Attribute: " + ra);
        }
    }
}
