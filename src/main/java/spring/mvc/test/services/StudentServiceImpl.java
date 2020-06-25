package spring.mvc.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc.test.dto.Student;
import spring.mvc.test.repo.StudentDao;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDAO;

    @Transactional
    @Override
    public void save(Student user) {
        studentDAO.save(user);
    }

    @Transactional(readOnly = true)
    public List<Student> list() {
        return studentDAO.list();
    }

    @Override
    @Transactional(readOnly = true)
    public Student getStudent(Integer id) {
        return studentDAO.getStudent(id);
    }
}
