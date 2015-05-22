package services;

import entity.Marks;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergii on 15.05.2015.
 */
public interface MarkService {
    int getMarksDisciplines(int idTermDiscipline, int idTerm, int idStudent) throws SQLException;

    public List<Marks> getDisciplinesByIdTermIdStudent(int idTerm, int idStudent)throws SQLException;

    List<Marks> getMarks();

    Marks getById(int id) throws SQLException;

    boolean update(Marks mark)throws SQLException;

    boolean insert(Marks mark) throws SQLException;

    boolean delete(Marks mark) throws SQLException;
}
