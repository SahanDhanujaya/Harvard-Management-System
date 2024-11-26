package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {
    private String studentId;
    private String fullName;
    private String address;
    private String mobile;
    private String email;
    private Date dob;
    private String userId;
}
