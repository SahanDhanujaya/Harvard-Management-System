package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.entity.Student;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public String getCurrentId() {
        return "";
    }

    @Override
    public boolean save(Student obj) {
        return false;
    }

    @Override
    public boolean update(Student obj) {
        return false;
    }

    @Override
    public boolean delete(Student obj) {
        return false;
    }

    @Override
    public Student getObj(String... x) {
        return null;
    }

    @Override
    public List<Student> getObjList() {
        return List.of();
    }
}
