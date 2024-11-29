package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Payment;
import org.hibernate.Session;

public interface PaymentDAO extends CrudDAO<Payment> {

    boolean savePayment(Payment payment, Session session);
}
