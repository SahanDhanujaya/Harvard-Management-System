package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.PaymentDAO;
import lk.ijse.entity.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public String getCurrentId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        String maxId = null;
        try {
            Transaction transaction = session.beginTransaction();
            String hql = "SELECT MAX(p.paymentId) FROM Payment p";
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
    public boolean save(Payment obj) {
        return false;
    }

    @Override
    public boolean update(Payment obj) {
        return false;
    }

    @Override
    public boolean delete(Payment obj) {
        return false;
    }

    @Override
    public Payment getObj(String... x) {
        return null;
    }

    @Override
    public List<Payment> getObjList() {
        return List.of();
    }

    @Override
    public boolean savePayment(Payment payment, Session session) {
        session.save(payment);
        return true;
    }
}
