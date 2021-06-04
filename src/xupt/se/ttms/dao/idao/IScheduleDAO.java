package xupt.se.ttms.dao.idao;

import java.util.List;

import xupt.se.ttms.entity.Schedule;

public interface IScheduleDAO {
    public int insert(Schedule schedule);

    public int update(Schedule schedule);

    public int delete(int ID);

    public List<Schedule> select(String ID);
}
