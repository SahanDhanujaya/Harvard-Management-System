package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.StudentDto;
import org.hibernate.Session;

import java.util.List;

public interface StudentBO extends SuperBO {
    String checkCurrentStudentId();
    public String getStudentCurrentId();
    public boolean saveStudent(StudentDto obj);
    public boolean updateStudent(StudentDto obj);
    public boolean deleteStudent(StudentDto obj);
    public StudentDto getStudentObj(String ...x);
    public List<StudentDto> getStudentObjList();

    boolean transaction(StudentDto studentDto, Session session);


}
