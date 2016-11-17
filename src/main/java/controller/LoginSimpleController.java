package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.SimpleUser;
import service.SimpleUserService;

/**
 * Servlet implementation class LoginSimpleController
 */
@WebServlet("/login_simple")
public class LoginSimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Parameter names
	private static final String EMAIL = "email";
	private static final String PASSWORD = "upass";

	// A service for SimpleUser database operations
	private SimpleUserService simpleUserService;

	// Dispatchers for error and registered pages
	RequestDispatcher errorDispatcher;
	RequestDispatcher simpleProfileDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginSimpleController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// Define RequestDispatcher object to forward any errors
		errorDispatcher = getServletContext().getRequestDispatcher("/errorprinter.jsp");

		// Define RequestDispatcher object to forward if data are correct and
		// successfully stored in database
		simpleProfileDispatcher = getServletContext().getRequestDispatcher("/temp_profile.jsp");

		// Instantiate a SimpleUser service object
		simpleUserService = new SimpleUserService();
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
		// Get the credentials from the login form
		String email = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);

		// Define a SimpleUser object to store the logged in user
		SimpleUser simpleUser = null;

		try {
			simpleUser = simpleUserService.authenticate(email, password);
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			errorDispatcher.forward(request, response);
		}
		
		if (simpleUser != null) {
			// Get the HttpSession that is associated with this request
			HttpSession session = request.getSession();
			// Set the user to session
			session.setAttribute("simple-user", simpleUser);
			simpleProfileDispatcher.forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Not an active account");
			errorDispatcher.forward(request, response);
		}
	}

}
