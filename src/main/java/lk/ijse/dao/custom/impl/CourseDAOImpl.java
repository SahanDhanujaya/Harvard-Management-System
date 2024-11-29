package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.CourseDAO;
import lk.ijse.entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj.getCourseId(), obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Course obj) {
       Session session = FactoryConfiguration.getInstance().getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Course getObj(String... x) {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Course c WHERE c.course = :course");
            transaction.commit();
            query.setParameter("course", x[0]);
            return (Course) query.uniqueResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Course> getObjList() {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Course");
            transaction.commit();
            List<Course> resultList = query.getResultList();
            return resultList;
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
    return null;
    }
}
