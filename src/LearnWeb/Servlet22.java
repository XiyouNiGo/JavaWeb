package LearnWeb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/serv22")
@MultipartConfig    //文件上传表单必须加上
public class Servlet22 extends HttpServlet{
    /**
     * 后台实现文件下载
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String real_path = req.getServletContext().getRealPath("/");
        String file_name = req.getParameter("file_name");
        File file = new File(real_path + file_name);
        if (file.exists() && file.isFile()) {
            // 设置ContentType为浏览器无法识别的MIME类型（默认自动下载）
            resp.setContentType("application/x-msdownload");
            // 设置Header
            resp.setHeader("Content-Disposition", "attachment;filename=" + file_name);
            // 获取输入、输出流
            InputStream is = new FileInputStream("file");
            ServletOutputStream os = resp.getOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            // 写入消息
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            is.close();
            os.close();
        } else {
            System.out.println("file not exist!");
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("<h3>file not exist!</h3><a href='download.html'>retry</a>");
            printWriter.close();
        }
    }
}
