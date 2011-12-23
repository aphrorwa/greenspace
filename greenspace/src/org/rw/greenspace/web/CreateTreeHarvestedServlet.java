package org.rw.greenspace.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rw.greenspace.dao.TreePlantedDAO;
import org.rw.greenspace.dao.TreeHarvestedDAO;
import org.rw.greenspace.dao.impl.TreePlantedDAOImpl;
import org.rw.greenspace.dao.impl.TreeHarvestedDAOImpl;
import org.rw.greenspace.orm.Seed;
import org.rw.greenspace.orm.TreePlanted;

/**
 * Servlet implementation class CreateTreeHarvestedServlet
 */
public class CreateTreeHarvestedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TreeHarvestedDAO treeHarvestedDAO = TreeHarvestedDAOImpl.getInstance();
	private TreePlantedDAO treePlantedDAO = TreePlantedDAOImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTreeHarvestedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageRedirect = request.getParameter("page");
		List<TreePlanted> treePlanteds = treePlantedDAO.getAllTreePlanteds();
		if (pageRedirect != null) {
			if (pageRedirect.equals("createtreeharvested")) {
				if (request.getParameter("saveDataTreePlanted") != null) {
					String tpId = request.getParameter("tpid");
//					TreePlanted tp = treePlantedDAO.getTreePlantedById(tpId);
//					String seedId = request.getParameter("seedid");
//					Seed seed = seedDAO.getSeedById(Integer.parseInt(seedId));
//					
//					String date = request.getParameter("date");
//					String treeHarvestedQuantity = request.getParameter("treeharvestedquantity");
//					java.sql.Date dat = java.sql.Date.valueOf(date);
//					tp.setDate(dat);
//					tp.setTreeQuantity(Integer.parseInt(treeHarvestedQuantity));
//					tp.setSeed(seed);
//					treeHarvestedDAO.saveOrUpdateTreeHarvested(treeHarvested)

				}
			}
			request.setAttribute("treePlanteds", treePlanteds);
			request.getRequestDispatcher("WEB-INF/createtreeharvested.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
