package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        return false;
    }

    @Override
    public boolean delete(User obj) {
        return false;
    }

    @Override
    public User getObj(String... x) {
        return null;
    }

    @Override
    public List<User> getObjList() {
        return List.of();
    }
}
