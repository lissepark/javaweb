package controllers;

import entity.Discipline;
import entity.Student;
import exeptions.InvalidDataException;
import services.DisciplineServise;
import services.StudentService;
import services.impl.DisciplineServiceImpl;
import services.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentModyController extends AbstractWebtasksServletHandler{

    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getMethod().equals("GET")){
            showPage01(request, response);
        } else {
            showPage02(request, response);
        }
    }

    protected void showPage01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        request.setAttribute("CURRENT_BUTTON",2);
        String strId = request.getParameter("id");
        if(strId==null){forwardRequest("/admin/studentsList.php",request,response);}
        int id = Integer.valueOf(strId);
        StudentService studentServise = new StudentServiceImpl();
        Student student = studentServise.getStudentById(id);
        request.setAttribute("student",student);
        gotoToJSP("/main/student/studentsCreatingModifying.jsp", request, response);
    }

    protected void showPage02(HttpServletRequest request, HttpServletResponse response) throws InvalidDataException, ServletException, IOException, SQLException {
        String name = request.getParameter("firstName");
        String strId = request.getParameter("id");
        String second_name = request.getParameter("lastName");
        String group = request.getParameter("group");
        String date = request.getParameter("date");
        java.sql.Date datesql = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date formatedDate = dateFormat.parse(date);
            datesql = new java.sql.Date(formatedDate.getTime());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        if(strId==null){forwardRequest("/admin/studentsList.php",request,response);}
        int id = Integer.valueOf(strId);
        //validateRequestDiscipline(strName);
        StudentService studentServise = new StudentServiceImpl();
        Student student = new Student(id,name,second_name,group,datesql);
        if(studentServise.studentModifing(student)){
            forwardRequest("/admin/studentsList.php",request,response);
        } else {
            //gotoToJSP
        }
    }

}