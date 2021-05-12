package LearnWeb;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/serv13")
public class Servlet13 extends HttpServlet{
    /**
     * Cookie:
     * Cookie同名：自动覆盖
     * 避免出现Cookie同名
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "数据";
        String value = "李四";
        name = URLEncoder.encode(name);
        value = URLEncoder.encode(value);
        Cookie cookie = new Cookie(name, value);
        resp.addCookie(cookie);
    }
}
