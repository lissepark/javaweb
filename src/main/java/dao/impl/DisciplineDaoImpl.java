package dao.impl;

import dao.DisciplineDao;
import database.DataService;
import entity.Discipline;

import java.sql.SQLException;
import java.util.List;

public class DisciplineDaoImpl implements DisciplineDao {
    private DataService dataService = new DataService();

    @Override
    public List<Discipline> getDisciplines() {
        //MySql ili PSQL
        return dataService.getAllDisciplines();
    }

    @Override
    public List<Integer> getDisciplinesByIdTerm(int idTerm){
        return dataService.getIdTermDiscipline(idTerm);
    };

    @Override
    public Discipline getById(int id) throws SQLException {
        return dataService.selectDisciplineById(id);
    }

    @Override
    public boolean update(Discipline discipline) throws SQLException {

        return (dataService.changeDiscipline(discipline)>0)? true : false;
    }

    @Override
    public boolean delete(Discipline discipline) throws SQLException {
        return (dataService.deleteDiscipline(discipline)>0)? true : false;
    }

    @Override
    public boolean insert(Discipline discipline) throws SQLException {
        return (dataService.insertDiscipline(discipline)>0)? true : false;
    }
}
