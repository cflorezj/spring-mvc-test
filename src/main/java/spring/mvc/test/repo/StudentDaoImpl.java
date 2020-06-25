package spring.mvc.test.repo;

import org.hibernate.SessionFactory;
import org.hsqldb.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.mvc.test.dto.Student;

import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    @Override
    public List<Student> list() {
        try {
            @SuppressWarnings("unchecked")
            TypedQuery<Student> query = sessionFactory.getCurrentSession().createQuery("from Student");
            return query.getResultList();
        } catch (RuntimeException e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Student getStudent(Integer id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }
}
