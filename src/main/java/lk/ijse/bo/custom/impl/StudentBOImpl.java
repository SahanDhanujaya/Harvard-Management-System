package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.StudentBO;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.PaymentDAO;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.dto.StudentDto;
import lk.ijse.entity.Payment;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getInstance(DAOFactory.DaoType.STUDENT);
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getInstance(DAOFactory.DaoType.PAYMENT);
    @Override
    public String checkCurrentStudentId() {
        return studentDAO.checkCurrentId();
    }

    @Override
    public String getStudentCurrentId() {
        return "";
    }

    @Override
    public boolean saveStudent(StudentDto obj) {
        return false;
    }

    @Override
    public boolean updateStudent(StudentDto obj) {
        return false;
    }

    @Override
    public boolean deleteStudent(StudentDto obj) {
        return false;
    }

    @Override
    public StudentDto getStudentObj(String... x) {
        return null;
    }

    @Override
    public List<StudentDto> getStudentObjList() {
        return List.of();
    }

    @Override
    public boolean transaction(StudentDto studentDto, Session session) {
        return studentDAO.transaction(new Student(studentDto.getStudentId(), studentDto.getFirstName(), studentDto.getLastName(), studentDto.getAddress(), studentDto.getMobile(), studentDto.getEmail(), studentDto.getDob(), studentDto.getUserId(), null, null, null),session);

    }


}
