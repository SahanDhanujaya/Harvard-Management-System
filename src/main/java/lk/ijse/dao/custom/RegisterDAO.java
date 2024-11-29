package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.RegisterDto;
import lk.ijse.entity.Registration;
import org.hibernate.Session;

public interface RegisterDAO extends CrudDAO<Registration> {
    boolean saveRegister(Registration registerDto, Session session);
}
