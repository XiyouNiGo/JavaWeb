package LearnWeb;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/serv12")
public class Servlet12 extends HttpServlet{
    /**
     * Cookie:
     * 中文Cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "数据";
        String value = "张三";
        name = URLEncoder.encode(name);
        value = URLEncoder.encode(value);
        Cookie cookie = new Cookie(name, value);
        resp.addCookie(cookie);
    }
}
