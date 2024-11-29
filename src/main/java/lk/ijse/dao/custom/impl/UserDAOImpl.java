package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public String getCurrentId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        String maxId = null;
        try {
            Transaction transaction = session.beginTransaction();
            String hql = "SELECT MAX(u.userId) FROM User u";
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
    public boolean save(User obj) {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(User obj) {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(User obj) {
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
    public User getObj(String... x) {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM User u WHERE u.email =  :email");
            query.setParameter("email", x[0]);
            session.getTransaction().commit();
            User user = (User) query.uniqueResult();
            return user;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<User> getObjList() {
        return List.of();
    }

    @Override
    public List<String> generatePassword() {
        Session session = FactoryConfiguration.getInstance().getSession();
        try{
            Transaction transaction = session.beginTransaction();
            String hql = "SELECT u.password FROM User u";
            List<String> passwordList = session.createQuery(hql).getResultList();
            transaction.commit();
            return passwordList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
