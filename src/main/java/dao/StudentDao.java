package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Discipline;
import entity.Student;

public interface StudentDao {
    List<Student> getStudents();

    Student getById(int id) throws SQLException;

    boolean update(Student student)throws SQLException;

    boolean insert(Student student) throws SQLException;

    boolean delete(Student student) throws SQLException;

}


