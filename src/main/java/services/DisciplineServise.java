package services;

import java.sql.SQLException;
import java.util.List;

import entity.Discipline;

public interface DisciplineServise {

	boolean modifing(Discipline discipline) throws SQLException;

	boolean delete(Discipline discipline) throws SQLException;

	boolean add(Discipline discipline) throws SQLException;

	List<Discipline> getDisciplines();

	Discipline getById(int id) throws SQLException;

    List<Integer> getDisciplinesByIdTerm(int idTerm);

}
