package controllers;

import entity.Student;
import services.StudentService;
import services.impl.StudentServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Sergii on 03.05.2015.
 */
public class StudentDeleteController extends AbstractWebtasksServletHandler {
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String strId = request.getParameter("id");
        if(strId==null){forwardRequest("/admin/studentsList.php",request,response);}
        String [] allId = strId.split(",");
        //if(){}
        for(int i=0;i<allId.length;i++){
            int id = Integer.valueOf(allId[i]);
            StudentService studentServise = new StudentServiceImpl();
            Student student = new Student(id);
            if(studentServise.studentDelete(student)){
                //forwardRequest exception
                forwardRequest("/admin/studentsList.php",request,response);
            }else{
                System.out.println("exception in split StudDeleteController");
            }
        }
            forwardRequest("/admin/studentsList.php",request,response);
    }
}
