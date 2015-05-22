package services.impl;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;
import services.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public boolean studentModifing(Student student) throws SQLException {
        return studentDao.update(student);
    }

    @Override
    public boolean studentDelete(Student student) throws SQLException {
        return studentDao.delete(student);
    }

    @Override
    public boolean studentAdd(Student student) throws SQLException {
        return studentDao.insert(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }

    @Override
    public Student getStudentById(int id) throws SQLException {
        return studentDao.getById(id);
    }
}
