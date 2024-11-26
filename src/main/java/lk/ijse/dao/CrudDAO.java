package lk.ijse.dao;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    public String getCurrentId();
    public boolean save(T obj);
    public boolean update(T obj);
    public boolean delete(T obj);
    public T getObj(String ...x);
    public List<T> getObjList();
}
