package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.CourseBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CourseDAO;
import lk.ijse.dto.CourseDto;
import lk.ijse.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {
    CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getInstance(DAOFactory.DaoType.COURSE);
    @Override
    public String getCourseCurrentId() {
        return courseDAO.getCurrentId();
    }

    @Override
    public boolean saveCourse(CourseDto obj) {
        return courseDAO.save(new Course(obj.getCourseId(), obj.getCourse(), obj.getDuration(), obj.getDescription(), obj.getFee(), obj.getProfilePicture(),null));
    }

    @Override
    public boolean updateCourse(CourseDto obj) {
        return courseDAO.update(new Course(obj.getCourseId(), obj.getCourse(), obj.getDuration(), obj.getDescription(), obj.getFee(), null, null));
    }

    @Override
    public boolean deleteCourse(CourseDto obj) {
        return courseDAO.delete(new Course(obj.getCourseId(), obj.getCourse(), obj.getDuration(), obj.getDescription() , obj.getFee() ,null ,null));
    }

    @Override
    public CourseDto getCourseObj(String... x) {
        Course obj = courseDAO.getObj(x[0]);
        return new CourseDto(obj.getCourseId(), obj.getCourse(), obj.getDuration(), obj.getDescription(), obj.getFee(), obj.getProfilePicture());
    }

    @Override
    public List<CourseDto> getCourseObjList() {
        List<CourseDto> courses = new ArrayList<>();
        List<Course> objList = courseDAO.getObjList();
        for (Course course: objList){
            courses.add(new CourseDto(
                    course.getCourseId(),
                    course.getCourse(),
                    course.getDuration(),
                    course.getDescription(),
                    course.getFee(),
                    course.getProfilePicture()
            ));
        }
        return courses;
    }
}
