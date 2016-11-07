package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.SimpleUser;
import service.SimpleUserService;

/**
 * Servlet implementation class FindSimpleUsersByLocation
 */
@WebServlet("/FindSimpleUsersByLocation")
public class FindSimpleUsersByLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String LOCATION = "location";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindSimpleUsersByLocation() {
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

		// RequestDispatcher to forward in created and stored successfully in
		// database
		RequestDispatcher successDispatcher = getServletContext().getRequestDispatcher("/list_results.jsp");

		// Instantiate a service for SimpleUser database operations
		SimpleUserService simpleUserService = new SimpleUserService();

		// Prepare an error message & error counter
		String errorMessage;

		// Get parameters from the request
		String location = request.getParameter(LOCATION);

		if (location == null || location.length() == 0) {
			System.out.println("Location is null");
		}

		// A List to store all SimpleUsers from the specified location
		List<SimpleUser> simpleUsers = new ArrayList<SimpleUser>();

		try {
			simpleUsers = simpleUserService.findByLocation(location);
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// Set SimpleUser to request
		request.setAttribute("simpleUsers", simpleUsers);
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

}
