package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SimpleUserService;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Parameter names
	private static final String SEARCH_PROFESSION = "profession";

	// Dispatchers for error and registered pages
	RequestDispatcher errorDispatcher;
	// Dispatchers for error and registered pages
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
		
		searchDispatcher.forward(request, response);
	}

}
