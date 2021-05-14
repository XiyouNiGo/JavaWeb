package LearnWeb;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/serv20")
public class Servlet20 extends HttpServlet{
    /**
     * ServletContext：
     * 作用域为整个容器
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        // 不建议在ServletContext中存放数据
        context.setAttribute("uname", "nigo");
        System.out.println("ServerInfo: " + context.getServerInfo());
        System.out.println("RealPath: " + context.getRealPath("/"));
    }
}
