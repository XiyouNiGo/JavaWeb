package LearnWeb;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/serv2")
public class Servlet2 extends HttpServlet {
    /**
     * 初始化方法，只在第一次创建实例时调用
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init");
    }

    /**
     * 服务方法，访问当前Servlet时都会调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
    }

    /**
     * 销毁方法
     */
    @Override
    public void destroy() {
        System.out.println("destory");
        super.destroy();
    }
}
