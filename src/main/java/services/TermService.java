package services;

import java.sql.SQLException;
import java.util.List;

import entity.Term;

public interface TermService {
	boolean modifing(Term term) throws SQLException;

	boolean delete(int id) throws SQLException;

    boolean deleteTermDiscipline(int id) throws SQLException;

	boolean add(int idS);

    boolean insertTerm(Term term) throws SQLException;

    boolean insertTermDiscipline(int id_term, int id_discipline) throws SQLException;

	List<Term> getTerms();

	Term getById(int id);

    Term getTermByName(String name);
}
