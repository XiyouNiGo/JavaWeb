package LearnWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/serv23")
public class Servlet23 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean login = false;
        boolean has_cookie = false;
        String uname = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("uname")) {
                    uname = cookie.getValue();
                    has_cookie = true;
                }
            }
        }
        if (uname == null) {
            uname = req.getParameter("uname");
        }
        if (uname.equals("admin")) {
            login = true;
        }
        if (login) {
            if (has_cookie == false) {
                Cookie cookie = new Cookie("uname", "admin");
                resp.addCookie(cookie);
            }
            System.out.println("succ");
            req.getRequestDispatcher("index.html").forward(req, resp);
        } else {
            System.out.println("failed");
            resp.getWriter().write("failed!");
        }
    }
}
