package org.rw.greenspace.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rw.greenspace.dao.UserDAO;
import org.rw.greenspace.dao.impl.UserDAOImpl;
import org.rw.greenspace.orm.User;

/**
 * Servlet implementation class CreateUserServlet
 */
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = UserDAOImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageRedirect = request.getParameter("page");
		if (pageRedirect != null) {
			if (pageRedirect.equals("createuser")) {
				if (request.getParameter("saveDataUser") != null) {
					User user = new org.rw.greenspace.orm.User();
					String usernameauth = request.getParameter("username");
					String passwordauth = request.getParameter("password");
					String userfullname = request.getParameter("userfullname");
					String role = request.getParameter("role");
					user.setUsername(usernameauth);
					user.setPassword(passwordauth);
					user.setFullName(userfullname);
					user.setRole(role);
					userDAO.saveOrUpdateUser(user);
				}

			}
			request.getRequestDispatcher("WEB-INF/createuser.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
