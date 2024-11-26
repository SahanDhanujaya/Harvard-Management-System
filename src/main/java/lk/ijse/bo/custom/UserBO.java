package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDto;

import java.util.List;

public interface UserBO extends SuperBO {
    public String getCurrentUserId();
    public boolean saveUser(UserDto obj);
    public boolean updateUser(UserDto obj);
    public boolean deleteUser(UserDto obj);
    public UserDto getUserObj(String ...x);
    public List<UserDto> getUserObjList();
}
