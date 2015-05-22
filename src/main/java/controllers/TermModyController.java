package controllers;

import entity.Discipline;
import entity.Term;
import services.DisciplineServise;
import services.TermService;
import services.impl.DisciplineServiceImpl;
import services.impl.TermServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sergii on 04.05.2015.
 */
public class TermModyController extends AbstractWebtasksServletHandler {
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
        if(strId==""){forwardRequest("/admin/termsList.php", request, response);}
        int id = Integer.valueOf(strId);
        TermService termService = new TermServiceImpl();
        Term term = termService.getById(id);
        request.setAttribute("term",term);
        DisciplineServise disciplineServise = new DisciplineServiceImpl();
        List<Discipline> discipline = disciplineServise.getDisciplines();
        request.setAttribute("disciplines",discipline);
        gotoToJSP("/main/term/termCreatingModifying.jsp", request, response);
    }

    protected void showPage02(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String strId = request.getParameter("id");
        String strDuration = request.getParameter("duration");
        String name = request.getParameter("term_name");

        if(strId==""){forwardRequest("/admin/termsList.php", request, response);}
        int id = Integer.valueOf(strId);

        if(strDuration==""){forwardRequest("/admin/termsList.php",request,response);}
        int duration = Integer.valueOf(strDuration);

        TermService delTermDisc = new TermServiceImpl();
        if(!delTermDisc.deleteTermDiscipline(id)){
            forwardRequest("/admin/termsList.php",request,response);
        }

        String[] disciplines = request.getParameterValues("multi_list[]");
        List<Integer> discipline = new LinkedList<Integer>();
        Discipline disc = new Discipline();
        for(int a=0;a<disciplines.length;a++){
            int idDisc = Integer.valueOf(disciplines[a]);
            delTermDisc.insertTermDiscipline(id,idDisc);
            discipline.add(idDisc);
        }

        TermService termService = new TermServiceImpl();
        Term term = new Term();
        term.setId(id);
        term.setDuration(duration);
        term.setName(name);
        if(termService.modifing(term)){
            forwardRequest("/admin/termsList.php",request,response);
        } else {
            System.out.println("TermModyfException");
            //gotoToJSP
        }
    }
}