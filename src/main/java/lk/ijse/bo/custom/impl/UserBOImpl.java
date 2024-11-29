package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;

import java.util.List;


public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getInstance(DAOFactory.DaoType.USER);
    @Override
    public String getCurrentUserId() {
        return userDAO.getCurrentId();
    }

    @Override
    public boolean saveUser(UserDto obj) {
        return userDAO.save(new User(obj.getUserId(), obj.getFirstName(), obj.getLastName(), obj.getContact(), obj.getEmail(), obj.getDob(), obj.getGender(), obj.getAddress(), obj.getUserType(), obj.getPassword(), null));
    }

    @Override
    public boolean updateUser(UserDto obj) {
        return userDAO.update(new User(obj.getUserId(), obj.getFirstName(), obj.getLastName(), obj.getContact(), obj.getEmail(), obj.getDob(), obj.getGender(), obj.getAddress(), obj.getUserType(), obj.getPassword(), null));
    }

    @Override
    public boolean deleteUser(UserDto obj) {
        return userDAO.delete(new User(obj.getUserId(), obj.getFirstName(), obj.getLastName(), obj.getContact(), obj.getEmail(), obj.getDob(), obj.getGender(), obj.getAddress(), obj.getUserType(), obj.getPassword() ,null));
    }

    @Override
    public UserDto getUserObj(String... x) {
        User obj = userDAO.getObj(x[0]);
        return new UserDto(obj.getUserId(), obj.getFirstName(), obj.getLastName(), obj.getContact(), obj.getEmail(), obj.getDob(), obj.getGender(),obj.getAddress(), obj.getUserType(), obj.getPassword());
    }

    @Override
    public List<UserDto> getUserObjList() {
        return List.of();
    }

    @Override
    public List<String> generateUserPassword() {
        return userDAO.generatePassword();
    }
}
