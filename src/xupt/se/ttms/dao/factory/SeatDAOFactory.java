package xupt.se.ttms.dao.factory;

import xupt.se.ttms.dao.SeatDAO;
import xupt.se.ttms.dao.idao.ISeatDAO;

public class SeatDAOFactory {
    private static ISeatDAO seatDAO = null;

    public static synchronized ISeatDAO createSeatDAO() {
        if (null == seatDAO)
            seatDAO = new SeatDAO();
        return seatDAO;
    }
}
