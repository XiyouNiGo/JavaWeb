package xupt.se.ttms.service.iservice;

import java.util.List;

import xupt.se.ttms.entity.Customer;
import xupt.se.ttms.entity.Ticket;

public interface ITicketService {
    public int add(Ticket ticket, Customer customer);

    public int delete(int ID);

    public List<Ticket> Fetch(String condt);

    public List<Ticket> FetchAll();
}
