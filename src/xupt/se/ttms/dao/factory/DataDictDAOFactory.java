package xupt.se.ttms.dao.factory;

import xupt.se.ttms.dao.DataDictDAO;
import xupt.se.ttms.dao.idao.IDataDictDAO;

public class DataDictDAOFactory {
    private static IDataDictDAO dataDictDAO = null;

    public static synchronized IDataDictDAO createDataDictDAO() {
        if (null == dataDictDAO)
            dataDictDAO = new DataDictDAO();
        return dataDictDAO;
    }
}
