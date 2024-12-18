package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDto {
    private String courseId;
    private String course;
    private String duration;
    private String description;
    private double fee;
    private String profilePicture;
}
