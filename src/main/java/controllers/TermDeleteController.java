package controllers;

import entity.Discipline;
import entity.Term;
import services.DisciplineServise;
import services.TermService;
import services.impl.DisciplineServiceImpl;
import services.impl.TermServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Sergii on 04.05.2015.
 */
public class TermDeleteController extends AbstractWebtasksServletHandler {
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String strId = request.getParameter("id");
        if(strId==""){forwardRequest("/admin/termsList.php",request,response);}
        int id = Integer.valueOf(strId);
        TermService termService = new TermServiceImpl();
        if(termService.delete(id)){
            List<Term> termList = termService.getTerms();
            request.setAttribute("terms", termList);
            gotoToJSP("/main/term/termsList.jsp", request, response);
        } else {
            System.out.println("exception in TermDeleteController");
        }
    }
}
