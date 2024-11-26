package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.PaymentDAO;
import lk.ijse.entity.Payment;

import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public String getCurrentId() {
        return "";
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
}
