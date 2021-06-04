package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.dao.factory.TicketDAOFactory;
import xupt.se.ttms.dao.idao.ITicketDAO;
import xupt.se.ttms.entity.Ticket;

public class TicketService {
    private ITicketDAO ticketDAO = TicketDAOFactory.creatTicketDAO();

    public int add(Ticket ticket) {
        return ticketDAO.insert(ticket);
    }

    public int delete(int ID) {
        return ticketDAO.delete(ID);
    }

    public List<Ticket> Fetch(String condt) {
        return ticketDAO.select(condt);
    }

    public List<Ticket> FetchAll() {
        return ticketDAO.select("");
    }
}
