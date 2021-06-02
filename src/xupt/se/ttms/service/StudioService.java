package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.dao.factory.StudioDAOFactory;
import xupt.se.ttms.dao.idao.IStudioDAO;
import xupt.se.ttms.entity.Studio;
import xupt.se.ttms.service.iservice.IStudioService;

public class StudioService implements IStudioService {
    private IStudioDAO stuDAO = StudioDAOFactory.creatStudioDAO();

    public int add(Studio stu) {
        return stuDAO.insert(stu);
    }

    public int modify(Studio stu) {
        return stuDAO.update(stu);
    }

    public int delete(int ID) {
        return stuDAO.delete(ID);
    }

    public List<Studio> Fetch(String condt) {
        return stuDAO.select(condt);
    }

    public List<Studio> FetchAll() {
        return stuDAO.select("");
    }
}
