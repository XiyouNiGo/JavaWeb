package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.dao.factory.SeatDAOFactory;
import xupt.se.ttms.dao.idao.ISeatDAO;
import xupt.se.ttms.entity.Seat;
import xupt.se.ttms.entity.Studio;
import xupt.se.ttms.service.iservice.ISeatService;

public class SeatService implements ISeatService {
    private ISeatDAO seatDAO = SeatDAOFactory.createSeatDAO();

    @Override
    public int add(Seat seat) {
        return seatDAO.insert(seat);
    }

    @Override
    public int add(Studio studio) {
        return seatDAO.insert(studio);
    }

    @Override
    public int modify(Seat seat) {
        return seatDAO.update(seat);
    }

    @Override
    public int delete(int ID) {
        return seatDAO.delete(ID);
    }

    @Override
    public List<Seat> Fetch(String condt) {
        return seatDAO.select(condt);
    }

    @Override
    public List<Seat> FetchAll() {
        return seatDAO.select("");
    }
}
