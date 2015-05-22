package controllers;

import entity.Discipline;
import entity.Marks;
import entity.Student;
import entity.Term;
import services.DisciplineServise;
import services.MarkService;
import services.StudentService;
import services.TermService;
import services.impl.DisciplineServiceImpl;
import services.impl.MarkServiceImpl;
import services.impl.StudentServiceImpl;
import services.impl.TermServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sergii Varenyk.
 * Class insert marks in DB and return marks from DB
 */
public class MarksInsertController extends AbstractWebtasksServletHandler{

    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getMethod().equals("GET")){
            showPage01(request, response);
        } else {
            showPage02(request, response);
        }
    }

    protected void showPage01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        StudentService studentService = new StudentServiceImpl();
        List<Student> studentsList = studentService.getStudents();
        request.setAttribute("students", studentsList);

        TermService termService = new TermServiceImpl();
        List<Term> termList = termService.getTerms();
        request.setAttribute("terms", termList);

        if(request.getParameter("chooserTerm")==null){gotoToJSP("/main/mark/marksList.jsp", request, response);}
        else if(request.getParameter("chooserStd")==null){gotoToJSP("/main/mark/marksList.jsp", request, response);}
            else {
            String idSelectedTerm = request.getParameter("chooserTerm");
            String idSelectedStudent = request.getParameter("chooserStd");
            int SelectedTermId = Integer.valueOf(idSelectedTerm);
            int SelectedStudentId = Integer.valueOf(idSelectedStudent);
            Term selectedTerm = termService.getById(SelectedTermId);
            request.setAttribute("selectedTerm",selectedTerm);
            Student selectedStudent = studentService.getStudentById(SelectedStudentId);
            request.setAttribute("selectedStudent",selectedStudent);

            DisciplineServise disciplineService = new DisciplineServiceImpl();
            List<Integer>  disciplinesIdList = disciplineService.getDisciplinesByIdTerm(SelectedTermId);
            List<Discipline> disciplinesList = new LinkedList<Discipline>();
            for(Iterator<Integer> iter = disciplinesIdList.iterator();iter.hasNext();) {
                int idDiscByIdTerm = iter.next();
                Discipline discipline = disciplineService.getById(idDiscByIdTerm);
                disciplinesList.add(discipline);
            }
            request.setAttribute("disciplines",disciplinesList);
            gotoToJSP("/main/mark/marksList.jsp", request, response);
        }

    }

    protected void showPage02(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        MarkService markService = new MarkServiceImpl();
        String idStud = request.getParameter("idS");
        String idTerm = request.getParameter("idT");
        int studentId = Integer.valueOf(idStud);
        int termId = Integer.valueOf(idTerm);

        DisciplineServise disciplineService = new DisciplineServiceImpl();
        List<Integer>  discIdList = disciplineService.getDisciplinesByIdTerm(termId);

        for(Iterator<Integer> iter = discIdList.iterator();iter.hasNext();) {
            String DiscIdByIdTermString = iter.next().toString();
            int DiscIdByIdTerm = Integer.valueOf(DiscIdByIdTermString);
            String markDisc = request.getParameter(DiscIdByIdTermString);
            int mrk = Integer.valueOf(markDisc);
            Marks mark = new Marks();
            mark.setMark(mrk);
            mark.setId_pair_term_discipline(DiscIdByIdTerm);
            mark.setId_student(studentId);
            mark.setIdTerm(termId);
            markService.insert(mark);
        }
        StudentService studentService = new StudentServiceImpl();
        List<Student> studentsList = studentService.getStudents();
        request.setAttribute("students", studentsList);

        TermService termService = new TermServiceImpl();
        List<Term> termList = termService.getTerms();
        request.setAttribute("terms", termList);
        gotoToJSP("/main/mark/marksList.jsp", request, response);
    }
}
