package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.dao.idao.ITicketDAO;
import xupt.se.ttms.entity.Customer;
import xupt.se.ttms.entity.Ticket;
import xupt.se.ttms.service.CustomerService;
import xupt.se.util.DBUtil;

public class TicketDAO implements ITicketDAO {
    @Override
    public int insert(Ticket ticket, Customer customer) {
        int result = 0;
        try {
            CustomerService customerService = new CustomerService();
            if (customerService.pay((int) ticket.getTicketPrice(), customer) != 1) {
                return -1;
            }
            String sql = String.format("insert into ticket(seat_id, sched_id, ticket_price, "
                            + "ticket_status)"
                            + " values('%d', '%d', '%lf', '%d')", ticket.getSeatId(),
                    ticket.getSchedId(), ticket.getTicketPrice(),
                    ticket.getTicketStatus());
            DBUtil db = new DBUtil();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDs(sql);
            if (rst != null && rst.first()) {
                ticket.setTicketId(rst.getInt(1));
            }
            db.close(rst);
            db.close();
            result = 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @Override
    public int delete(int ID) {
        int result = 0;
        try {
            String sql = "delete from ticket where ticket_id = " + ID;
            DBUtil db = new DBUtil();
            db.openConnection();
            result = db.execCommand(sql);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Ticket> select(String ID) {
        DBUtil db = null;
        List<Ticket> ticketList = new LinkedList<Ticket>();
        try {
            ID.trim();
            String sql = "select * from ticket where ticket_id like '%" + ID + "%'";
            db = new DBUtil();
            if (!db.openConnection()) {
                System.out.print("fail to connect database");
                return null;
            }
            ResultSet rst = db.execQuery(sql);
            if (rst != null) {
                while (rst.next()) {
                    Ticket ticket = new Ticket();
                    ticket.setTicketId(rst.getLong("ticket_id"));
                    ticket.setSeatId(rst.getLong("seat_id"));
                    ticket.setSchedId(rst.getLong("sched_id"));
                    ticket.setTicketPrice(rst.getDouble("ticket_price"));
                    ticket.setTicketStatus(rst.getLong("ticket_status"));
//                    ticket.setTicketLocktime(rst.getTimestamp("ticket_locktime"));
                    ticketList.add(ticket);
                }
            }
            db.close(rst);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return ticketList;
        }
    }
}
