package LearnWeb;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/serv14")
public class Servlet14 extends HttpServlet{
    /**
     * Cookie:
     * 只有满足Cookie路径才会加载
     * 连接时服务器会发送所有Cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("data", "nigo");
        /**
         * 默认路径：当前项目
         * /：任意项目
         */
        cookie.setPath("/serv14");
        resp.addCookie(cookie);
    }
}
