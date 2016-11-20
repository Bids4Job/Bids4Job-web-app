package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Contract;
import service.ContractService;

/**
 * Servlet implementation class SignContractController
 */
@WebServlet("/sign_contract")
public class SignContractController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Parameter names
	private static final String TASK_ID = "taskId";
	private static final String BID_ID = "bidId";

	// A service for Contract related database operations
	private ContractService contractService;

	// SimpleUser profile page
	private static final String PROFILE_CONTROLLER = "profile_simple";

	// Dispatchers for error and registered pages
	RequestDispatcher errorDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignContractController() {
		super();
	}

	@Override
	public void init() {
		// Define RequestDispatcher object to forward any errors
		errorDispatcher = getServletContext().getRequestDispatcher("/errorprinter.jsp");

		// Instantiate a Contract service object
		contractService = new ContractService();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		int taskID = Integer.parseInt(request.getParameter(TASK_ID));
		int bidID = Integer.parseInt(request.getParameter(BID_ID));

		// Define a Contract object to store the logged in user
		Contract contract = null;

		// Sign a new Contract using the ContractService
		try {
			contract = contractService.sign(new Contract().setBidID(bidID).setTaskID(taskID)
					.setContractTime(new Timestamp(System.currentTimeMillis())));	
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error Signing a new Contract: " + e.getMessage());
			errorDispatcher.forward(request, response);
		}
		
		// Return to simple user profile page if a Contract object has been returned																																																																																																																					
		if (contract != null) {
			response.sendRedirect(PROFILE_CONTROLLER);
		} else {
			request.setAttribute("errorMessage", "Error Signing a new Contract. \nPlease contact us!");
			errorDispatcher.forward(request, response);
		}
	}

}
