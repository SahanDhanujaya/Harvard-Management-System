package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public String getCurrentId() {
        return "";
    }

    @Override
    public boolean save(Student obj) {
        return false;
    }

    @Override
    public boolean update(Student obj) {
        return false;
    }

    @Override
    public boolean delete(Student obj) {
        return false;
    }

    @Override
    public Student getObj(String... x) {
        return null;
    }

    @Override
    public List<Student> getObjList() {
        return List.of();
    }

    @Override
    public String checkCurrentId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        try{
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT MAX(s.studentId) FROM Student s");
            transaction.commit();
            return (String) query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean transaction(Student student, Session session) {
        try{
            session.save(student);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
