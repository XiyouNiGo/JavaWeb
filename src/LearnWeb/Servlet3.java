package LearnWeb;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/serv3")
public class Servlet3 extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("URL: " + req.getRequestURL().toString() + "\n");
        resp.getWriter().write("URI: " + req.getRequestURI().toString() + "\n");
        resp.getWriter().write("Method: " + req.getMethod().toString() + "\n");
        resp.getWriter().write("QueryString: " + req.getQueryString().toString() + "\n");
        resp.getWriter().write("Parameter test: " + req.getParameter("test").toString() + "\n");
        resp.getWriter().write("Protocol: " + req.getProtocol().toString() + "\n");
        resp.getWriter().write("ContextPath: " + req.getContextPath().toString() + "\n");
    }
}
