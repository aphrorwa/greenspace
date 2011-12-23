package org.rw.greenspace.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rw.greenspace.dao.SeedDAO;
import org.rw.greenspace.dao.impl.SeedDAOImpl;
import org.rw.greenspace.orm.Seed;

/**
 * Servlet implementation class CreateSeedServlet
 */
public class CreateSeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SeedDAO seedDAO = SeedDAOImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageRedirect = request.getParameter("page");
		if (pageRedirect != null) {
			if (pageRedirect.equals("createseed")) {
				if (request.getParameter("saveDataSeed") != null) {
					Seed sd = new Seed();
					String date = request.getParameter("date");
					String seedQuantity = request.getParameter("seedquantity");
					java.sql.Date dat = java.sql.Date.valueOf(date);
					sd.setDate(dat);
					sd.setSeedQuantity(Integer.parseInt(seedQuantity));
					seedDAO.saveOrUpdateSeed(sd);

				}
			}
			request.getRequestDispatcher("WEB-INF/createseed.jsp").forward(
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
