package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Student;
import org.hibernate.Session;

public interface StudentDAO extends CrudDAO<Student> {
    String checkCurrentId();
    boolean transaction(Student student, Session session);
}
