package org.rw.greenspace.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rw.greenspace.dao.LocationDAO;
import org.rw.greenspace.dao.impl.LocationDAOImpl;
import org.rw.greenspace.orm.Location;

/**
 * Servlet implementation class CreateLocationServlet
 */
public class CreateLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocationDAO locationDAO = LocationDAOImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateLocationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pageRedirect = request.getParameter("page");
		if (pageRedirect != null) {
			if (pageRedirect.equals("createlocation")) {
				if (request.getParameter("saveDataLocation") != null) {
					Location loc = new Location();
					String locCode = request.getParameter("locationcode");
					String locName = request.getParameter("locationname");
					String locDescr = request.getParameter("locationdescription");
					loc.setLocationCode(locCode);
					loc.setLocationName(locName);
					loc.setLocationDescription(locDescr);
					locationDAO.saveOrUpdateLocation(loc);

				}
			}
			request.getRequestDispatcher("WEB-INF/createlocation.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
