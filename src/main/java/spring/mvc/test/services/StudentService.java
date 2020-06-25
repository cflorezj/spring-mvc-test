package spring.mvc.test.services;

import spring.mvc.test.dto.Student;

import java.util.List;

public interface StudentService {

    void save(Student user);

    List<Student> list();

    Student getStudent(Integer id);
}
