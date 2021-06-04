package xupt.se.ttms.dao.factory;

import xupt.se.ttms.dao.TicketDAO;
import xupt.se.ttms.dao.idao.ITicketDAO;

public class TicketDAOFactory {
    private static ITicketDAO ticketDao = null;

    public static synchronized ITicketDAO creatTicketDAO() {
        if (null == ticketDao)
            ticketDao = new TicketDAO();
        return ticketDao;
    }
}
