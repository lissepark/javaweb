package dao;

import entity.Term;

import java.sql.SQLException;
import java.util.List;

public interface TermDao {
    List<Term> getTerms();

    Term getById(int id);

    public Term getTermByName(String name);

    boolean update(Term term) throws SQLException;

    boolean delete(int id) throws SQLException;

    boolean deleteTermDiscipline(int id) throws SQLException;

    boolean insertTerm(Term term) throws SQLException;

    boolean insertTermDiscipline(int id_term, int id_discipline) throws SQLException;
}
