package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import services.LoginService;
import services.impl.LoginServiceImpl;
import constants.Constants;
import dao.impl.RoleDaoImpl;
import dao.RoleDao;
import entity.Account;
import entity.Role;
import exeptions.InvalidDataException;

public class LoginController extends AbstractWebtasksServletHandler {

	private final Map<Integer, String> mappings = new HashMap<>();

	public LoginController() {
		mappings.put(ROLE_ADMIN, "/admin");
		mappings.put(ROLE_STUDENT, "/student");
	}

	@Override
	protected void handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("GET")) {
			showLoginPage(request, response);
		} else {
			loginHandler(request, response);
		}
	}

	protected void showLoginPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		RoleDao roleDao = new RoleDaoImpl();
		List<Role> roles = roleDao.getRoles();
		request.setAttribute("roles", roles);
		gotoToJSP("/login.jsp", request, response);
	}

	protected void validateRequest(String username, String password) throws InvalidDataException {
		if (StringUtils.isBlank(username)) {
			throw new InvalidDataException("username");
		}
		if (StringUtils.isBlank(password)) {
			throw new InvalidDataException("password");
		}
	}

	protected void loginHandler(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String login = request.getParameter("username");
		String password = request.getParameter("password");

		try {
            Integer idRole = Integer.parseInt(request.getParameter("role"));
			validateRequest(login, password);
			LoginService loginService = new LoginServiceImpl();
			Account a = loginService.login(login, password, idRole);
			String mapping = mappings.get(idRole);
			if (mapping != null) {
				request.getSession().setAttribute(CURRENT_SESSION_ACCOUNT, a);
				request.getSession().setAttribute(CURRENT_ROLE, idRole);
				request.getSession().setAttribute(CURRENT_MAPPING, mapping);
				redirectRequest(mapping + "/home.php", request, response);
			} else {
				throw new InvalidDataException("role");
			}
		} catch (InvalidDataException e) {
			request.setAttribute(Constants.VALIDATION_MESSAGE,
					e.getMessage());
			gotoToJSP("login.jsp", request, response);
		}catch(NumberFormatException ignore){
            gotoToJSP("login.jsp", request, response);
        }
	}
}
