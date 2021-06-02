package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.dao.idao.IPlayDAO;
import xupt.se.ttms.entity.Play;
import xupt.se.util.DBUtil;

public class PlayDAO implements IPlayDAO {
    @Override
    public int insert(Play play) {
        int result = 0;
        try {
            String sql = String.format("insert into play(play_name, play_introduction, play_image, "
                            + "play_video, play_length, play_ticket_price, play_status)"
                            + " values('%s', '%s', '%s', '%s', '%ld', '%lf', '%ld')", play.getPlayName(),
                    play.getPlayIntroduction(), play.getPlayImage(),
                    play.getPlayVideo(), play.getPlayLength(),
                    play.getPlayTicketPrice(), play.getPlayStatus());
            DBUtil db = new DBUtil();
            db.openConnection();
            ResultSet rst = db.getInsertObjectIDs(sql);
            if (rst != null && rst.first()) {
                play.setPlayId(rst.getInt(1));
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
    public int update(Play play) {
        int result = 0;
        try {
            String sql = String.format("update play set play_name = '%s', play_introduction = '%s', "
                    + "play_image = '%s', play_video = '%s', play_length = '%ld', "
                    + "play_ticket_price = '%lf', play_status = '%ld' where play_id = '%ld'",
                    play.getPlayName(), play.getPlayIntroduction(), play.getPlayImage(),
                    play.getPlayVideo(), play.getPlayLength(), play.getPlayTicketPrice(),
                    play.getPlayStatus(), play.getPlayStatus());
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
            String sql = "delete from  play where play_id = " + ID;
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
    public List<Play> select(String playName) {
        DBUtil db = null;
        List<Play> playList = new LinkedList<Play>();
        try {
            playName.trim();
            String sql = "select * from play where play_name like '%" + playName + "%'";
            db = new DBUtil();
            if (!db.openConnection()) {
                System.out.print("fail to connect database");
                return null;
            }
            ResultSet rst = db.execQuery(sql);
            if (rst != null) {
                while (rst.next()) {
                    Play play = new Play();
                    play.setPlayId(rst.getLong("play_id"));
                    play.setPlayName(rst.getString("play_name"));
                    play.setPlayIntroduction(rst.getString("play_introduction"));
                    play.setPlayImage(rst.getString("play_image"));
                    play.setPlayVideo(rst.getString("play_video"));
                    play.setPlayLength(rst.getLong("play_length"));
                    play.setPlayTicketPrice(rst.getLong("play_ticket_price"));
                    playList.add(play);
                }
            }
            db.close(rst);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return playList;
        }
    }
}