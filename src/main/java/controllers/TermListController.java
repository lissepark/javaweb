package controllers;

import entity.Discipline;
import entity.Term;
import exeptions.InvalidDataException;
import services.DisciplineServise;
import services.TermService;
import services.impl.DisciplineServiceImpl;
import services.impl.TermServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TermListController extends AbstractWebtasksServletHandler{

    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getMethod().equals("GET")){
            showPage01(request, response);
        } else {
            showPage02(request, response);
        }
    }

    protected void showPage01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        TermService termService = new TermServiceImpl();
        List<Term> termList = termService.getTerms();
        request.setAttribute("terms", termList);
        gotoToJSP("/main/term/termsList.jsp",request,response);
    }

    protected void showPage02(HttpServletRequest request, HttpServletResponse response) throws InvalidDataException, ServletException, IOException, SQLException {
        TermService termService = new TermServiceImpl();
        List<Term> termList = termService.getTerms();
        request.setAttribute("terms", termList);
        int id = 0;
        Integer idTerm = (Integer) request.getAttribute("id_term");
        if (idTerm != null) {
            id = idTerm;
        } else {
            String strId = request.getParameter("chooser");
            if (strId == null) {
                gotoToJSP("/main/term/termCreatingModifying.jsp", request, response);
            }
            id = Integer.valueOf(strId);
        }
        TermService termService2 = new TermServiceImpl();
        Term selectedTerm = termService2.getById(id);
        request.setAttribute("selectedTerm", selectedTerm);

        DisciplineServise disciplineServise = new DisciplineServiceImpl();
        List<Discipline> disciplineList = new LinkedList<Discipline>();
        List<Integer> disciplinesByIdTerm = disciplineServise.getDisciplinesByIdTerm(id);
        for(Iterator<Integer> iter = disciplinesByIdTerm.iterator();iter.hasNext();){
            int idDiscByIdTerm = iter.next();
            Discipline discipline = disciplineServise.getById(idDiscByIdTerm);
           /* if(disciplineServise.getById(id)){
                forwardRequest("/admin/termsList.php",request,response);
            } else {
                System.out.println("exception in DiscCreatController");
            }*/
            disciplineList.add(discipline);
        }
        request.setAttribute("disciplines", disciplineList);
        gotoToJSP("/main/term/termsList.jsp",request,response);
    }
}
