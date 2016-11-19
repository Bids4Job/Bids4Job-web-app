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

import domain.ProfessionalUser;
import service.ContractService;
import service.TaskService;

/**
 * Servlet implementation class ProfileProfessionalController
 */
@WebServlet("/profile_professional")
public class ProfileProfessionalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContractService contractService;
	private TaskService taskService;

	RequestDispatcher errorDispatcher;
	RequestDispatcher profileDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileProfessionalController() {
		super();
	}

	@Override
	public void init() {
		// Define RequestDispatcher object to forward any errors
		errorDispatcher = getServletContext().getRequestDispatcher("/errorprinter.jsp");
		profileDispatcher = getServletContext().getRequestDispatcher("/prouserprofile.jsp");

		// Instantiate a Contract and a Task service objects
		contractService = new ContractService();
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

		int proUserId;

		try {
			// Get Professional User ID
			proUserId = ((ProfessionalUser) session.getAttribute("pro")).getProUserId();
		} catch (NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Log in First! ");
			errorDispatcher.forward(request, response);
			return;
		}

		CachedRowSet crsTasks = null;

		try {
			crsTasks = taskService.findDetailsByProfessionalUserID(proUserId);
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error Loading Tasks in Profile: " + e.getMessage());
			errorDispatcher.forward(request, response);
		}

		String rating = null;

		try {
			rating = contractService
					.findRatingByProUserID(((ProfessionalUser) session.getAttribute("pro")).getProUserId());
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error Loading Profile: " + e.getMessage());
			errorDispatcher.forward(request, response);
		}

		// Set the contract details to session
		request.setAttribute("tasks", crsTasks);
		request.setAttribute("rating", rating);
		profileDispatcher.forward(request, response);

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
