package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.SimpleUser;
import service.SimpleUserService;

/**
 * Servlet implementation class FindOneSimpleUserServlet
 */
@WebServlet("/FindOneSimpleUser")
public class FindOneSimpleUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Parameter names
	private static final String SIMPLE_USER_ID = "simpleUserID";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindOneSimpleUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// RequestDispatcher object to forward any errors
		RequestDispatcher errorDispatcher = getServletContext().getRequestDispatcher("/error_printer.jsp");
		// RequestDispatcher to forward in created and stored successfully in
		// database
		RequestDispatcher successDispatcher = getServletContext().getRequestDispatcher("/single_result.jsp");

		// Instantiate a service for SimpleUser database operations
		SimpleUserService simpleUserService = new SimpleUserService();

		// Prepare an error message
		String errorMessage;

		// Get parameters from the request
		int simpleUserID = 0;
		String simpleUserIDStr = request.getParameter(SIMPLE_USER_ID);

		errorMessage = checkID(simpleUserIDStr);
		if (errorMessage != null) {
			request.setAttribute("errorMessage", errorMessage);
			errorDispatcher.forward(request, response);
			return;
		} else {
			simpleUserID = Integer.parseInt(simpleUserIDStr);
		}

		// Create the SimpleUser to be found
		SimpleUser simpleUser = null;
		try {
			simpleUser = simpleUserService.findOne(simpleUserID);
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			errorMessage = e.getMessage();
			request.setAttribute("errorMessage", errorMessage);
			errorDispatcher.forward(request, response);
		}

		// Set SimpleUser to request
		request.setAttribute("simpleUser", simpleUser);
		successDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * Checks if the given string could be an ID
	 * 
	 * @param id
	 *            The String to be checked
	 * @return The Error Message or null if the given String can be an ID
	 */
	private static String checkID(String id) {
		StringBuilder errorBuilder = new StringBuilder();
		if (id == null | id.length() == 0) {
			errorBuilder.append("Please insert Simple User ID!");
		} else if (!id.matches("[0-9]+")) {
			errorBuilder.append("Simple User ID must be a number.");
		}
		return errorBuilder.toString().length() != 0 ? errorBuilder.toString() : null;
	}
}
