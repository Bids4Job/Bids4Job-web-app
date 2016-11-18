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

/**
 * Servlet implementation class ProfileSimpleController
 */
@WebServlet("/profile_simple")
public class ProfileSimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// A service for Contract database operations
	private ContractService contractService;

	// Dispatchers for error and profile pages
	RequestDispatcher errorDispatcher;
	RequestDispatcher profileDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileSimpleController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// Define RequestDispatcher object to forward any errors
		errorDispatcher = getServletContext().getRequestDispatcher("/errorprinter.jsp");
		profileDispatcher = getServletContext().getRequestDispatcher("/suserprofile.jsp");

		// Instantiate a Contract service object
		contractService = new ContractService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// Get the HttpSession that is associated with this request
		HttpSession session = request.getSession();
		// Define a CachedRowSet to contain the rows to be displayed
		CachedRowSet crs = null;

		try {
			crs = contractService
					.findDetailsBySimpleUserID(((SimpleUser) session.getAttribute("simple-user")).getSimpleUserID());
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error Loading Profile: " + e.getMessage());
			errorDispatcher.forward(request, response);
		}

		// Set the contract details to session
		request.setAttribute("contracts", crs);
		profileDispatcher.forward(request, response);
	}

}
