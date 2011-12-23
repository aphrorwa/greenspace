package org.rw.greenspace.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.rw.greenspace.dao.UserDAO;
import org.rw.greenspace.dao.impl.UserDAOImpl;
import org.rw.greenspace.orm.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = UserDAOImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User authenticatedUser = null;
		String privilege = null;

		// loops through users and compare them
		for (User user : userDAO.getAllUsers()) {

			if (user.getUsername().equals(username)
					&& user.getPassword().equals(password)) {
				authenticatedUser = user;

				privilege = user.getRole();
				session.setAttribute("authenticatedUser", authenticatedUser);
				break;
			}
		}

		if (authenticatedUser != null && privilege.equals("user")) {
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,
					response);
		} else if (authenticatedUser != null && privilege.equals("admin")) {
			request.getRequestDispatcher("WEB-INF/homeadmin.jsp").forward(
					request, response);
		} else {
			request.getSession().invalidate();
			doGet(request, response);
		}
	}

}
