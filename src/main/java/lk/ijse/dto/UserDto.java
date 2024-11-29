package lk.ijse.dto;

import com.mysql.cj.jdbc.Blob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private String userId;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private Date dob;
    private String gender;
    private String address;
    private String userType;
    private String password;
//    private Blob picture;
}
