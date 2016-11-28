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

import domain.ProfessionalUser;
import service.ProfessionalUserService;

/**
 * Servlet implementation class LoginProfessionalController
 */
@WebServlet("/login_professional")
public class LoginProfessionalController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String EMAIL_OR_USERNAME = "emailOrUsername";
    private static final String PASSWORD = "password";
   // private String rating = null;
    private ProfessionalUser pro;
    private ProfessionalUserService service;
  //  private ContractService contractService;

    RequestDispatcher errorDispatcher;
    private static final String PROFILE_CONTROLLER = "profile_professional";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProfessionalController() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    public void init() {
	// Define RequestDispatcher object to forward any errors
	errorDispatcher = getServletContext().getRequestDispatcher("/errorprinter.jsp");

	// Instantiate a ProfessionalUser service object
	service = new ProfessionalUserService();
	//contractService = new ContractService();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	// response.getWriter().append("Served at:
	// ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	response.setContentType("text/html; charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	// Get the credentials from the login form
	String emailOrUsername = request.getParameter(EMAIL_OR_USERNAME);
	String password = request.getParameter(PASSWORD);
	// Get the HttpSession that is associated with this request
	HttpSession session = request.getSession();
	try {
	    pro = service.authenticateByEmail(emailOrUsername, password);
	    if (pro == null) {
		pro = service.authenticateByUsername(emailOrUsername, password);
	    }    
	    
	    if (pro != null) {
		//rating = contractService.findRatingByProUserID(pro.getProUserId());
		//session.setAttribute("rating", rating);
		session.setAttribute("pro", pro);
		response.sendRedirect(PROFILE_CONTROLLER);
	    } else {
		request.setAttribute("errorMessage", "Wrong email or password. Please try again.");
		errorDispatcher.forward(request, response);
	    }

	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException
		| NullPointerException e) {
	    request.setAttribute("errorMessage", e.getMessage());
	    errorDispatcher.forward(request, response);
	}

    }

}
