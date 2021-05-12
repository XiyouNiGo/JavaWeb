package LearnWeb;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/serv9")
public class Servlet9 extends HttpServlet{
    /**
     * Cookie:
     * 减轻服务器负担
     * 创建Cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("data", "nigo");
        resp.addCookie(cookie);
    }
}
