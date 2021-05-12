package LearnWeb;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/serv4")
public class Servlet4 extends HttpServlet{
    /**
     * 乱码处理
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        String test = req.getParameter("test");
        if (!test.isEmpty()) {
            System.out.println(test);
        }
        String test_right = new String(test.getBytes("ISO-8859-1"), "UTF-8");
        if (!test_right.isEmpty()) {
            System.out.println(test_right);
        }
    }
}
