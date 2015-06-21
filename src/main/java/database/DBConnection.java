package database;

import entity.*;
import org.apache.log4j.Logger;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class DBConnection {
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class);
    private Connection conn = null;
    private ResultSet rs = null;
    private ResultSet rs2 = null;

    private static PreparedStatement loadAllRoles;
    private static PreparedStatement loadRolesById;
    private static PreparedStatement loadAllLogins;
    private static PreparedStatement loadAccountByLogin;
    private static PreparedStatement getIdAccountRoles;
    private static PreparedStatement getListStudents;
    private static PreparedStatement changeStudent;
    private static PreparedStatement insertStudent;
    private static PreparedStatement deleteStudent;
    private static PreparedStatement selectStudentById;
    private static PreparedStatement getListTerms;
    private static PreparedStatement insertTerm;
    private static PreparedStatement getIdTermDiscipline;
    private static PreparedStatement getTermById;
    private static PreparedStatement deleteTerm;
    private static PreparedStatement changeTerm;
    private static PreparedStatement getListDisciplines;
    private static PreparedStatement changeDiscipline;
    private static PreparedStatement insertDiscipline;
    private static PreparedStatement deleteDiscipline;
    private static PreparedStatement selectDisciplineById;
    private static PreparedStatement getTermByName;
    private static PreparedStatement insertTermDiscipline;
    private static PreparedStatement deleteTermDiscipline;
    private static PreparedStatement insertMark;
    private static PreparedStatement getMarksDisciplines;
    private static PreparedStatement getDisciplinesByIdTermIdStudent;

    public DBConnection(String url, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            loadPreparedStatements();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            LOGGER.error("ClassNotFoundException - > DBConnection(String url); " + e);
        }
    }

    private void loadPreparedStatements() {
        try {
            loadAllRoles = conn.prepareStatement("SELECT * FROM `roles`");
            loadAllLogins = conn.prepareStatement("SELECT login, id FROM account");
            loadAccountByLogin = conn.prepareStatement("SELECT * FROM account WHERE login = ?");
            loadRolesById = conn.prepareStatement("SELECT * FROM account_roles WHERE id =?");
            getIdAccountRoles = conn.prepareStatement("SELECT id_roles FROM account_roles WHERE id_account = ?");
            getListDisciplines = conn.prepareStatement("SELECT * FROM discipline");
            getListStudents = conn.prepareStatement("SELECT * FROM students");
            changeStudent = conn.prepareStatement("UPDATE `students` SET `name`=?,`lastname`=?,`group`=?,`date`=? WHERE `id`=?");
            insertStudent = conn.prepareStatement("INSERT INTO `students` SET `name`=?, `lastname`=?, `group`=?, `date`=?");
            deleteStudent = conn.prepareStatement("DELETE FROM `students` WHERE `id`=?");
            selectStudentById = conn.prepareStatement("SELECT * FROM students WHERE id = ?");
            getListTerms = conn.prepareStatement("SELECT * FROM term");
            changeDiscipline = conn.prepareStatement("UPDATE `discipline` SET `name`=? WHERE `id`=?");
            insertDiscipline = conn.prepareStatement("INSERT INTO discipline (name) VALUES (?)");
            deleteDiscipline = conn.prepareStatement("DELETE FROM `discipline` WHERE `id`=?");
            selectDisciplineById = conn.prepareStatement("SELECT * FROM discipline WHERE id = ?");
            getIdTermDiscipline = conn.prepareStatement("SELECT id_discipline FROM term_discipline WHERE id_term = ?");
            insertTerm = conn.prepareStatement("INSERT INTO `term` SET `duration`=?, `name`=?");
            getTermById = conn.prepareStatement("SELECT * FROM term WHERE id=?");
            getTermByName = conn.prepareStatement("SELECT * FROM term WHERE `name`=?");
            insertTermDiscipline = conn.prepareStatement("INSERT INTO term_discipline SET `id_term`=?, `id_discipline`=?");
            deleteTerm = conn.prepareStatement("DELETE FROM `term` WHERE `id`=?");
            changeTerm = conn.prepareStatement("UPDATE `term` SET `duration`=?,`name`=? WHERE `id`=?");
            deleteTermDiscipline = conn.prepareStatement("DELETE FROM `term_discipline` WHERE `id_term`=?");
            insertMark = conn.prepareStatement("INSERT INTO progress SET `id_student`=?, `id_term_discipline`=?, `mark`=?, `id_term`=?");
            getMarksDisciplines=conn.prepareStatement("SELECT mark FROM progress WHERE id_term_discipline = ? AND id_term = ? AND id_student = ?");
            getDisciplinesByIdTermIdStudent=conn.prepareStatement("SELECT * FROM progress WHERE id_term = ? AND id_student = ?");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void closePreparedStatements() {
        try {
            loadAllRoles.close();
            loadAllLogins.close();
            loadAccountByLogin.close();
            loadRolesById.close();
            getIdAccountRoles.close();
            getListDisciplines.close();
            getListStudents.close();
            getListTerms.close();
            insertDiscipline.close();
            selectDisciplineById.close();
            changeDiscipline.close();
            changeStudent.close();
            insertStudent.close();
            selectStudentById.close();
            deleteDiscipline.close();
            deleteStudent.close();
            getIdTermDiscipline.close();
            insertTerm.close();
            getTermById.close();
            getTermByName.close();
            insertTermDiscipline.close();
            deleteTerm.close();
            changeTerm.close();
            deleteTermDiscipline.close();
            insertMark.close();
            getMarksDisciplines.close();
            getDisciplinesByIdTermIdStudent.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Role> getAllRoles() {
        rs = null;
        List<Role> result = new LinkedList<Role>();
        try {
            rs = loadAllRoles.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                result.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public List<Discipline> getAllDisciplines() {
        //getListDisciplines
        rs = null;
        List<Discipline> result = new LinkedList<Discipline>();
        try {
            rs = getListDisciplines.executeQuery();
            while (rs.next()) {
                Discipline r = new Discipline();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                result.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Student> getAllStudents() {
        rs = null;
        List<Student> result = new LinkedList<Student>();
        try {
            rs = getListStudents.executeQuery();
            while (rs.next()) {
                Student r = new Student();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setSecond_name(rs.getString("lastname"));
                r.setGroup(rs.getString("group"));
                r.setDate(rs.getDate("date"));
                result.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Term> getAllTerms() {
        rs = null;
        List<Term> result = new LinkedList<Term>();
        try {
            rs = getListTerms.executeQuery();
            while (rs.next()) {
                Term r = new Term();
                r.setId(rs.getInt("id"));
                r.setDuration(rs.getInt("duration"));
                r.setName(rs.getString("name"));
                result.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Term getTermById(int id) {
        rs = null;
        Term result = new Term();
        try {
            getTermById.setInt(1,id);
            rs = getTermById.executeQuery();
            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setDuration(rs.getInt("duration"));
                result.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Term getTermByName(String name) {
        rs = null;
        Term result = new Term();
        try {
            getTermByName.setString(1, name);
            rs = getTermByName.executeQuery();
            while (rs.next()) {
                result.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Integer> getIdTermDiscipline(int idTerm) {
        rs = null;
        List<Integer> idTermDiscipline = new ArrayList<Integer>();
        try {
            getIdTermDiscipline.setInt(1, idTerm);
            rs = getIdTermDiscipline.executeQuery();
            while (rs.next()) {
                idTermDiscipline.add(rs.getInt("id_discipline"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idTermDiscipline;
    }

    public int insertTerm(Term term) throws SQLException {
        try {
            insertTerm.setInt(1, term.getDuration());
            insertTerm.setString(2, term.getName());
            return insertTerm.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("insertStudent - SQLException");
            return -1;
        }
    }

    public int insertTermDiscipline(int id_term, int id_discipline) throws SQLException {
        try {
            insertTermDiscipline.setInt(1, id_term);
            insertTermDiscipline.setInt(2, id_discipline);
            return insertTermDiscipline.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("insertStudent - SQLException");
            return -1;
        }
    }

    public int deleteTerm(int id) throws SQLException {
        try {
            deleteTerm.setInt(1, id);
            return deleteTerm.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("deleteTerm - SQLException");
            return -1;
        }
    }

    public int changeTerm(Term term) throws SQLException {
        try {
            changeTerm.setInt(1, term.getDuration());
            changeTerm.setString(2, term.getName());
            changeTerm.setInt(3, term.getId());
            return changeTerm.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("changeTerm - SQLException");
            return -1;
        }
    }

    public int deleteTermDiscipline(int id){
        try {
            deleteTermDiscipline.setInt(1, id);
            return deleteTermDiscipline.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("deleteTermDiscipline - SQLException");
            return -1;
        }
    }

    public List<Account> getAllLogins() {
        rs = null;
        List<Account> result = new LinkedList<Account>();
        try {
            rs = loadAllLogins.executeQuery();

            while (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString("login"));
                account.setId(rs.getInt("id"));
                //account.setPassword(rs.getString("password"));
                result.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public Account getAccountByLogin(String login) {
        rs = null;
        Account result = new Account();
        try {
            loadAccountByLogin.setNString(1, login);
            rs = loadAccountByLogin.executeQuery();

            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setUsername(rs.getString("login"));
                result.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public List<Role> getRolesById(int id) {
        rs = null;
        List<Role> result = new LinkedList<Role>();
        try {
            loadRolesById.setInt(1, id);
            rs = loadRolesById.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id_account"));
                role.setName(rs.getString("id_roles"));
                result.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void close() {
        closePreparedStatements();
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            LOGGER.info("close() exeption " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Integer> getIdAccountRoles(int idAccount) {
        rs = null;
        List<Integer> idAccountRoles = new ArrayList<Integer>();
        try {
            getIdAccountRoles.setInt(1, idAccount);
            rs = getIdAccountRoles.executeQuery();

            while (rs.next()) {
                idAccountRoles.add(rs.getInt("id_roles"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idAccountRoles;
    }


    public int changeDiscipline(Discipline discipline) throws SQLException {
        try {
            changeDiscipline.setString(1, discipline.getName());
            changeDiscipline.setInt(2, discipline.getId());
            return changeDiscipline.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("changeDiscipline - SQLException");
            return -1;
        }
    }

    public int insertDiscipline(Discipline discipline) throws SQLException {
        try {
            insertDiscipline.setString(1, discipline.getName());
            return insertDiscipline.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("insertDiscipline - SQLException");
            return -1;
        }
    }

    public Discipline selectDisciplineById(int id) throws SQLException {
        rs = null;
        Discipline result = new Discipline();
        try {
            selectDisciplineById.setInt(1, id);
            rs = selectDisciplineById.executeQuery();
            while (rs.next()) {
                result.setName(rs.getString("name"));
                result.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deleteDiscipline(Discipline discipline) throws SQLException {
        Discipline result = new Discipline();
        try {
            deleteDiscipline.setInt(1, discipline.getId());
            return deleteDiscipline.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("deleteDiscipline - SQLException");
            return -1;
        }
    }

    public int changeStudent(Student student) throws SQLException {
        try {
            changeStudent.setString(1, student.getName());
            changeStudent.setString(2, student.getSecond_name());
            changeStudent.setString(3, student.getGroup());
            changeStudent.setDate(4, (java.sql.Date) student.getDate());
            changeStudent.setInt(5, student.getId());
            return changeStudent.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("changeStudent - SQLException");
            return -1;
        }
    }

    public int insertStudent(Student student) throws SQLException {
        try {
            insertStudent.setString(1, student.getName());
            insertStudent.setString(2, student.getSecond_name());
            insertStudent.setString(3, student.getGroup());
            insertStudent.setDate(4, (java.sql.Date) student.getDate());
            return insertStudent.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("insertStudent - SQLException");
            return -1;
        }
    }

    public Student selectStudentById(int id) throws SQLException {
        rs = null;
        Student result = new Student();
        try {
            selectStudentById.setInt(1, id);
            rs = selectStudentById.executeQuery();
            while (rs.next()) {
                result.setName(rs.getString("name"));
                result.setId(rs.getInt("id"));
                result.setSecond_name(rs.getString("lastname"));
                result.setGroup(rs.getString("group"));
                result.setDate(rs.getDate("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deleteStudent(Student student) throws SQLException {
        Student result = new Student();
        try {
            deleteStudent.setInt(1, student.getId());
            return deleteStudent.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("deleteDiscipline - SQLException");
            return -1;
        }
    }

    public int insertMark(Marks mark)throws SQLException {
        try {
            insertMark.setInt(1,mark.getId_student());
            insertMark.setInt(2,mark.getId_pair_term_discipline());
            insertMark.setInt(3,mark.getMark());
            insertMark.setInt(4,mark.getIdTerm());
            return insertMark.executeUpdate();
        } catch (SQLException e){
            LOGGER.debug("insertMark - SQLException");
            return -1;
        }
    }

    public int getMarksDisciplines(int idTermDiscipline, int idTerm, int idStudent) {
        rs = null;
        int marksDisciplines = 0;
        try {
            getMarksDisciplines.setInt(1, idTermDiscipline);
            getMarksDisciplines.setInt(2, idTerm);
            getMarksDisciplines.setInt(3, idStudent);
            rs = getMarksDisciplines.executeQuery();

            while (rs.next()) {
                marksDisciplines=rs.getInt("mark");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marksDisciplines;
    }

    public List<Marks> getDisciplinesByIdTermIdStudent(int idTerm, int idStudent) {
        rs = null;
        List<Marks> result = new LinkedList<Marks>();
        try {
            getDisciplinesByIdTermIdStudent.setInt(1,idTerm);
            getDisciplinesByIdTermIdStudent.setInt(2,idStudent);
            rs = getDisciplinesByIdTermIdStudent.executeQuery();
            while(rs.next()){
                Marks m = new Marks();
                m.setMark(rs.getInt("mark"));
                int idTermDiscipline = rs.getInt("id_term_discipline");
                m.setId_pair_term_discipline(idTermDiscipline);

                ///////
                rs2 = null;
                Discipline discipline = new Discipline();
                try {
                    selectDisciplineById.setInt(1, idTermDiscipline);
                    rs2 = selectDisciplineById.executeQuery();
                    while (rs2.next()) {
                        discipline.setName(rs2.getString("name"));
                        discipline.setId(rs2.getInt("id"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                //////
                m.setDiscipline(discipline);

                result.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
