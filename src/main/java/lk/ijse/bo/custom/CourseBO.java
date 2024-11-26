package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CourseDto;

import java.util.List;

public interface CourseBO extends SuperBO {
    public String getCourseCurrentId();
    public boolean saveCourse(CourseDto obj);
    public boolean updateCourse(CourseDto obj);
    public boolean deleteCourse(CourseDto obj);
    public CourseDto getCourseObj(String ...x);
    public List<CourseDto> getCourseObjList();
}
