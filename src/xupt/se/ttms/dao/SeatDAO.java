package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.dao.idao.ISeatDAO;
import xupt.se.ttms.entity.Seat;
import xupt.se.ttms.entity.Studio;
import xupt.se.util.DBUtil;

public class SeatDAO implements ISeatDAO {
    @Override
    public int insert(Seat seat) {
        int result = 0;
        try {
            String sql = String.format("insert into seat(studio_id, seat_row, seat_column, "
                            + "seat_status)"
                            + " values('%d', '%d', '%d', '%d')", seat.getStudioId(),
                    seat.getSeatRow(), seat.getSeatColumn(), 1);
            DBUtil db = new DBUtil();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDs(sql);
            if (rst != null && rst.first()) {
                seat.setSeatId(rst.getInt(1));
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
    public int insert(Studio studio) {
        int result = 0;
        try {
            long row_count = studio.getRowCount();
            long col_count = studio.getColCount();
            long studio_id = studio.getID();
            List<String> sqlList = new LinkedList<>();
            for (long i = 1; i <= row_count; i++) {
                for (long j = 1; j <= col_count; j++) {
                    String sql = String.format("insert into seat(studio_id, seat_row, seat_column, "
                                    + "seat_status)"
                                    + " values('%d', '%d', '%d', '%d')", studio_id,
                            i, j, 1);
                    sqlList.add(sql);
                }
            }
            DBUtil db = new DBUtil();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDsT(sqlList);
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
    public int update(Seat seat) {
        int result = 0;
        try {
            String sql = "update seat set seat_status = " + seat.getSeatStatus()
                    + " where seat_id = " + seat.getSeatId();
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
    public int delete(int ID) {
        int result = 0;
        try {
            String sql = "delete from seat where studio_id = " + ID;
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
    public List<Seat> select(String studio_id) {
        DBUtil db = null;
        List<Seat> seatList = new LinkedList<Seat>();
        try {
            studio_id.trim();
            String sql = "select * from seat where studio_id like '%" + studio_id + "%'";
            db = new DBUtil();
            if (!db.openConnection()) {
                System.out.print("fail to connect database");
                return null;
            }
            ResultSet rst = db.execQuery(sql);
            if (rst != null) {
                while (rst.next()) {
                    Seat seat = new Seat();
                    seat.setSeatId(rst.getLong("seat_id"));
                    seat.setStudioId(rst.getLong("studio_id"));
                    seat.setSeatRow(rst.getLong("seat_row"));
                    seat.setSeatColumn(rst.getLong("seat_column"));
                    seat.setSeatStatus(rst.getLong("seat_status"));
                    seatList.add(seat);
                }
            }
            db.close(rst);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return seatList;
        }
    }
}
