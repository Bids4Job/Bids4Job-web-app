package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.SimpleUserService;

/**
 * Servlet implementation class LoginSimpleController
 */
@WebServlet("/LoginSimpleController")
public class LoginSimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Parameter names
	private static final String EMAIL = "email";
	private static final String PASSWORD = "upass";

	// A service for SimpleUser database operations
	private SimpleUserService simpleUserService;

	// Dispatchers for error and registered pages
	RequestDispatcher errorDispatcher;
	RequestDispatcher registeredDispatcher;

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
		errorDispatcher = getServletContext().getRequestDispatcher("/simple_user_error_printer.jsp");

		// Define RequestDispatcher object to forward if data are correct and
		// successfully stored in database
		registeredDispatcher = getServletContext().getRequestDispatcher("/temp_logedin.jsp");

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
		// Get the HttpSession that is associated with this request
		HttpSession session = request.getSession();
		
		// TODO authenticate user
	}

}
