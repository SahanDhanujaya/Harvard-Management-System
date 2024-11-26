package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Course;
import lk.ijse.entity.Registration;
import lk.ijse.entity.Student;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        user.setUserId("U001");
        session.save(user);
        transaction.commit();
        session.close();
    }
}
