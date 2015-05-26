package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.*;
import org.apache.log4j.Logger;

import constants.Constants;

/**
 Class for multi-threading; 5 pools
*/

public class DataService{
	private static final Logger LOGGER = Logger
			.getLogger(DataService.class);
	private static List<DBConnection> conPool = new ArrayList<DBConnection>();
	private static Object monitor = new Object();

	public boolean init() {
		try{
			LOGGER.info("init database");
			for (int i = 0; i < Constants.CONNECTING_POOL_SIZE; i++){
				newConnection();
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public DBConnection getDBConnection() {
		synchronized (monitor) {
			if (conPool.isEmpty()){
				newConnection();
			}
			DBConnection conn = conPool.remove(0);
			return conn;
		}
	}
	
	public void putDBConnection(DBConnection conn) {
		synchronized (monitor){
			conPool.add(conn);
		}
	}

	private void newConnection() {
		DBConnection conn = new DBConnection(Constants.CONNECTING_URL, Constants.CONNECTING_USER, Constants.CONNECTING_PASSWORD);
		synchronized (monitor) {
			conPool.add(conn);
		}
	}
	
	public List<Role> getAllRoles(){
		DBConnection conn = getDBConnection();
		List <Role> result = conn.getAllRoles();
		this.putDBConnection(conn);
		return result;
		
	}
	
	public List<Account> getAllLogins() {
		DBConnection conn = getDBConnection();
		List<Account> result = conn.getAllLogins();
		this.putDBConnection(conn);		
		return result;
	}
	
	public Account getAccountByLogin(String login){
		DBConnection conn = getDBConnection();
		Account result = conn.getAccountByLogin(login);
		this.putDBConnection(conn);
		return result;
	}
	
	public List<Role> getRolesById(int id){
		DBConnection conn = getDBConnection();
		List<Role> result = conn.getRolesById(id);
		this.putDBConnection(conn);
		return result;
		
	}
	
	public List<Integer> getIdAccountRoles(int idAccount){
		DBConnection conn = getDBConnection();
		List<Integer> idAccountRoles = conn.getIdAccountRoles(idAccount);
		this.putDBConnection(conn);
		return idAccountRoles;
	}

    public List<Discipline> getAllDisciplines(){
        DBConnection conn = getDBConnection();
        List <Discipline> result = conn.getAllDisciplines();
        this.putDBConnection(conn);
        return result;
    }

    public int insertDiscipline(Discipline discipline) throws SQLException {
        DBConnection conn = getDBConnection();
        int result = conn.insertDiscipline(discipline);
        this.putDBConnection(conn);
        return result;
    }

    public int changeDiscipline(Discipline discipline) throws SQLException {
        DBConnection conn = getDBConnection();
        int result = conn.changeDiscipline(discipline);
        this.putDBConnection(conn);
        return result;
    }

    public Discipline selectDisciplineById(int id) throws SQLException {
        DBConnection conn = getDBConnection();
        Discipline result = conn.selectDisciplineById(id);
        this.putDBConnection(conn);
        return result;
    }

    public int deleteDiscipline(Discipline discipline) throws SQLException {
        DBConnection conn = getDBConnection();
        int result = conn.deleteDiscipline(discipline);
        this.putDBConnection(conn);
        return result;
    }

    public List<Student> getAllStudents(){
        DBConnection conn = getDBConnection();
        List <Student> result = conn.getAllStudents();
        this.putDBConnection(conn);
        return result;
    }

    public int insertStudent(Student student) throws SQLException {
        DBConnection conn = getDBConnection();
        int result = conn.insertStudent(student);
        this.putDBConnection(conn);
        return result;
    }

    public int changeStudent(Student student) throws SQLException {
        DBConnection conn = getDBConnection();
        int result = conn.changeStudent(student);
        this.putDBConnection(conn);
        return result;
    }

    public Student selectStudentById(int id) throws SQLException {
        DBConnection conn = getDBConnection();
        Student result = conn.selectStudentById(id);
        this.putDBConnection(conn);
        return result;
    }

    public int deleteStudent(Student student) throws SQLException {
        DBConnection conn = getDBConnection();
        int result = conn.deleteStudent(student);
        this.putDBConnection(conn);
        return result;
    }

    public List<Term> getAllTerms(){
        DBConnection conn = getDBConnection();
        List <Term> result = conn.getAllTerms();
        this.putDBConnection(conn);
        return result;
    }

    public Term getTermById(int id){
        DBConnection conn = getDBConnection();
        Term result = conn.getTermById(id);
        this.putDBConnection(conn);
        return result;
    }

    public List<Integer> getIdTermDiscipline(int IdTerm){
        DBConnection conn = getDBConnection();
        List <Integer> result = conn.getIdTermDiscipline(IdTerm);
        this.putDBConnection(conn);
        return result;
    }

    public int insertTerm(Term term) throws SQLException {
        DBConnection conn = getDBConnection();
        int result = conn.insertTerm(term);
        this.putDBConnection(conn);
        return result;
    }

    public Term getTermByName(String name){
        DBConnection conn = getDBConnection();
        Term term = conn.getTermByName(name);
        this.putDBConnection(conn);
        return term;
    }

    public int insertTermDiscipline(int id_term, int id_discipline) throws SQLException {
        DBConnection conn = getDBConnection();
        int result = conn.insertTermDiscipline(id_term, id_discipline);
        this.putDBConnection(conn);
        return result;
    }

    public int deleteTerm(int id) throws SQLException {
        DBConnection conn = getDBConnection();
        int result = conn.deleteTerm(id);
        this.putDBConnection(conn);
        return result;
    }

    public int changeTerm(Term term) throws SQLException {
        DBConnection conn = getDBConnection();
        int result = conn.changeTerm(term);
        this.putDBConnection(conn);
        return result;
    }

    public int deleteTermDiscipline(int id){
        DBConnection conn = getDBConnection();
        int result = conn.deleteTermDiscipline(id);
        this.putDBConnection(conn);
        return result;
    }

    public int insertMark(Marks mark) throws SQLException {
        DBConnection conn = getDBConnection();
        int result = conn.insertMark(mark);
        this.putDBConnection(conn);
        return result;
    }

    public int getMarksDisciplines(int idTermDiscipline, int idTerm, int idStudent) throws SQLException {
        DBConnection conn = getDBConnection();
        int result = conn.getMarksDisciplines(idTermDiscipline, idTerm, idStudent);
        this.putDBConnection(conn);
        return result;
    }

    public List<Marks> getDisciplinesByIdTermIdStudent(int idTerm, int idStudent)throws SQLException {
        DBConnection conn = getDBConnection();
        List <Marks> result = conn.getDisciplinesByIdTermIdStudent(idTerm,idStudent);
        this.putDBConnection(conn);
        return result;
    }

	public void close() {
	}	
}
