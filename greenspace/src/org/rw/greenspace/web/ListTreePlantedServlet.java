package org.rw.greenspace.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rw.greenspace.dao.TreePlantedDAO;
import org.rw.greenspace.dao.impl.TreePlantedDAOImpl;
import org.rw.greenspace.orm.TreePlanted;

/**
 * Servlet implementation class ListTreePlantedServlet
 */
public class ListTreePlantedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TreePlantedDAO treePlantedDAO = TreePlantedDAOImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListTreePlantedServlet() {
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
			if (pageRedirect.equals("treeplanteds")
					&& request.getParameter("action").equals("list")) {
				List<TreePlanted> treePlanteds = treePlantedDAO
						.getAllTreePlanteds();
				request.setAttribute("treeplanteds", treePlanteds);
				request.getRequestDispatcher("WEB-INF/treeplanteds.jsp")
						.forward(request, response);
			} else if (pageRedirect.equals("deletetreeplanted")
					&& request.getParameter("action").equals("delete")) {
				TreePlanted tp = new TreePlanted();
				tp.setId(Integer.parseInt(request.getParameter("treeplantedId")));
				treePlantedDAO.deleteTreePlanted(tp);
				request.getRequestDispatcher("WEB-INF/deletetreeplanted.jsp")
						.forward(request, response);
			} else if (pageRedirect.equals("edittreeplanted")) {

				String id = request.getParameter("id");
				TreePlanted tpCurVal = treePlantedDAO
						.getTreePlantedById(Integer.parseInt(id));
				request.setAttribute("curTreePlanted", tpCurVal);
				request.getRequestDispatcher("WEB-INF/edittreeplanted.jsp")
						.forward(request, response);

			} else if (pageRedirect.equals("treeplantededitconfirm")
					&& request.getParameter("saveTreePlantedChanges") != null) {
				TreePlanted treeplanted = new TreePlanted();
				String id = request.getParameter("id");
				String date = request.getParameter("date");
				String treeplantedQuantity = request
						.getParameter("treeplantedquantity");
				treeplanted.setId(Integer.parseInt(id));
				treeplanted.setTreeQuantity(Integer
						.parseInt(treeplantedQuantity));
				java.sql.Date dat = java.sql.Date.valueOf(date);
				treeplanted.setDate(dat);
				treePlantedDAO.updateTreePlanted(treeplanted);

				request.getRequestDispatcher(
						"WEB-INF/treeplantededitconfirm.jsp").forward(request,
						response);
			}

		} else if (request.getParameter("treeplantedsearch") != null) {
			String treeplantedId = request.getParameter("treeplantedid");
			TreePlanted treeplanted = treePlantedDAO.getTreePlantedById(Integer
					.parseInt(treeplantedId));
			request.setAttribute("treeplanted", treeplanted);
			request.getRequestDispatcher("WEB-INF/treeplantedsearch.jsp")
					.forward(request, response);
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
