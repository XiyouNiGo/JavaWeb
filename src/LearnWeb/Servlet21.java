package LearnWeb;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/serv21")
@MultipartConfig    //文件上传表单必须加上
public class Servlet21 extends HttpServlet{
    /**
     * 上传文件
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Part part = req.getPart("upload_file");
        String file_name = part.getSubmittedFileName();
        String real_path = req.getServletContext().getRealPath("/");
        System.out.println("file_name: " + file_name);
        System.out.println("real_path: " + real_path);
        part.write(real_path + file_name);
    }
}
