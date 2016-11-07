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
 * Servlet implementation class UpdateSimpleUserServlet
 */
@WebServlet("/UpdateSimpleUser")
public class UpdateSimpleUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Parameter names
	private static final String SIMPLE_USER_ID = "simpleUserID";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String LOCATION = "location";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSimpleUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// RequestDispatcher to forward in created and stored successfully in
		// database
		RequestDispatcher successDispatcher = getServletContext().getRequestDispatcher("/single_result.jsp");

		// Instantiate a service for SimpleUser database operations
		SimpleUserService simpleUserService = new SimpleUserService();
		// Boolean representing the result of the update
		boolean updated = false;
		
		// Prepare an error message & error counter
		String errorMessage = "";

		// Get parameters from the request
		int simpleUserID = 0;
		String simpleUserIDStr = request.getParameter(SIMPLE_USER_ID);	
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		String email = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);
		String location = request.getParameter(LOCATION);

		errorMessage = checkID(simpleUserIDStr);
		if (errorMessage != null) {
			response.getWriter().append(errorMessage);
		} else {
			simpleUserID = Integer.parseInt(simpleUserIDStr);
		}

		// Create the SimpleUser to be stored
		SimpleUser simpleUser = new SimpleUser().setSimpleUserID(simpleUserID).setFirstName(firstName).setLastName(lastName).setLocation(location);
		try {
			updated = simpleUserService.update(simpleUser);
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		if (updated) {
			try {
				simpleUser = simpleUserService.findOne(simpleUserID);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
				e.printStackTrace();
			}
			// Set SimpleUser to request
			request.setAttribute("simpleUser", simpleUser);
			successDispatcher.forward(request, response);
		} else {
			// Nothing was updated in database
		}
	}

	/**
	 * Checks if the given string could be an ID
	 * 
	 * @param id The String to be checked
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
