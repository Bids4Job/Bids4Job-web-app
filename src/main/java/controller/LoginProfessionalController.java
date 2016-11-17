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
	
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private ProfessionalUser pro;
	private ProfessionalUserService service;
	
	RequestDispatcher errorDispatcher;
	RequestDispatcher loginDispatcher;
	
       
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

		// Define RequestDispatcher object to forward if data are correct and
		// successfully stored in database
		loginDispatcher = getServletContext().getRequestDispatcher("/prouserprofile.jsp");

		// Instantiate a SimpleUser service object
		service = new ProfessionalUserService();
	}
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    	response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	    	// Get the credentials from the login form
	 	String email = request.getParameter(EMAIL);
	 	String password = request.getParameter(PASSWORD);
	 	// Get the HttpSession that is associated with this request
	 	HttpSession session = request.getSession();
	 	try {
		    pro = service.authenticate(email, password);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | NullPointerException e) {
		    request.setAttribute("errorMessage", e.getMessage());
		    errorDispatcher.forward(request, response);
		}
	 	
	 	if (pro != null){
	 	    session.setAttribute("pro", pro);
	 	    loginDispatcher.forward(request, response);
	 	} else {
	 	    request.setAttribute("errorMessage", "Not authenticate professional user");
	 	    errorDispatcher.forward(request, response);
	 	}
	 	

	}

}
