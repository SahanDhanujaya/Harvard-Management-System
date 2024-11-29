package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.PaymentDto;
import org.hibernate.Session;

import java.util.List;

public interface PaymentBO extends SuperBO {
    public String getCurrentId();
    public boolean save(PaymentDto obj);
    public boolean update(PaymentDto obj);
    public boolean delete(PaymentDto obj);
    public PaymentDto getObj(String ...x);
    public List<PaymentDto> getObjList();

    boolean savePayment(PaymentDto paymentDto, Session session);
}
