package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PaymentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.PaymentDAO;
import lk.ijse.dto.PaymentDto;
import lk.ijse.entity.Payment;
import org.hibernate.Session;

import java.util.List;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getInstance(DAOFactory.DaoType.PAYMENT);
    @Override
    public String getCurrentId() {
      return paymentDAO.getCurrentId();
    }

    @Override
    public boolean save(PaymentDto obj) {
        return false;
    }

    @Override
    public boolean update(PaymentDto obj) {
        return false;
    }

    @Override
    public boolean delete(PaymentDto obj) {
        return false;
    }

    @Override
    public PaymentDto getObj(String... x) {
        return null;
    }

    @Override
    public List<PaymentDto> getObjList() {
        return List.of();
    }

    @Override
    public boolean savePayment(PaymentDto paymentDto, Session session) {
        return paymentDAO.savePayment(new Payment(paymentDto.getPaymentId(), paymentDto.getMethod(), paymentDto.getUpFrontPayment(), paymentDto.getUpFrontdate(), paymentDto.getSecondPayment(), paymentDto.getSecondPaymentDate(), paymentDto.getThirdPayment(), paymentDto.getThirdPaymentDate(),paymentDto.getStudentId(), null, null),session);

    }
}
