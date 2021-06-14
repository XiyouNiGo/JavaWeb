package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.dao.factory.ScheduleDAOFactory;
import xupt.se.ttms.dao.idao.IScheduleDAO;
import xupt.se.ttms.entity.Schedule;
import xupt.se.ttms.service.iservice.IScheduleService;

public class ScheduleService implements IScheduleService {
    private IScheduleDAO scheduleDAO = ScheduleDAOFactory.creatScheduleDAO();

    @Override
    public int add(Schedule schedule) {
        return scheduleDAO.insert(schedule);
    }

    @Override
    public int modify(Schedule schedule) {
        return scheduleDAO.update(schedule);
    }

    @Override
    public int delete(int ID) {
        return scheduleDAO.delete(ID);
    }

    @Override
    public List<Schedule> Fetch(String condt) {
        return scheduleDAO.select(condt);
    }

    @Override
    public List<Schedule> FetchAll() {
        return scheduleDAO.select("");
    }
}
