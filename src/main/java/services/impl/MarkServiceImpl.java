package services.impl;

import dao.MarkDao;
import dao.impl.MarkDaoImpl;
import entity.Marks;
import services.MarkService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergii
 */
public class MarkServiceImpl implements MarkService {
    MarkDao markDao = new MarkDaoImpl();

    @Override
    public int getMarksDisciplines(int idTermDiscipline, int idTerm, int idStudent) throws SQLException {
        return markDao.getMarksDisciplines(idTermDiscipline, idTerm, idStudent);
    }

    @Override
    public List<Marks> getDisciplinesByIdTermIdStudent(int idTerm, int idStudent)throws SQLException {
        return markDao.getDisciplinesByIdTermIdStudent(idTerm,idStudent);
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
        return markDao.insert(mark);
    }

    @Override
    public boolean delete(Marks mark) throws SQLException {
        return false;
    }
}
