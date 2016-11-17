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
    //private ProfessionalUser pro;
    private BidService service;

    RequestDispatcher errorDispatcher;
    private static final String PROFILE_PAGE = "prouserprofile.jsp";

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
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
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
	try {
	    //Checks if "amount input" has numbers
	    if (request.getParameter(AMOUNT).matches("[0-9]+")) {
		amount = Integer.parseInt(request.getParameter(AMOUNT));
	    } else {
		request.setAttribute("errorMessage", "Wrong input at \"amount\" field.");
		errorDispatcher.forward(request, response);
		//return;
	    }
	   // pro = (ProfessionalUser) request.getSession();
	   // int proUserId = ((ProfessionalUser) request.getSession().getAttribute("pro")).getProUserId();
	    bid = service.create(new Bid()
		    //Dummy value at TaskId = 1
		    .setTaskId(1)
		    .setAmount(amount)
		    .setBidTime(new Timestamp(System.currentTimeMillis()))
		    .setProUserId(((ProfessionalUser) request.getSession().getAttribute("pro")).getProUserId()));
	    request.setAttribute("bid", bid);
	    response.sendRedirect(PROFILE_PAGE);
	    
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
	    request.setAttribute("errorMessage", e.getMessage());
	    errorDispatcher.forward(request, response);
	}

    }

}
