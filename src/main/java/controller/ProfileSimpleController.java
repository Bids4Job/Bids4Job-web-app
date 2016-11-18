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
import service.TaskService;

/**
 * Servlet implementation class ProfileSimpleController
 */
@WebServlet("/profile_simple")
public class ProfileSimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Service for Contract, Task database operations
	private ContractService contractService;
	private TaskService taskService;

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
		// Instantiate a Task service object
		taskService = new TaskService();
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

		int simpleUserID;
		
		try {
			// Get SimpleUser ID
			simpleUserID = ((SimpleUser) session.getAttribute("simple-user")).getSimpleUserID();
		} catch (NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Log in First! ");
			errorDispatcher.forward(request, response);
			return;
		}

		// Define a CachedRowSet to contain the rows to be displayed
		CachedRowSet crsContracts = null;
		CachedRowSet crsTasks = null;

		// Get contract details related with this SimpleUser
		try {
			crsContracts = contractService.findDetailsBySimpleUserID(simpleUserID);
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error Loading Contracts in Profile: " + e.getMessage());
			errorDispatcher.forward(request, response);
		}

		// Get task details related with this SimpleUser
		try {
			crsTasks = taskService.findDetailsBySimpleUserID(simpleUserID);
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error Loading Tasks in Profile: " + e.getMessage());
			errorDispatcher.forward(request, response);
		}

		// Set the contract details to request
		request.setAttribute("contracts", crsContracts);
		request.setAttribute("tasks", crsTasks);
		profileDispatcher.forward(request, response);
	}

}
