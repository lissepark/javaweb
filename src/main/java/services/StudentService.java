package services;

import java.sql.SQLException;
import java.util.List;

import entity.Student;

public interface StudentService {

	boolean studentModifing(Student student) throws SQLException;

	boolean studentDelete(Student student) throws SQLException;

	boolean studentAdd(Student student) throws SQLException;

	List<Student> getStudents();

	Student getStudentById(int id) throws SQLException;

}
