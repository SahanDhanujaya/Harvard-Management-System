package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RegisterBO;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.RegisterDAO;
import lk.ijse.dto.RegisterDto;
import lk.ijse.entity.Registration;
import org.hibernate.Session;

public class RegistrationBOImpl implements RegisterBO {
    RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDaoFactory().getInstance(DAOFactory.DaoType.REGISTRATION);
    @Override
    public boolean saveRegister(RegisterDto registerDto, Session session) {
        return registerDAO.saveRegister(new Registration(1,registerDto.getStudentId(),registerDto.getCourseId(), registerDto.getDate(),registerDto.getPaymentId(),null,null,null),session);
    }
}
