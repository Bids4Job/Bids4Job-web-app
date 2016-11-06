package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.SimpleUser;
import service.SimpleUserService;

/**
 * Servlet implementation class CreateSimpleUserServlet
 */
@WebServlet("/CreateSimpleUser")
public class CreateSimpleUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Parameter names
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String EMAIL = "email";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String LOCATION = "location";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateSimpleUserServlet() {
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
		// RequestDispatcher to forward in created and stored successfully in database
		RequestDispatcher successDispatcher = getServletContext().getRequestDispatcher("/create_success.jsp");
		
		// Instantiate a service for SimpleUser database operations
		SimpleUserService simpleUserService = new SimpleUserService();

		// Prepare an error message & error counter
		String errorMessage = "";

		// Get parameters from the request
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		String email = request.getParameter(EMAIL);
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		String location = request.getParameter(LOCATION);

		errorMessage = checkNullity(firstName, lastName, email, username, password, location);
		if (errorMessage.equals("")) {
			response.getWriter().append(errorMessage);
		}

		SimpleUser simpleUser = new SimpleUser().setFirstName(firstName).setLastName(lastName).setLocation(location);
		// Set SimpleUser to request
		request.setAttribute("simpleUser", simpleUser);
		successDispatcher.forward(request, response);
	}

	private String checkNullity(String name, String surname, String email, String username, String password,
			String location) {
		StringBuilder errorBuilder = new StringBuilder();
		if (name == null || name.length() == 0) {
			errorBuilder.append(FIRST_NAME).append(" field is empty").append("\n");
		}
		if (surname == null || surname.length() == 0) {
			errorBuilder.append(LAST_NAME).append(" field is empty").append("\n");
		}
		if (email == null || email.length() == 0) {
			errorBuilder.append(EMAIL).append(" field is empty").append("\n");
		}
		if (username == null || username.length() == 0) {
			errorBuilder.append(USERNAME).append(" field is empty").append("\n");
		}
		if (password == null || password.length() == 0) {
			errorBuilder.append(PASSWORD).append(" field is empty").append("\n");
		}
		if (location == null || location.length() == 0) {
			errorBuilder.append(LOCATION).append(" field is empty").append("\n");
		}
		return errorBuilder.toString();
	}

}
