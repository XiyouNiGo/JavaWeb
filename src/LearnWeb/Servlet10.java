package LearnWeb;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/serv10")
public class Servlet10 extends HttpServlet{
    /**
     * Cookie:
     * 获取Cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Cookie数组
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println("name: " + cookie.getName());
                System.out.println("value: " + cookie.getValue());
            }
        }
    }
}
