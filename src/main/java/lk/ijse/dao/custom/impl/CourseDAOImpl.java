package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.CourseDAO;
import lk.ijse.entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public String getCurrentId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        String maxId = null;
        try {
            Transaction transaction = session.beginTransaction();
            String hql = "SELECT MAX(c.courseId) FROM Course c";
            maxId = (String) session.createQuery(hql).uniqueResult();
            transaction.commit();
            return maxId;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public boolean save(Course obj) {
       Session session = FactoryConfiguration.getInstance().getSession();
       try {
           Transaction transaction = session.beginTransaction();
           session.save(obj);
           transaction.commit();
           return true;
       }catch (Exception e) {
           throw new RuntimeException(e);
       }finally {
           session.close();
       }
    }

    @Override
    public boolean update(Course obj) {
        return false;
    }

    @Override
    public boolean delete(Course obj) {
        return false;
    }

    @Override
    public Course getObj(String... x) {
        return null;
    }

    @Override
    public List<Course> getObjList() {
        return List.of();
    }
}
