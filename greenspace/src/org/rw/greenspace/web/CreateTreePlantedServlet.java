package org.rw.greenspace.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rw.greenspace.dao.SeedDAO;
import org.rw.greenspace.dao.TreePlantedDAO;
import org.rw.greenspace.dao.impl.SeedDAOImpl;
import org.rw.greenspace.dao.impl.TreePlantedDAOImpl;
import org.rw.greenspace.orm.Seed;
import org.rw.greenspace.orm.TreePlanted;

/**
 * Servlet implementation class CreateTreePlantedServlet
 */
public class CreateTreePlantedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TreePlantedDAO treePlantedDAO = TreePlantedDAOImpl.getInstance();
	private SeedDAO seedDAO = SeedDAOImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTreePlantedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageRedirect = request.getParameter("page");
		List<Seed> seeds = seedDAO.getAllSeeds();
		if (pageRedirect != null) {
			if (pageRedirect.equals("createtreeplanted")) {
				if (request.getParameter("saveDataTreePlanted") != null) {
					TreePlanted tp = new TreePlanted();
					String seedId = request.getParameter("seedid");
					Seed seed = seedDAO.getSeedById(Integer.parseInt(seedId));
					
					String date = request.getParameter("date");
					String treePlantedQuantity = request.getParameter("treeplantedquantity");
					java.sql.Date dat = java.sql.Date.valueOf(date);
					tp.setDate(dat);
					tp.setTreeQuantity(Integer.parseInt(treePlantedQuantity));
					tp.setSeed(seed);
					treePlantedDAO.saveOrUpdateTreePlanted(tp);

				}
			}
			request.setAttribute("seeds", seeds);
			request.getRequestDispatcher("WEB-INF/createtreeplanted.jsp").forward(
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
