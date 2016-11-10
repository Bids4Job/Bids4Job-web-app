package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

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
		String errorMessage = "";

		// Get parameters from the request
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		String email = request.getParameter(EMAIL);
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		String location = request.getParameter(LOCATION);

		// Check for any errors in input values
		errorMessage += checkNullity(firstName, lastName, email, username, password, location);
		errorMessage += checkAlphaDashes(firstName, lastName, location);
		errorMessage += checkAlphanumericDashes(username, password);
		if (errorMessage.length() > 0) {
			request.setAttribute("errorMessage", errorMessage);
			errorDispatcher.forward(request, response);
			return;
		}

		// Create the SimpleUser to be stored
		SimpleUser simpleUser = new SimpleUser().setFirstName(firstName).setLastName(lastName).setLocation(location);
		try {
			simpleUser = simpleUserService.create(simpleUser);
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
	 * Checks if the given string values are null or empty
	 * 
	 * @param name
	 *            The name of the new SimpleUser
	 * @param surname
	 *            The surname of the new SimpleUser
	 * @param email
	 *            The email of the new SimpleUser
	 * @param username
	 *            The username of the new SimpleUser
	 * @param password
	 *            The password of the new SimpleUser
	 * @param location
	 *            The location of the new SimpleUser
	 * @return The Error Message or null if the given String can be an ID
	 */
	private String checkNullity(String name, String surname, String email, String username, String password,
			String location) {
		StringBuilder errorBuilder = new StringBuilder();
		if (name == null || name.length() == 0) {
			errorBuilder.append(FIRST_NAME).append(" field is empty").append("<br>");
		}
		if (surname == null || surname.length() == 0) {
			errorBuilder.append(LAST_NAME).append(" field is empty").append("<br>");
		}
		if (email == null || email.length() == 0) {
			errorBuilder.append(EMAIL).append(" field is empty").append("<br>");
		}
		if (username == null || username.length() == 0) {
			errorBuilder.append(USERNAME).append(" field is empty").append("<br>");
		}
		if (password == null || password.length() == 0) {
			errorBuilder.append(PASSWORD).append(" field is empty").append("<br>");
		}
		if (location == null || location.length() == 0) {
			errorBuilder.append(LOCATION).append(" field is empty").append("<br>");
		}
		return errorBuilder.toString();
	}

	/**
	 * Checks if the name, surname and location contain only Unicode letters and
	 * hyphens.
	 * 
	 * @param name
	 *            The name of the new SimpleUser
	 * @param surname
	 *            The surname of the new SimpleUser
	 * @param location
	 *            The location of the new SimpleUser
	 * @return Error message if there is an error, otherwise null
	 */
	private String checkAlphaDashes(String name, String surname, String location) {
		StringBuilder errorBuilder = new StringBuilder();
		if (!StringUtils.isAlphaSpace(name.replace('-', ' '))) {
			errorBuilder.append(FIRST_NAME).append(" should contain only letters and hyphens").append("<br>");
		}
		if (!StringUtils.isAlphaSpace(surname.replace('-', ' '))) {
			errorBuilder.append(LAST_NAME).append(" should contain only letters and hyphens").append("<br>");
		}
		if (!StringUtils.isAlphaSpace(location.replace('-', ' '))) {
			errorBuilder.append(LOCATION).append(" should contain only letters and hyphens").append("<br>");
		}
		return errorBuilder.toString();
	}

	/**
	 * Checks if the name and surname contain only Unicode letters, numbers and hyphens.
	 * 
	 * @param username
	 *            The username of the new SimpleUser
	 * @param password
	 *            The password of the new SimpleUser
	 * @return Error message if there is an error, otherwise an empty message
	 */
	private String checkAlphanumericDashes(String username, String password) {
		StringBuilder errorBuilder = new StringBuilder();
		if (!StringUtils.isAlphanumericSpace(username.replace('-', ' '))) {
			errorBuilder.append(USERNAME).append(" should contain only letters, numbers and hyphens").append("<br>");
		}
		if (!StringUtils.isAlphanumericSpace(password.replace('-', ' '))) {
			errorBuilder.append(PASSWORD).append(" should contain only letters, numbers and hyphens").append("<br>");
		}
		return errorBuilder.toString();
	}
}
