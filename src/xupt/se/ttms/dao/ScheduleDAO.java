package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.dao.idao.IScheduleDAO;
import xupt.se.ttms.entity.Schedule;
import xupt.se.util.DBUtil;

public class ScheduleDAO implements IScheduleDAO {
    @Override
    public int insert(Schedule schedule) {
        int result = 0;
        try {
            String sql = String.format("insert into schedule(studio_id, play_id, sched_time, "
                            + "sched_ticket_price, sched_status)"
                            + " values('%d', '%d', '%s', '%f', '%d')", schedule.getStudioId(),
                    schedule.getPlayId(), schedule.getSchedTime().toString(),
                    schedule.getSchedTicketPrice(), schedule.getSchedStatus());
            DBUtil db = new DBUtil();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDs(sql);
            if (rst != null && rst.first()) {
                schedule.setSchedId(rst.getInt(1));
            }
            db.close(rst);
            db.close();
            result = 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @Override
    public int update(Schedule schedule) {
        int result = 0;
        try {
            String sql = String.format("update schedule set studio_id = '%d', play_id = '%d', "
                            + "sched_time = '%s', sched_ticket_price = '%f', sched_status = '%d'"
                            + " where sched_id = '%d'",
                    schedule.getStudioId(), schedule.getPlayId(), schedule.getSchedTime().toString(),
                    schedule.getSchedTicketPrice(), schedule.getSchedStatus(), schedule.getSchedId());
            DBUtil db = new DBUtil();
            db.openConnection();
            result = db.execCommand(sql);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @Override
    public int delete(int ID) {
        int result = 0;
        try {
            String sql = "delete from schedule where sched_id = " + ID;
            DBUtil db = new DBUtil();
            db.openConnection();
            result = db.execCommand(sql);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Schedule> select(String ID) {
        DBUtil db = null;
        List<Schedule> scheduleList = new LinkedList<Schedule>();
        try {
            ID.trim();
            String sql = "select * from schedule where play_id like '%" + ID + "%'";
            db = new DBUtil();
            if (!db.openConnection()) {
                System.out.print("fail to connect database");
                return null;
            }
            ResultSet rst = db.execQuery(sql);
            if (rst != null) {
                while (rst.next()) {
                    Schedule schedule = new Schedule();
                    schedule.setSchedId(rst.getLong("sched_id"));
                    schedule.setStudioId(rst.getLong("studio_id"));
                    schedule.setPlayId(rst.getLong("play_id"));
                    schedule.setSchedTime(rst.getTimestamp("sched_time"));
                    schedule.setSchedTicketPrice(rst.getDouble("sched_ticket_price"));
                    schedule.setSchedStatus(rst.getLong("sched_status"));
                    scheduleList.add(schedule);
                }
            }
            db.close(rst);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return scheduleList;
        }
    }
}
