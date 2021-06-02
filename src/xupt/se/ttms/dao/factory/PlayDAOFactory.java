package xupt.se.ttms.dao.factory;

import xupt.se.ttms.dao.PlayDAO;
import xupt.se.ttms.dao.idao.IPlayDAO;

public class PlayDAOFactory {
    private static IPlayDAO playDao = null;

    public static synchronized IPlayDAO creatPlayDAO() {
        if (null == playDao)
            playDao = new PlayDAO();
        return playDao;
    }
}
