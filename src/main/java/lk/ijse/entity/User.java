package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private Date dob;
    private String gender;
    private String address;
//    private Blob profile;
    @OneToMany(mappedBy = "user")
    private List<Student> studentList;


}
