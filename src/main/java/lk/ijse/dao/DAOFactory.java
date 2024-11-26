package lk.ijse.dao;

import lk.ijse.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public enum DaoType{
        STUDENT,
        USER,
        PAYMENT,
        REGISTRATION,
        COURSE
    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory == null)? daoFactory = new DAOFactory() : daoFactory;
    }
    public SuperDAO getInstance(DaoType daoType){
        switch(daoType){
            case STUDENT:
                return new StudentDAOImpl();
            case REGISTRATION:
                return new RegisterDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case COURSE:
                return new CourseDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                throw new RuntimeException("Invalid DAO Type");
        }
    }
}
