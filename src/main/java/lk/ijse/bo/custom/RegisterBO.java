package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.RegisterDto;
import org.hibernate.Session;

public interface RegisterBO extends SuperBO {
    boolean saveRegister(RegisterDto registerDto, Session session);
}
