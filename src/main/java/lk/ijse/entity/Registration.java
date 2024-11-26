package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Generated;

import java.sql.Date;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double upfrontPayment;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Payment payment;
    private Date date;
}