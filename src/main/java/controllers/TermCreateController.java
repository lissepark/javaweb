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
import java.util.List;

/**
 * Created by Sergii on 04.05.2015.
 */
public class TermCreateController extends AbstractWebtasksServletHandler {
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getMethod().equals("GET")){
            showPage01(request, response);
        } else {
            showPage02(request, response);
        }
    }

    protected void showPage01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("CURRENT_BUTTON",1);
        DisciplineServise disciplineServise = new DisciplineServiceImpl();
        List<Discipline> disciplineList = disciplineServise.getDisciplines();
        request.setAttribute("disciplines", disciplineList);
        gotoToJSP("/main/term/termCreatingModifying.jsp", request, response);
    }

    protected void showPage02(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String durat = request.getParameter("duration");
        int duration = Integer.valueOf(durat);
        String name = request.getParameter("term_name");

        Term term = new Term();
        term.setName(name);
        term.setDuration(duration);
        TermService termServise = new TermServiceImpl();
        termServise.insertTerm(term);
        //proverka na dublikat name
        Term termCreated = termServise.getTermByName(name);
        int termCreatedId = termCreated.getId();

        String[] disciplines = request.getParameterValues("multi_list[]");
        for(int a = 0; a < disciplines.length; a++){
            int id = Integer.valueOf(disciplines[a]);
            termServise.insertTermDiscipline(termCreatedId,id);
        }
        List<Term> termList = termServise.getTerms();
        request.setAttribute("terms", termList);
        gotoToJSP("/main/term/termsList.jsp", request, response);
    }
}
