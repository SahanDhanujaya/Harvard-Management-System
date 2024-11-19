package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private Date dob;
    private String gender;
    private String address;

}
