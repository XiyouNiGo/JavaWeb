package xupt.se.ttms.dao.factory;

import xupt.se.ttms.dao.ScheduleDAO;
import xupt.se.ttms.dao.idao.IScheduleDAO;

public class ScheduleDAOFactory {
    private static IScheduleDAO scheduleDao = null;

    public static synchronized IScheduleDAO creatScheduleDAO() {
        if (null == scheduleDao)
            scheduleDao = new ScheduleDAO();
        return scheduleDao;
    }
}
