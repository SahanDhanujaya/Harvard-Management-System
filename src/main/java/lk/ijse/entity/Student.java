package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    private String studentId;
    private String fullName;
    private String address;
    private String mobile;
    private String email;
    private Date dob;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY )
    private List<Registration> registrationList;
    @OneToMany(mappedBy = "student")
    private List<Payment> paymentList;

}
