package controllers;

import constants.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Sergii Varenyk
 */
public class HomePageController extends AbstractWebtasksServletHandler{
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //HttpSession session = request.getSession(true);
        //Integer constants = (Integer) session.getAttribute("CURRENT_ROLE");
        //System.out.println(constants.getClass());
        //System.out.println(constants);
        gotoToJSP("main/home.jsp", request, response);
    }
}
