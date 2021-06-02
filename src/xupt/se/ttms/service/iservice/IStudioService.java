package xupt.se.ttms.service.iservice;

import java.util.List;

import xupt.se.ttms.entity.Studio;

public interface IStudioService {
    public int add(Studio stu);

    public int modify(Studio stu);

    public int delete(int ID);

    public List<Studio> Fetch(String condt);

    public List<Studio> FetchAll();
}
