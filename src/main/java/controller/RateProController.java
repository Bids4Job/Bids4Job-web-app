package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Contract;
import service.ContractService;

/**
 * Servlet implementation class RateProController
 */
@WebServlet("/rate_professional")
public class RateProController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Parameter names
	private static final String CONTRACT_ID = "contract_id";
	private static final String RATING = "rating";

	// A service for Contract database operations
	private ContractService contractService;

	// SimpleUser profile page
	private static final String PROFILE_PAGE = "suserprofile.jsp";

	// Dispatchers for error and registered pages
	RequestDispatcher errorDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RateProController() {
		super();
		// TODO Auto-generated constructor stub
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
		// Get the rating and the contract id from the form
		int contractID = Integer.parseInt(request.getParameter(CONTRACT_ID));
		int rating = Integer.parseInt(request.getParameter(RATING));
		
		// Define a Contract object to store the logged in user
		Contract contract;

		try {
			contract = contractService.findOne(contractID);
			contract.setProRating(rating);
			contractService.update(contract);
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error Rating Professional: " + e.getMessage());
			errorDispatcher.forward(request, response);
		}

		response.sendRedirect(PROFILE_PAGE);
	}

}
