package controllers;

import entity.Student;
import exeptions.InvalidDataException;
import services.StudentService;
import services.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class StudentCreateController extends AbstractWebtasksServletHandler {

    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getMethod().equals("GET")){
            showPage01(request,response);
        }
        else {
            showPage02(request,response);
        }
    }

    protected void showPage01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("CURRENT_BUTTON",1);
        gotoToJSP("/main/student/studentsCreatingModifying.jsp", request, response);
    }

    protected void showPage02(HttpServletRequest request, HttpServletResponse response) throws InvalidDataException, ServletException, IOException, SQLException {
        String name = request.getParameter("firstName");
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
        //validateRequestDiscipline(strName);
        StudentService studentServise = new StudentServiceImpl();
        Student student = new Student(name,second_name,group,datesql);
        if(studentServise.studentAdd(student)){
            forwardRequest("/admin/studentsList.php",request,response);
        } else {
            System.out.println("exception in DiscCreatController");
        }
    }
}
