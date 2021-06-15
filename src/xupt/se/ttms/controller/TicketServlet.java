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

import xupt.se.ttms.entity.Customer;
import xupt.se.ttms.entity.Ticket;
import xupt.se.ttms.service.TicketService;

@WebServlet("/TicketServlet")
public class TicketServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        int id = 0;
        if (type.equalsIgnoreCase("add"))
            add(req, resp);
        else if (type.equalsIgnoreCase("delete"))
            delete(req, resp);
//        else if (type.equalsIgnoreCase("update"))
//            update(req, resp);
        else if (type.equalsIgnoreCase("search"))
            search(req, resp);
        else if (type.equalsIgnoreCase("add_batch"))
            add_batch(req, resp);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Ticket ticket = null;
        try {
            ticket = new Ticket();
            ticket.setSeatId(Long.valueOf(request.getParameter("seat_id")));
            ticket.setSchedId(Long.valueOf(request.getParameter("sched_id")));
            ticket.setTicketPrice(Long.valueOf(request.getParameter("ticket_price")));
            ticket.setTicketStatus(Long.valueOf(request.getParameter("ticket_status")));

            PrintWriter out = response.getWriter();

            Customer customer = new Customer();
            customer.setCusName(request.getParameter("uname"));
            customer.setCusPaypwd(request.getParameter("paypwd"));
            if (new TicketService().add(ticket, customer) == 1)
                out.write("true");
            else
                out.write("false");

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("false");
        }
    }

    private void add_batch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Ticket ticket = null;
        try {
//            JSONObject jsonObj = JSON.parseObject(jsonStr);
            ticket = new Ticket();
            ticket.setSeatId(Long.valueOf(request.getParameter("seat_id")));
            ticket.setSchedId(Long.valueOf(request.getParameter("sched_id")));
            ticket.setTicketPrice(Long.valueOf(request.getParameter("ticket_price")));
            ticket.setTicketStatus(Long.valueOf(request.getParameter("ticket_status")));

            PrintWriter out = response.getWriter();

            Customer customer = new Customer();
            customer.setCusName(request.getParameter("uname"));
            customer.setCusPaypwd(request.getParameter("paypwd"));
            if (new TicketService().add(ticket, customer) == 1)
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
            if (new TicketService().delete(id) == 1)
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
        String id = request.getParameter("id");
        List<Ticket> result = null;
        if (id != null && id.length() > 0)
            result = new TicketService().Fetch(id);
        else
            result = new TicketService().FetchAll();
        String jsonStr = "";
        try {
            JSONArray array = new JSONArray();
            JSONObject json;
            for (Ticket ticket : result) {
                json = new JSONObject();
                json.put("id", ticket.getTicketId());
                json.put("seat_id", ticket.getSeatId());
                json.put("sched_id", ticket.getSchedId());
                json.put("ticket_price", ticket.getTicketPrice());
                json.put("ticket_status", ticket.getTicketStatus());
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
