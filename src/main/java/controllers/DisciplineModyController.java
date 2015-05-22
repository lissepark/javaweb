package controllers;

import entity.Discipline;
import exeptions.InvalidDataException;
import services.DisciplineServise;
import services.impl.DisciplineServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DisciplineModyController extends AbstractWebtasksServletHandler {
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
        if(strId==null){forwardRequest("/admin/disciplinesList.php",request,response);}
        int id = Integer.valueOf(strId);
        DisciplineServise disciplineServise = new DisciplineServiceImpl();
        Discipline discipline = disciplineServise.getById(id);
        request.setAttribute("discipline",discipline);
        gotoToJSP("/main/discipline/disciplinesCreatingModifying.jsp", request, response);
        }

    protected void showPage02(HttpServletRequest request, HttpServletResponse response) throws InvalidDataException, ServletException, IOException, SQLException {
            String strName = request.getParameter("name");
            String strId = request.getParameter("id");
            //if(strId==null){forwardRequest("/admin/disciplinesList.php",request,response);}
            int id = Integer.valueOf(strId);
            //validateRequestDiscipline(strName);
            DisciplineServise disciplineServise = new DisciplineServiceImpl();
            Discipline discipline = new Discipline(id,strName);
            if(disciplineServise.modifing(discipline)){
                forwardRequest("/admin/disciplinesList.php",request,response);
            } else {
                System.out.println("exception in DiscCreatController");
            }
    }
}
