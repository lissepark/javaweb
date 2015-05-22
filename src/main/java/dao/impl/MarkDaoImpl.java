package dao.impl;

import dao.MarkDao;
import database.DataService;
import entity.Marks;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergii on 15.05.2015.
 */
public class MarkDaoImpl implements MarkDao {
    private DataService dataService = new DataService();

    @Override
    public int getMarksDisciplines(int idTermDiscipline, int idTerm, int idStudent) throws SQLException {
        return dataService.getMarksDisciplines(idTermDiscipline, idTerm, idStudent);
    }

    @Override
    public List<Marks> getDisciplinesByIdTermIdStudent(int idTerm, int idStudent)throws SQLException {
        return dataService.getDisciplinesByIdTermIdStudent(idTerm,idStudent);
    }

    @Override
    public List<Marks> getMarks() {
        return null;
    }

    @Override
    public Marks getById(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Marks mark) throws SQLException {
        return false;
    }

    @Override
    public boolean insert(Marks mark) throws SQLException {
        return (dataService.insertMark(mark)>0) ? true : false;
    }

    @Override
    public boolean delete(Marks mark) throws SQLException {
        return false;
    }
}
