package xupt.se.ttms.service.iservice;

import java.util.List;

import xupt.se.ttms.entity.Play;

public interface IPlayService {
    public int add(Play stu);

    public int modify(Play stu);

    public int delete(int ID);

    public List<Play> Fetch(String condt);

    public List<Play> FetchAll();
}
