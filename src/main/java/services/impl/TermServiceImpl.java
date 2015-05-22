package services.impl;

import dao.TermDao;
import dao.impl.TermDaoImpl;
import entity.Term;
import services.TermService;

import java.sql.SQLException;
import java.util.List;

public class TermServiceImpl implements TermService{
    private TermDao termDao = new TermDaoImpl();

    @Override
    public boolean modifing(Term term) throws SQLException {
        return termDao.update(term);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return termDao.delete(id);
    }

    @Override
    public boolean deleteTermDiscipline(int id) throws SQLException {
        return termDao.deleteTermDiscipline(id);
    }

    @Override
    public boolean add(int idS) {
        return false;
    }

    @Override
    public List<Term> getTerms() {
        return termDao.getTerms();
    }

    @Override
    public Term getById(int id) {
        return termDao.getById(id);
    }

    @Override
    public Term getTermByName(String name){
        return termDao.getTermByName(name);
    }

    @Override
    public boolean insertTerm(Term term) throws SQLException {
        return termDao.insertTerm(term);
    }

    public boolean insertTermDiscipline(int id_term, int id_discipline) throws SQLException {
        return termDao.insertTermDiscipline(id_term,id_discipline);
    }
}
