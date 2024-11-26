package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;

import java.lang.module.Configuration;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}
    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }
    public enum BoType{
        USER,STUDENT,PAYMENT,REGISTRATION,COURSE
    }
    public SuperBO getInstance(BoType boType){
        switch(boType){
            case USER:
                return new UserBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case REGISTRATION:
                return new RegistrationBOImpl();
            case COURSE:
                return new CourseBOImpl();
            default:
                throw new RuntimeException("Invalid BO Type");
        }
    }
}
