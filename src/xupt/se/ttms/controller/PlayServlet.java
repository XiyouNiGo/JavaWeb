package xupt.se.ttms.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import xupt.se.ttms.entity.Play;
import xupt.se.ttms.service.PlayService;

@WebServlet("/PlayServlet")
@MultipartConfig
public class PlayServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        int id = 0;
        if (type.equalsIgnoreCase("add"))
            add(req, resp);
        else if (type.equalsIgnoreCase("delete"))
            delete(req, resp);
        else if (type.equalsIgnoreCase("update"))
            update(req, resp);
        else if (type.equalsIgnoreCase("search"))
            search(req, resp);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("play add");
        Play play = null;
        try {
            play = new Play();
            play.setPlayName(request.getParameter("name"));
            play.setPlayIntroduction(request.getParameter("introduction"));
            Part part = request.getPart("image");
            String partHeader = part.getHeader("Content-Disposition");
            String image_name = partHeader.substring(partHeader.lastIndexOf("=") + 2, partHeader.length() - 1);
            if (image_name != "") {
                String image_dir_path = request.getServletContext().getRealPath("/images/property/");
                File image_dir = new File(image_dir_path);
                if (!image_dir.exists()) {
                    image_dir.mkdir();
                }
                String file_name = UUID.randomUUID().toString();
                String suffix = image_name.substring(image_name.lastIndexOf("."));
                part.write(image_dir_path + file_name + suffix);
                image_name = file_name + suffix;
            } else {
                throw new Exception("No file");
            }
            play.setPlayImage(image_name);
            play.setPlayLength(Long.valueOf(request.getParameter("length")));
            play.setPlayTicketPrice(Long.valueOf(request.getParameter("ticket_price")));
            play.setLanguage(request.getParameter("language"));
            play.setPlayType(request.getParameter("play_type"));
            play.setPlayStatus(0);

            PrintWriter out = response.getWriter();

            if (new PlayService().add(play) == 1)
                out.write("true");
            else
                out.write("false");

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("false");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            PrintWriter out = response.getWriter();
            if (new PlayService().delete(id) == 1) {
                out.write("true");
            } else {
                out.write("false");
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("false");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Play play = null;
        int id = 0;
        try {
            id = Integer.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String introduction = request.getParameter("introduction");
            String image = request.getParameter("image");
            String video = request.getParameter("video");
            long length = Long.valueOf(request.getParameter("length"));
            double ticket_price = Double.valueOf(request.getParameter("ticket_price"));
            long status = Long.valueOf(request.getParameter("status"));
            play = new Play(name, introduction, image, video, length, ticket_price, status);
            PrintWriter out = response.getWriter();

            if (new PlayService().modify(play) == 1)
                out.write("true");
            else
                out.write("false");

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("false");
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        List<Play> result = null;
        if (name != null && name.length() > 0)
            result = new PlayService().Fetch(name);
        else
            result = new PlayService().FetchAll();
        String jsonStr = "";
        try {
            JSONArray array = new JSONArray();
            JSONObject json;
            for (Play play : result) {
                json = new JSONObject();
                json.put("id", play.getPlayId());
                json.put("name", play.getPlayName());
                json.put("introduction", play.getPlayIntroduction());
                json.put("image", play.getPlayImage());
                json.put("length", play.getPlayLength());
                json.put("ticket_price", play.getPlayTicketPrice());
                json.put("language", play.getLanguage());
                json.put("play_type", play.getPlayType());
                array.put(json);
            }
            jsonStr = array.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            out.println(jsonStr);
            out.flush();
            out.close();
        }
    }
}
