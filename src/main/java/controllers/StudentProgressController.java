package controllers;

import entity.Marks;
import entity.Student;
import entity.Term;
import services.MarkService;
import services.StudentService;
import services.TermService;
import services.impl.MarkServiceImpl;
import services.impl.StudentServiceImpl;
import services.impl.TermServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by Sergii
 * Class return list of marks selected student
 */
public class StudentProgressController extends AbstractWebtasksServletHandler {

    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (request.getParameter("chooser") != null) {
            if (request.getParameter("id") != null) {

                String idStud = request.getParameter("id");
                int idSelectedStudent = Integer.valueOf(idStud);
                StudentService studentService = new StudentServiceImpl();
                Student student = studentService.getStudentById(idSelectedStudent);
                request.setAttribute("student", student);

                String idTerm = request.getParameter("chooser");
                int idSelectedTerm = Integer.valueOf(idTerm);
                TermService termService = new TermServiceImpl();
                Term selectedTerm = termService.getById(idSelectedTerm);
                request.setAttribute("selectedTerm", selectedTerm);
                List<Term> terms = termService.getTerms();
                request.setAttribute("terms", terms);

                MarkService markService = new MarkServiceImpl();
                List<Marks> markList = markService.getDisciplinesByIdTermIdStudent(idSelectedTerm,idSelectedStudent);

                request.setAttribute("marks", markList);
                gotoToJSP("/main/student/studentsProgress.jsp", request, response);

            }
        } else {

                String idStud = request.getParameter("id");
                int idSelectedStudent = Integer.valueOf(idStud);
                StudentService studentService = new StudentServiceImpl();
                Student student = studentService.getStudentById(idSelectedStudent);
                request.setAttribute("student", student);

                TermService termService = new TermServiceImpl();
                List<Term> terms = termService.getTerms();
                request.setAttribute("terms", terms);

                gotoToJSP("/main/student/studentsProgress.jsp", request, response);
            }
    }
}
