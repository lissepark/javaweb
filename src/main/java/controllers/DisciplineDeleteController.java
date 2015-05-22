package controllers;

import entity.Discipline;
import services.DisciplineServise;
import services.impl.DisciplineServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Sergii on 21.04.2015.
 */
public class DisciplineDeleteController extends AbstractWebtasksServletHandler{

    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String strId = request.getParameter("id");
        String name = request.getParameter("name");
        if(strId==null){forwardRequest("/admin/disciplinesList.php",request,response);}
        int id = Integer.valueOf(strId);

        DisciplineServise disciplineServise = new DisciplineServiceImpl();
        Discipline discipline = new Discipline(id, name);
        if(disciplineServise.delete(discipline)){
            forwardRequest("/admin/disciplinesList.php",request,response);
        } else {
            System.out.println("exception in DiscDeleteController");
        }

        //shodit v bazu dannyh
        // podumat s proverkoy 1/ null, 2/ne celoe chislo
        // perenapravit na tekuschuu stranicu
        // boolean flagi na update
    }
}
