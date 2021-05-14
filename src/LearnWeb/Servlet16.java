package LearnWeb;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/serv16")
public class Servlet16 extends HttpServlet{
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
        session.setAttribute("sa", "valid");
        req.setAttribute("ra", "invalid");
        req.getRequestDispatcher("serv17").forward(req, resp);
    }
}
