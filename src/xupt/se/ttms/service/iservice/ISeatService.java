package xupt.se.ttms.service.iservice;

import java.util.List;

import xupt.se.ttms.entity.Seat;
import xupt.se.ttms.entity.Studio;

public interface ISeatService {
    public int add(Seat seat);

    int add(Studio studio);

    public int modify(Seat seat);

    int delete(int ID);

    public List<Seat> Fetch(String condt);

    public List<Seat> FetchAll();
}
