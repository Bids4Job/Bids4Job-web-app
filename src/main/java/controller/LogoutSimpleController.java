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
@WebServlet("/logout_simple")
public class LogoutSimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Dispatchers for error and registered pages
	RequestDispatcher indexDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutSimpleController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// Define RequestDispatcher object to forward any errors
		indexDispatcher = getServletContext().getRequestDispatcher("/logout.jsp");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Invalidate the current session
		request.getSession().invalidate();
		indexDispatcher.forward(request, response);
	}

}
