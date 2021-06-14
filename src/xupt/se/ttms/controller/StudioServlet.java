package xupt.se.ttms.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xupt.se.ttms.entity.Studio;
import xupt.se.ttms.service.StudioService;

@WebServlet("/StudioServlet")
public class StudioServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
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
        Studio stu = null;
        int id = 0;
        try {
            String name = request.getParameter("studioname");
            int rowCount = Integer.valueOf(request.getParameter("rowcount"));
            int colCount = Integer.valueOf(request.getParameter("colcount"));
            String intro = request.getParameter("intro");
            stu = new Studio(id, name, rowCount, colCount, intro);
            PrintWriter out = response.getWriter();

            if (new StudioService().add(stu) == 1)
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
            out.write("" + new StudioService().delete(id));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("false");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Studio stu = null;
        int id = 0;
        try {
            id = Integer.valueOf(request.getParameter("studioid"));
            String name = request.getParameter("studioname");
            int rowCount = Integer.valueOf(request.getParameter("rowcount"));
            int colCount = Integer.valueOf(request.getParameter("colcount"));
            String intro = request.getParameter("intro");
            stu = new Studio(id, name, rowCount, colCount, intro);
            PrintWriter out = response.getWriter();

            if (new StudioService().modify(stu) == 1)
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
        List<Studio> result = null;
        if (name != null && name.length() > 0)
            result = new StudioService().Fetch(name);
        else
            result = new StudioService().FetchAll();
        String jsonStr = "";
        try {
            JSONArray array = new JSONArray();
            JSONObject json;
            for (Studio s : result) {
                json = new JSONObject();
                json.put("id", s.getID());
                json.put("name", s.getName());
                json.put("rowCount", s.getRowCount());
                json.put("colCount", s.getColCount());
                json.put("introduction", s.getIntroduction());
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
