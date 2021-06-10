package LearnWeb;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/serv25")
public class Servlet25 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sf = new ServletFileUpload(factory);
        try {
            if (ServletFileUpload.isMultipartContent(req)) {
                throw new Exception("no multipartcontent");
            }
            List<FileItem> formData = sf.parseRequest(req);
            for (FileItem fi : formData) {
                if (fi.isFormField()) {
                    System.out.println("field_name:" + fi.getFieldName() + ":" + fi.getString("UTF-8"));
                    switch (fi.getFieldName()) {
                        case "name":
                            System.out.println("receive name");
                            break;
                        default:
                            System.out.println("unknow data");
                    }
                } else {
                    String image_name = fi.getName();
                    System.out.println("image_name:" + image_name);
                    if (image_name != "") {
                        String image_dir_path = req.getServletContext().getRealPath("/images/");
                        File image_dir = new File(image_dir_path);
                        if (!image_dir.exists()) {
                            image_dir.mkdir();
                        }
                        String file_name = UUID.randomUUID().toString();
                        String suffix = image_name.substring(fi.getName().lastIndexOf("."));
                        System.out.println("image_dir_path:" + image_dir_path);
                        System.out.println("file_name:" + file_name);
                        System.out.println("suffix:" + suffix);
                        fi.write(new File(image_dir_path, file_name + suffix));
                    } else {
                        throw new Exception("no file receive");
                    }
                }
            }
            resp.getWriter().write("true");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("false");
        }
    }
}
