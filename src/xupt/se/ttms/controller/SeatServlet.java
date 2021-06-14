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

import xupt.se.ttms.entity.Seat;
import xupt.se.ttms.service.SeatService;

@WebServlet("/SeatServlet")
public class SeatServlet extends HttpServlet {
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
        Seat seat = null;
        try {
            seat = new Seat();
            seat.setStudioId(Long.valueOf(request.getParameter("studio_id")));
            seat.setSeatRow(Long.valueOf(request.getParameter("seat_row")));
            seat.setSeatColumn(Long.valueOf(request.getParameter("seat_column")));

            PrintWriter out = response.getWriter();

            if (new SeatService().add(seat) == 1)
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
            if (new SeatService().delete(id) == 1) {
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
        Seat seat = null;
        int id = 0;
        try {
            seat = new Seat();
            seat.setSeatId(Long.valueOf(request.getParameter("seat_id")));
            seat.setSeatStatus(Long.valueOf(request.getParameter("seat_status")));
            PrintWriter out = response.getWriter();

            if (new SeatService().modify(seat) == 1)
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
        String studio_id = request.getParameter("studio_id");
        List<Seat> result = null;
        if (studio_id != null && studio_id.length() > 0)
            result = new SeatService().Fetch(studio_id);
        else
            result = new SeatService().FetchAll();
        String jsonStr = "";
        try {
            JSONArray array = new JSONArray();
            JSONObject json;
            for (Seat seat : result) {
                json = new JSONObject();
                json.put("id", seat.getSeatId());
                json.put("studio_id", seat.getStudioId());
                json.put("seat_row", seat.getSeatRow());
                json.put("seat_column", seat.getSeatColumn());
                json.put("seat_status", seat.getSeatStatus());
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
