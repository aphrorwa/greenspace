package org.rw.greenspace.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rw.greenspace.dao.LocationDAO;
import org.rw.greenspace.dao.impl.LocationDAOImpl;
import org.rw.greenspace.orm.Location;

/**
 * Servlet implementation class ListLocationServlet
 */
public class ListLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocationDAO locationDAO= LocationDAOImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageRedirect = request.getParameter("page");
		if (pageRedirect != null) {
			if (pageRedirect.equals("locations")
					&& request.getParameter("action").equals("list")) {
				List<Location> locations = locationDAO
						.getAllLocations();
				request.setAttribute("locations", locations);
				request.getRequestDispatcher("WEB-INF/locations.jsp")
						.forward(request, response);
			}else if (pageRedirect.equals("deletelocation")
					&& request.getParameter("action").equals("delete")) {
				Location loc = new Location();
				loc.setId(Integer.parseInt(request.getParameter("locationId")));
				locationDAO.deleteLocation(loc);
				request.getRequestDispatcher("WEB-INF/deletelocation.jsp")
						.forward(request, response);
			}else if (pageRedirect.equals("editlocation")) {

				String id = request.getParameter("id");
				Location locCurVal = locationDAO.getLocationById(Integer
						.parseInt(id));
				request.setAttribute("curLocation", locCurVal);
				request.getRequestDispatcher("WEB-INF/editlocation.jsp")
						.forward(request, response);

			} else if (pageRedirect.equals("locationeditconfirm")
					&& request.getParameter("saveLocationChanges") != null) {
				Location location = new Location();
				String id = request.getParameter("id");
				String locationCode = request.getParameter("locationcode");
				String locationName = request.getParameter("locationname");
				String description = request.getParameter("description");

				location.setId(Integer.parseInt(id));
				location.setLocationCode(locationCode);
				location.setLocationName(locationName);
				location.setLocationDescription(description);
				locationDAO.updateLocation(location);

				request.getRequestDispatcher("WEB-INF/locationeditconfirm.jsp")
						.forward(request, response);
			}

		} else if (request.getParameter("locationsearch") != null) {
			String locationCode = request.getParameter("locationcode");
			Location location = locationDAO.getLocationByLocationCode(locationCode);
			request.setAttribute("location", location);
			request.getRequestDispatcher("WEB-INF/locationsearch.jsp")
					.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
