package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.RegisterDAO;
import lk.ijse.entity.Registration;

import java.util.List;

public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public String getCurrentId() {
        return "";
    }

    @Override
    public boolean save(Registration obj) {
        return false;
    }

    @Override
    public boolean update(Registration obj) {
        return false;
    }

    @Override
    public boolean delete(Registration obj) {
        return false;
    }

    @Override
    public Registration getObj(String... x) {
        return null;
    }

    @Override
    public List<Registration> getObjList() {
        return List.of();
    }
}