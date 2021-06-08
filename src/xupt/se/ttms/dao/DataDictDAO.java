package xupt.se.ttms.dao;

import java.sql.ResultSet;

import xupt.se.ttms.dao.idao.IDataDictDAO;
import xupt.se.util.DBUtil;

public class DataDictDAO implements IDataDictDAO {
    @Override
    public String getDictId(String dict_value) {
        String dict_id = "";
        try {
            dict_value.trim();
            String sql = "select dict_id from data_dict where dict_value like '%" + dict_value + "%'";
            DBUtil db = new DBUtil();
            if (!db.openConnection()) {
                System.out.print("fail to connect database");
                return null;
            }
            ResultSet rst = db.execQuery(sql);
            if (rst != null && rst.next()) {
                dict_id = rst.getString("dict_id");
            }
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return dict_id;
        }
    }

    @Override
    public String getDictValue(String dict_id) {
        String dict_value = "";
        try {
            dict_id.trim();
            String sql = "select dict_value from data_dict where dict_id like '%" + dict_value + "%'";
            DBUtil db = new DBUtil();
            if (!db.openConnection()) {
                System.out.print("fail to connect database");
                return null;
            }
            ResultSet rst = db.execQuery(sql);
            if (rst != null && rst.next()) {
                dict_value = rst.getString("dict_value");
            }
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return dict_value;
        }
    }
}
