package dao.impl;

import dao.StudentDao;
import database.DataService;
import entity.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private DataService dataService = new DataService();
    @Override
    public List<Student> getStudents() {
        return dataService.getAllStudents();
    }

    @Override
    public Student getById(int id) throws SQLException {
        return dataService.selectStudentById(id);
    }

    @Override
    public boolean update(Student student) throws SQLException {
        return (dataService.changeStudent(student)>0)? true : false;
    }

    @Override
    public boolean insert(Student student) throws SQLException {
        return (dataService.insertStudent(student)>0)? true : false;
    }

    @Override
    public boolean delete(Student student) throws SQLException {
        return (dataService.deleteStudent(student)>0)? true : false;
    }
}
