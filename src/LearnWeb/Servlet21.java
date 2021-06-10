package LearnWeb;

import org.apache.commons.fileupload.FileItemFactory;

import java.io.File;
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
        System.out.println("*");
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("type"));
        System.out.println("*");
        Part part = req.getPart("upload_file");
        String file_name = part.getSubmittedFileName();
        String real_path = req.getServletContext().getRealPath("/image/");
        File dir = new File(real_path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        System.out.println("file_name: " + file_name);
        System.out.println("real_path: " + real_path);
        String partHeader = part.getHeader("Content-Disposition");
        String image_name = partHeader.substring(partHeader.lastIndexOf("=")+2, partHeader.length()-1);
        System.out.println(image_name);
        part.write(real_path + file_name);
        resp.getWriter().write("true");
    }
}
