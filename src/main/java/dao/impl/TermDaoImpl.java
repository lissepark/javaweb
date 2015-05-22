package dao.impl;

import dao.TermDao;
import database.DataService;
import entity.Term;

import java.sql.SQLException;
import java.util.List;

public class TermDaoImpl implements TermDao {
    private DataService dataService = new DataService();

    @Override
    public List<Term> getTerms() {
        return dataService.getAllTerms();
    }

    @Override
    public Term getById(int id) {
        return dataService.getTermById(id);
    }

    @Override
    public Term getTermByName(String name){
        return dataService.getTermByName(name);
    }

    @Override
    public boolean update(Term term) throws SQLException {
        return (dataService.changeTerm(term)>0) ? true : false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return (dataService.deleteTerm(id)>0)?true:false;
    }

    @Override
    public boolean deleteTermDiscipline(int id) throws SQLException {
        return (dataService.deleteTermDiscipline(id)>0)?true:false;
    }

    @Override
    public boolean insertTerm(Term term) throws SQLException {
        return (dataService.insertTerm(term)>0) ? true : false;}

    @Override
    public boolean insertTermDiscipline(int id_term, int id_discipline) throws SQLException {
        return (dataService.insertTermDiscipline(id_term, id_discipline) > 0)? true : false;
    }
}
