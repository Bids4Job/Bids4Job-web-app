package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutSimpleController
 */
@WebServlet("/logout_user")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Dispatcher for the logout page
	RequestDispatcher logoutDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// Define RequestDispatcher object to forward any errors
		logoutDispatcher = getServletContext().getRequestDispatcher("/logout.jsp");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Invalidate the current session
		request.getSession().invalidate();
		logoutDispatcher.forward(request, response);
	}

}
