package xupt.se.ttms.service.iservice;

import java.util.List;

import xupt.se.ttms.entity.Seat;

public interface ISeatService {
    public int add(Seat seat);

    public int modify(Seat seat);

    public List<Seat> Fetch(String condt);

    public List<Seat> FetchAll();
}
