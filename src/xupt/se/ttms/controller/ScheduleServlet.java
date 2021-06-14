package xupt.se.ttms.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xupt.se.ttms.entity.Schedule;
import xupt.se.ttms.service.ScheduleService;

@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
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
        Schedule schedule = null;
        int id = 0;
        try {
            schedule = new Schedule();
            schedule.setStudioId(Long.valueOf(request.getParameter("studio_id")));
            schedule.setPlayId(Long.valueOf(request.getParameter("play_id")));
            schedule.setSchedTime(Timestamp.valueOf(request.getParameter("sched_time")));
            schedule.setSchedTicketPrice(Double.valueOf(request.getParameter("sched_ticket_price")));
            schedule.setSchedStatus(Long.valueOf(request.getParameter("sched_status")));

            PrintWriter out = response.getWriter();

            if (new ScheduleService().add(schedule) == 1)
                out.write("数据添加成功");
            else
                out.write("数据添加失败，请重试");

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("操作错误，请重试");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            PrintWriter out = response.getWriter();
            out.write("" + new ScheduleService().delete(id));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("操作错误，请重试");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Schedule schedule = null;
        int id = 0;
        try {
            schedule = new Schedule();
            schedule.setSchedId(Long.valueOf(request.getParameter("id")));
            schedule.setStudioId(Long.valueOf(request.getParameter("studio_id")));
            schedule.setPlayId(Long.valueOf(request.getParameter("play_id")));
            schedule.setSchedTime(Timestamp.valueOf(request.getParameter("sched_time")));
            schedule.setSchedTicketPrice(Double.valueOf(request.getParameter("sched_ticket_price")));
            System.out.println(request.getParameter("sched_status"));
            schedule.setSchedStatus(Long.valueOf(request.getParameter("sched_status")));

            PrintWriter out = response.getWriter();

            if (new ScheduleService().modify(schedule) == 1)
                out.write("数据修改成功");
            else
                out.write("数据修改失败，请重试");

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("操作错误，请重试");
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String play_id = request.getParameter("play_id");
        List<Schedule> result = null;
        if (play_id != null && play_id.length() > 0)
            result = new ScheduleService().Fetch(play_id);
        else
            result = new ScheduleService().FetchAll();
        String jsonStr = "";
        try {
            JSONArray array = new JSONArray();
            JSONObject json;
            for (Schedule schedule : result) {
                json = new JSONObject();
                json.put("id", schedule.getSchedId());
                json.put("studio_id", schedule.getStudioId());
                json.put("play_id", schedule.getPlayId());
                json.put("sched_time", schedule.getSchedTime().toString());
                json.put("sched_ticket_price", schedule.getSchedTicketPrice());
//                json.put("studio_name", schedule.getSchedTicketPrice());
                json.put("sched_status", schedule.getSchedStatus());
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