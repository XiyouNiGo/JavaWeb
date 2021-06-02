package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.dao.factory.PlayDAOFactory;
import xupt.se.ttms.dao.idao.IPlayDAO;
import xupt.se.ttms.entity.Play;

public class PlayService {
    private IPlayDAO playDAO = PlayDAOFactory.creatPlayDAO();

    public int add(Play play) {
        return playDAO.insert(play);
    }

    public int modify(Play play) {
        return playDAO.update(play);
    }

    public int delete(int ID) {
        return playDAO.delete(ID);
    }

    public List<Play> Fetch(String condt) {
        return playDAO.select(condt);
    }

    public List<Play> FetchAll() {
        return playDAO.select("");
    }
}
