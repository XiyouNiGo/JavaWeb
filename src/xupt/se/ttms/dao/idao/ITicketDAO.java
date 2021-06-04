package xupt.se.ttms.dao.idao;

import java.util.List;

import xupt.se.ttms.entity.Ticket;

public interface ITicketDAO {
    public int insert(Ticket ticket);

    public int delete(int ID);

    public List<Ticket> select(String ID);
}
