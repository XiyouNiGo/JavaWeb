package xupt.se.ttms.service.iservice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICustomerService {
    public void login(HttpServletRequest req, HttpServletResponse resp, boolean verify) throws IOException;
}
