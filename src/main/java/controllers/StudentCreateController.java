package controllers;

import constants.Constants;
import entity.Student;
import exeptions.InvalidDataException;
import org.apache.commons.lang.StringUtils;
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

    protected void validateRequestStudent(String firstName,String lastName,String group,String date)
            throws InvalidDataException {
        if (StringUtils.isBlank(lastName)) {
            throw new InvalidDataException("lastName");
        }
        if (StringUtils.isBlank(firstName)) {
            throw new InvalidDataException("firstName");
        }
        if (StringUtils.isBlank(group)) {
            throw new InvalidDataException("group");
        }
        if (StringUtils.isBlank(date)) {
            throw new InvalidDataException("date");
        }
    }

    protected void showPage02(HttpServletRequest request, HttpServletResponse response) throws InvalidDataException, ServletException, IOException, SQLException {
        String name = request.getParameter("firstName");
        String second_name = request.getParameter("lastName");
        String group = request.getParameter("group");
        String date = request.getParameter("date");
        try{
        validateRequestStudent(name, second_name, group, date);
    } catch (InvalidDataException e) {
        request.setAttribute(Constants.VALIDATION_MESSAGE, e.getMessage());
            request.setAttribute("CURRENT_BUTTON",1);
            gotoToJSP("/main/student/studentsCreatingModifying.jsp", request, response);
    }

System.out.println(date);
        java.sql.Date datesql = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date formatedDate = dateFormat.parse(date);
            datesql = new java.sql.Date(formatedDate.getTime());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        StudentService studentServise = new StudentServiceImpl();
        Student student = new Student(name,second_name,group,datesql);
        if(studentServise.studentAdd(student)){
            forwardRequest("/admin/studentsList.php",request,response);
        } else {
            System.out.println("exception in StudentCreatController");
        }
    }
}
