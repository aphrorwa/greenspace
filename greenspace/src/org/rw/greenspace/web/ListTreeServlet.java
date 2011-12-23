package org.rw.greenspace.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rw.greenspace.dao.TreeDAO;
import org.rw.greenspace.dao.impl.TreeDAOImpl;
import org.rw.greenspace.orm.Tree;

/**
 * Servlet implementation class ListTreeServlet
 */
public class ListTreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TreeDAO treeDAO= TreeDAOImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTreeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageRedirect = request.getParameter("page");
		if (pageRedirect != null) {
			if (pageRedirect.equals("trees")
					&& request.getParameter("action").equals("list")) {
				List<Tree> trees = treeDAO
						.getAllTrees();
				request.setAttribute("trees", trees);
				request.getRequestDispatcher("WEB-INF/trees.jsp")
						.forward(request, response);
			}else if (pageRedirect.equals("deletetree")
					&& request.getParameter("action").equals("delete")) {
				Tree loc = new Tree();
				loc.setId(Integer.parseInt(request.getParameter("treeId")));
				treeDAO.deleteTree(loc);
				request.getRequestDispatcher("WEB-INF/deletetree.jsp")
						.forward(request, response);
			}else if (pageRedirect.equals("edittree")) {

				String id = request.getParameter("id");
				Tree locCurVal = treeDAO.getTreeById(Integer
						.parseInt(id));
				request.setAttribute("curTree", locCurVal);
				request.getRequestDispatcher("WEB-INF/edittree.jsp")
						.forward(request, response);

			} else if (pageRedirect.equals("treeeditconfirm")
					&& request.getParameter("saveTreeChanges") != null) {
				Tree tree = new Tree();
				String id = request.getParameter("id");
				String treeName = request.getParameter("treename");
				String description = request.getParameter("description");

				tree.setId(Integer.parseInt(id));
				tree.setTreeName(treeName);
				tree.setTreeDescription(description);
				treeDAO.updateTree(tree);

				request.getRequestDispatcher("WEB-INF/treeeditconfirm.jsp")
						.forward(request, response);
			}

		} else if (request.getParameter("treesearch") != null) {
			String treeId = request.getParameter("treeid");
			Tree tree = treeDAO.getTreeById(Integer.parseInt(treeId));
			request.setAttribute("tree", tree);
			request.getRequestDispatcher("WEB-INF/treesearch.jsp")
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
