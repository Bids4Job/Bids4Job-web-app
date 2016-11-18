package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;

import dao.TaskDAO;

/**
 * Servlet implementation class IndexController
 * 
 * @author Dimitris
 */

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskDAO mDao;
	RequestDispatcher errorDispatcher;
	RequestDispatcher indexDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexController() {
		super();
	}

	@Override
	public void init() {
		// Define RequestDispatcher object to forward any errors
		errorDispatcher = getServletContext().getRequestDispatcher("/errorprinter.jsp");
		indexDispatcher = getServletContext().getRequestDispatcher("/index.jsp");

		// Instantiate a Contract service object
		mDao = new TaskDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		CachedRowSet crs = null;
		try {
			crs = mDao.findTenTasks();
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error Loading Profile: " + e.getMessage());
			errorDispatcher.forward(request, response);
		}
		request.setAttribute("tenTasks", crs);
		indexDispatcher.forward(request, response);
	}
}