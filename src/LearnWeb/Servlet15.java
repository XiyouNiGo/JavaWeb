package LearnWeb;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/serv15")
public class Servlet15 extends HttpServlet{
    /**
     * Session：
     * 跨多个连接或来自用户的页面请求
     * 底层依赖Cookie，重新打开浏览器无法取得之前设置的Session
     * 客户端和服务端都能感知
     * 由JSESSIONID标识（特殊Cookie）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 存在则获取，不存在则创建
        HttpSession session = req.getSession();
        // JSESSIONID
        System.out.println("ID: " + session.getId());
        System.out.println("CreationTime: " + session.getCreationTime());
        System.out.println("LastAccessedTime: " + session.getLastAccessedTime());
        System.out.println("IsNew: " + session.isNew());
    }
}
