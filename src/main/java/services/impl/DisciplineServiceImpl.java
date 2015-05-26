package services.impl;

import dao.DisciplineDao;
import dao.impl.DisciplineDaoImpl;
import entity.Discipline;
import services.DisciplineServise;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergii
 */
public class DisciplineServiceImpl implements DisciplineServise{
    private DisciplineDao disciplineDao = new DisciplineDaoImpl();

    @Override
    public boolean modifing(Discipline discipline) throws SQLException {
        return disciplineDao.update(discipline);
    }

    @Override
    public boolean delete(Discipline discipline) throws SQLException {
        return disciplineDao.delete(discipline);
    }

    @Override
    public boolean add(Discipline discipline) throws SQLException {
        return disciplineDao.insert(discipline);
    }

    @Override
    public List<Discipline> getDisciplines() {
        // logica proverki na null, varianty predostavleniya informacii
        return disciplineDao.getDisciplines();
    }

    @Override
    public Discipline getById(int id) throws SQLException {
        return disciplineDao.getById(id);
    }

    @Override
    public List<Integer> getDisciplinesByIdTerm(int idTerm){
        return disciplineDao.getDisciplinesByIdTerm(idTerm);
    }
}
