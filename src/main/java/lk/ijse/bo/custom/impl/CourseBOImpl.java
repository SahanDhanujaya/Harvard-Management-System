package lk.ijse.bo.custom.impl;

import lk.ijse.bo.SuperBO;
import lk.ijse.bo.custom.CourseBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CourseDAO;
import lk.ijse.dto.CourseDto;
import lk.ijse.entity.Course;

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
        return false;
    }

    @Override
    public boolean deleteCourse(CourseDto obj) {
        return false;
    }

    @Override
    public CourseDto getCourseObj(String... x) {
        return null;
    }

    @Override
    public List<CourseDto> getCourseObjList() {
        return List.of();
    }
}
