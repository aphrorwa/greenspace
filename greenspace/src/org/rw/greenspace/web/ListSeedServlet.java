package org.rw.greenspace.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rw.greenspace.dao.SeedDAO;
import org.rw.greenspace.dao.impl.SeedDAOImpl;
import org.rw.greenspace.orm.Seed;

/**
 * Servlet implementation class ListSeedServlet
 */
public class ListSeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SeedDAO seedDAO= SeedDAOImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageRedirect = request.getParameter("page");
		if (pageRedirect != null) {
			if (pageRedirect.equals("seeds")
					&& request.getParameter("action").equals("list")) {
				List<Seed> seeds = seedDAO
						.getAllSeeds();
				request.setAttribute("seeds", seeds);
				request.getRequestDispatcher("WEB-INF/seeds.jsp")
						.forward(request, response);
			}else if (pageRedirect.equals("deleteseed")
					&& request.getParameter("action").equals("delete")) {
				Seed sd = new Seed();
				sd.setId(Integer.parseInt(request.getParameter("seedId")));
				seedDAO.deleteSeed(sd);
				request.getRequestDispatcher("WEB-INF/deleteseed.jsp")
						.forward(request, response);
			}else if (pageRedirect.equals("editseed")) {

				String id = request.getParameter("id");
				Seed sdCurVal = seedDAO.getSeedById(Integer
						.parseInt(id));
				request.setAttribute("curSeed", sdCurVal);
				request.getRequestDispatcher("WEB-INF/editseed.jsp")
						.forward(request, response);

			} else if (pageRedirect.equals("seededitconfirm")
					&& request.getParameter("saveSeedChanges") != null) {
				Seed seed = new Seed();
				String id = request.getParameter("id");
				String date = request.getParameter("date");
				String seedQuantity = request.getParameter("seedquantity");
				seed.setId(Integer.parseInt(id));
				seed.setSeedQuantity(Integer.parseInt(seedQuantity));
				java.sql.Date dat = java.sql.Date.valueOf(date);
				seed.setDate(dat);
				seedDAO.updateSeed(seed);

				request.getRequestDispatcher("WEB-INF/seededitconfirm.jsp")
						.forward(request, response);
			}

		} else if (request.getParameter("seedsearch") != null) {
			String seedId = request.getParameter("seedid");
			Seed seed = seedDAO.getSeedById(Integer.parseInt(seedId));
			request.setAttribute("seed", seed);
			request.getRequestDispatcher("WEB-INF/seedsearch.jsp")
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
