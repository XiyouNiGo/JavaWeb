package xupt.se.ttms.dao.idao;

import java.util.List;

import xupt.se.ttms.entity.Seat;
import xupt.se.ttms.entity.Studio;

public interface ISeatDAO {
    public int insert(Seat seat);

    int insert(Studio studio);

    public int update(Seat seat);

    public int delete(int ID);

    public List<Seat> select(String ID);
}
