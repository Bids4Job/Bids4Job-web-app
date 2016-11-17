package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BidService;

/**
 * Servlet implementation class CancelBidController
 */
@WebServlet("/cancel_bid")
public class CancelBidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String BIDID = "bidId";
	private BidService service;
	
	RequestDispatcher errorDispatcher;
	private static final String PROFILE_PAGE = "prouserprofile.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelBidController() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//	    	try {
//	    	    //if remove() = true
//	    	    if (service.remove(service.findOne(Integer.parseInt(request.getParameter(BIDID))))) {
//	    		response.sendRedirect(PROFILE_PAGE);
//	    	    } else {
//	    		request.setAttribute("errorMessage", "Bid didn't removed.");
//	    		errorDispatcher.forward(request, response);
//	    	    }
//	    	    
//	    	    
//	    	    
//	    	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
//		    request.setAttribute("errorMessage", e.getMessage());
//		    errorDispatcher.forward(request, response);
//		}
	    	
	    	//Dummy values
	    
	    	try {
		    if (service.remove(service.findOne(40)) == true){
			response.sendRedirect(PROFILE_PAGE);
		    } else {
			request.setAttribute("errorMessage", "Bid didn't removed.");
	    		errorDispatcher.forward(request, response);
		    }
		    
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
		    request.setAttribute("errorMessage", e.getMessage());
		    errorDispatcher.forward(request, response);
		}
	    
	    
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
