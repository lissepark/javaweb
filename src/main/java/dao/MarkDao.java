package dao;

import entity.Marks;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergii on 15.05.2015.
 */
public interface MarkDao {
    List<Marks> getMarks();

    public List<Marks> getDisciplinesByIdTermIdStudent(int idTerm, int idStudent)throws SQLException;

    int getMarksDisciplines(int idTermDiscipline, int idTerm, int idStudent) throws SQLException;

    Marks getById(int id) throws SQLException;

    boolean update(Marks mark)throws SQLException;

    boolean insert(Marks mark) throws SQLException;

    boolean delete(Marks mark) throws SQLException;
}
