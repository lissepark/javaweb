package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Discipline;

public interface DisciplineDao {

	List<Discipline> getDisciplines();

    List<Integer> getDisciplinesByIdTerm(int idTerm);

	Discipline getById(int id) throws SQLException;

	boolean update(Discipline discipline) throws SQLException;

    boolean insert(Discipline discipline) throws SQLException;

	boolean delete(Discipline discipline)throws SQLException;

}
