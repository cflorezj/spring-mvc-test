package spring.mvc.test.repo;

import spring.mvc.test.dto.Student;

import java.util.List;

public interface StudentDao {

    void save(Student user);

    List<Student> list();

    Student getStudent(Integer id);

}
