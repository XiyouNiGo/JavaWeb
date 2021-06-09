package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.dao.factory.TicketDAOFactory;
import xupt.se.ttms.dao.idao.ITicketDAO;
import xupt.se.ttms.entity.Customer;
import xupt.se.ttms.entity.Ticket;
import xupt.se.ttms.service.iservice.ITicketService;

public class TicketService implements ITicketService {
    private ITicketDAO ticketDAO = TicketDAOFactory.creatTicketDAO();

    public int add(Ticket ticket, Customer customer) {
        return ticketDAO.insert(ticket, customer);
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
