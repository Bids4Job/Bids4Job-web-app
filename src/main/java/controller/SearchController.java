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

import service.TaskService;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Parameter names
	private static final String SEARCH_PROFESSION = "profession";

	// Service for Task related database operations
	private TaskService taskService;

	// Dispatchers for error and search pages
	RequestDispatcher errorDispatcher;
	RequestDispatcher searchDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
		super();
	}

	@Override
	public void init() {
		// Define RequestDispatcher objects to forward any errors and results
		errorDispatcher = getServletContext().getRequestDispatcher("/errorprinter.jsp");
		searchDispatcher = getServletContext().getRequestDispatcher("/viewresults.jsp");

		// Instantiate a Task service object
		taskService = new TaskService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String profession = request.getParameter(SEARCH_PROFESSION);

		// Define a CachedRowSet to contain the rows to be displayed
		CachedRowSet crsTasks = null;

		// Get task details related with this SimpleUser
		try {
			crsTasks = taskService.findDetailsByProfession(profession);
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error Loading Search Results: " + e.getMessage());
			errorDispatcher.forward(request, response);
		}

		// Set the contract details to request
		request.setAttribute("tasks", crsTasks);
		searchDispatcher.forward(request, response);
	}

}
