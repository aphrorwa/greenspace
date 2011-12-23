package org.rw.greenspace.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rw.greenspace.dao.TreeDAO;
import org.rw.greenspace.dao.impl.TreeDAOImpl;
import org.rw.greenspace.orm.Tree;

/**
 * Servlet implementation class CreateTreeServlet
 */
public class CreateTreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TreeDAO treeDAO = TreeDAOImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTreeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageRedirect = request.getParameter("page");
		if (pageRedirect != null) {
			if (pageRedirect.equals("createtree")) {
				if (request.getParameter("saveDataTree") != null) {
					Tree tree = new Tree();
					String treeName = request.getParameter("treename");
					String treeDescr = request.getParameter("treedescription");
					tree.setTreeName(treeName);
					tree.setTreeDescription(treeDescr);
					treeDAO.saveOrUpdateTree(tree);

				}
			}
			request.getRequestDispatcher("WEB-INF/createtree.jsp").forward(
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
