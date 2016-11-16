package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProfessionalUserService;

/**
 * Servlet implementation class LogoutProfessionalController
 */
@WebServlet("/logout_professional")
public class LogoutProfessionalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//RequestDispatcher errorDispatcher;
	RequestDispatcher logoutDispatcher;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutProfessionalController() {
        super();
        // TODO Auto-generated constructor stub
    }

    	@Override
   	public void init() {
   		// Define RequestDispatcher object to forward any errors
   		//errorDispatcher = getServletContext().getRequestDispatcher("/professional_user_error_page.jsp");

   		// Define RequestDispatcher object to forward if data are correct and
   		// successfully stored in database
   		logoutDispatcher = getServletContext().getRequestDispatcher("/index.jsp");

   	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    	request.getSession().invalidate();
	    	logoutDispatcher.forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
