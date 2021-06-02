package xupt.se.ttms.dao.idao;

import java.util.List;

import xupt.se.ttms.entity.Studio;

public interface IStudioDAO {
    public int insert(Studio stu);

    public int update(Studio stu);

    public int delete(int ID);

    public List<Studio> select(String studioName);
}
