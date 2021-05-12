package LearnWeb;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/serv11")
public class Servlet11 extends HttpServlet{
    /**
     * Cookie:
     * 设置Cookie存活时间
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("data", "nigo");
        /**
         * MaxAge:
         * < 0: 关闭即失效
         * = 0: 删除
         * > 0: 存活时间
         */
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
    }
}
