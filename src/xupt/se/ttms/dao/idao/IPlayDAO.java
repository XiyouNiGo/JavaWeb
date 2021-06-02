package xupt.se.ttms.dao.idao;

import java.util.List;

import xupt.se.ttms.entity.Play;

public interface IPlayDAO {
    public int insert(Play play);

    public int update(Play play);

    public int delete(int ID);

    public List<Play> select(String playName);
}
