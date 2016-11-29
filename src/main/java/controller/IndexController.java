package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;

import domain.ProfessionalUser;
import domain.SimpleUser;
import service.ContractService;
import service.TaskService;

/**
 * Servlet implementation class IndexController
 * 
 * @author Dimitris
 */

@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Service for Contract, Task database operations
	private ContractService contractService;
	private TaskService taskService;
	RequestDispatcher errorDispatcher;
	RequestDispatcher indexDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexController() {
		super();
	}

	@Override
	public void init() {
		// Define RequestDispatcher object to forward any errors
		errorDispatcher = getServletContext().getRequestDispatcher("/errorprinter.jsp");
		indexDispatcher = getServletContext().getRequestDispatcher("/index.jsp");

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

		// Define CachedRowSets to contain the rows to be displayed
		CachedRowSet crsContracts = null;
		CachedRowSet crsTasks = null;

		// Get the ProfessionalUser of SimpleUser object from session
		ProfessionalUser professionalUser = (ProfessionalUser) request.getSession().getAttribute("pro");
		SimpleUser simpleUser = (SimpleUser) request.getSession().getAttribute("simple-user");

		if (simpleUser != null | professionalUser != null) {
			// Get contract details related with this SimpleUser
			try {
				crsContracts = (simpleUser != null)
						? contractService.findDetailsBySimpleUserID(simpleUser.getSimpleUserID()) : null;
			} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "Error Loading Contracts in Search Results: " + e.getMessage());
				errorDispatcher.forward(request, response);
			}
		}

		try {
			crsTasks = taskService.findDetailsByDeadlineDesc(10);
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error Loading Tasks: " + e.getMessage());
			errorDispatcher.forward(request, response);
		}

		// Set the contract and task details to request
		request.setAttribute("contracts", crsContracts);
		request.setAttribute("tenTasks", crsTasks);
		indexDispatcher.forward(request, response);
	}
}