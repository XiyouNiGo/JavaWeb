package xupt.se.ttms.service.iservice;

import java.util.List;

import xupt.se.ttms.entity.Schedule;

public interface IScheduleService {
    public int add(Schedule schedule);

    public int modify(Schedule schedule);

    public int delete(int ID);

    public List<Schedule> Fetch(String condt);

    public List<Schedule> FetchAll();
}
