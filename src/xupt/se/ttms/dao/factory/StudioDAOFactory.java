package xupt.se.ttms.dao.factory;

import xupt.se.ttms.dao.StudioDAO;
import xupt.se.ttms.dao.idao.IStudioDAO;

public class StudioDAOFactory {
    private static IStudioDAO stuDao = null;

    public static synchronized IStudioDAO creatStudioDAO() {
        if (null == stuDao)
            stuDao = new StudioDAO();
        return stuDao;
    }
}
