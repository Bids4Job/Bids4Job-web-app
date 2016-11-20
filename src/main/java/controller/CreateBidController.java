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

import domain.Bid;
import domain.ProfessionalUser;
import service.BidService;

/**
 * Servlet implementation class CreateBidController
 */
@WebServlet("/create_bid")
public class CreateBidController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String AMOUNT = "amount";
	private Bid bid;
	// private ProfessionalUser pro;
	private BidService service;

	RequestDispatcher errorDispatcher;
	private static final String PROFILE_CONTROLLER = "profile_professional";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateBidController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// Define RequestDispatcher object to forward any errors
		errorDispatcher = getServletContext().getRequestDispatcher("/errorprinter.jsp");

		// Instantiate a ProfessionalUser service object
		service = new BidService();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		int amount = 0;
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		try {
			// int amount1 = Integer.parseInt(request.getParameter(AMOUNT));
			// Checks if "amount input" has numbers.
			String amountStr = request.getParameter(AMOUNT);
			if (validateAmount(amountStr)) {
				amount = Integer.parseInt(request.getParameter(AMOUNT));
			} else {
				request.setAttribute("errorMessage", "Wrong input at \"amount\" field.");
				errorDispatcher.forward(request, response);
				return;
			}
			// pro = (ProfessionalUser) request.getSession();
			// int proUserId = ((ProfessionalUser)
			// request.getSession().getAttribute("pro")).getProUserId();
			bid = service.create(new Bid()
					// Dummy value at TaskId = 1
					.setTaskId(taskId).setAmount(amount).setBidTime(new Timestamp(System.currentTimeMillis()))
					.setProUserId(((ProfessionalUser) request.getSession().getAttribute("pro")).getProUserId()));
			request.setAttribute("bid", bid);
			response.sendRedirect(PROFILE_CONTROLLER);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			request.setAttribute("errorMessage", e.getMessage());
			errorDispatcher.forward(request, response);
		}
	}

	/**
	 * Validates that the input is a number with less than 6 digits.
	 * 
	 * @param amount a string that represents the amount of a bid
	 * @return true if the validation is successful, else false
	 */
	private boolean validateAmount(String amount) {
		return amount.matches("[0-9]+") && amount.length() < 6;
	}
}
