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
import javax.sql.rowset.CachedRowSet;

import domain.SimpleUser;
import service.ContractService;
import service.SimpleUserService;

/**
 * Servlet implementation class LoginSimpleController
 */
@WebServlet("/login_simple")
public class LoginSimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Parameter names
	private static final String EMAIL_OR_USERNAME = "emailOrUsername";
	private static final String PASSWORD = "upass";

	// A service for SimpleUser database operations
	private SimpleUserService simpleUserService;
	
	// SimpleUser profile page
	private static final String PROFILE_CONTROLLER = "profile_simple";

	// Dispatchers for error and registered pages
	RequestDispatcher errorDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginSimpleController() {
		super();
	}

	@Override
	public void init() {
		// Define RequestDispatcher object to forward any errors
		errorDispatcher = getServletContext().getRequestDispatcher("/errorprinter.jsp");

		// Instantiate a SimpleUser service object
		simpleUserService = new SimpleUserService();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// Get the credentials from the login form
		String emailOrUsername = request.getParameter(EMAIL_OR_USERNAME);
		String password = request.getParameter(PASSWORD);

		// Define a SimpleUser object to store the logged in user
		SimpleUser simpleUser = null;

		try {
		   	simpleUser = simpleUserService.authenticateByEmail(emailOrUsername, password);
			if (simpleUser == null) {
			    simpleUser = simpleUserService.authenticateByUsername(emailOrUsername, password);
			}
			
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error Authenticating User: " + e.getMessage());
			errorDispatcher.forward(request, response);
		}
		
		if (simpleUser != null) {
			// Get the HttpSession that is associated with this request
			HttpSession session = request.getSession();
			// Set the user to session
			session.setAttribute("simple-user", simpleUser);
			response.sendRedirect(PROFILE_CONTROLLER);
		} else {
			request.setAttribute("errorMessage", "Wrong email or password");
			errorDispatcher.forward(request, response);
		}
	}

}
