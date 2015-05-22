package controllers;

import entity.Term;
import services.TermService;
import services.impl.TermServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            forwardRequest("/admin/termsList.php",request,response);
        } else {
            System.out.println("exception in TermDeleteController");
        }
    }
}
