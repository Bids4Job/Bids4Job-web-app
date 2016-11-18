package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import dao.ProfessionalUserDao;
import domain.ProfessionalUser;
import service.ProfessionalUserService;

/**
 * Servlet implementation class ResgisterProfessionalController
 */
@WebServlet("/register_professional")
public class RegisterProfessionalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterProfessionalController() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub

	    	response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher errors = getServletContext().getRequestDispatcher("/errorprinter.jsp");
		
		ProfessionalUserService service = new ProfessionalUserService();
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("surname");
		String location = request.getParameter("location");
		String profession = request.getParameter("profession");
		String username = request.getParameter("uname");
		String password = request.getParameter("upass");
		String email = request.getParameter("email");
		
		String errorMessage = "";
		
		errorMessage += checkAlphaDashes(firstName, lastName);
		errorMessage += checkAlphanumericDashes(username, password);
		if (errorMessage.length() > 0) {
			request.setAttribute("errorMessage", errorMessage);
			errors.forward(request, response);
			return;
		}
				
		
		try {
		    if (service.exist(ProfessionalUserDao.EMAIL, email)){
			request.setAttribute("errorMessage", "Email already exists.");
			errors.forward(request, response);
		    }
		    if (service.exist(ProfessionalUserDao.USERNAME, username)){
			request.setAttribute("errorMessage", "Username already exists.");
			errors.forward(request, response);
		    }

		    
		    ProfessionalUser pro = new ProfessionalUser()
			    .setFirstName(firstName)
			    .setLastName(lastName)
			    .setLocation(location)
			    .setProfession(profession)
		 	    .setUsername(username)
		 	    .setPassword(password)
		 	    .setEmail(email)
		 	    .setActive(true);
		
		
		    pro = service.create(pro);
		    request.setAttribute("pro", pro);
		    RequestDispatcher succdis = getServletContext().getRequestDispatcher("/registered.jsp");
		    succdis.forward(request, response);
		    
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
		    // TODO Auto-generated catch block
		    //e.printStackTrace();
		    request.setAttribute("errorMessage", e.getMessage());
		    errors.forward(request, response);
		}

	}
	
	
	private String checkAlphaDashes(String firstName, String lastName) {
		StringBuilder errorBuilder = new StringBuilder();
		if (!StringUtils.isAlphaSpace(firstName.replace('-', ' '))) {
			errorBuilder.append(firstName).append(" should contain only letters and hyphens").append("<br>");
		}
		if (!StringUtils.isAlphaSpace(lastName.replace('-', ' '))) {
			errorBuilder.append(lastName).append(" should contain only letters and hyphens").append("<br>");
		}
		return errorBuilder.toString();
	}
	
	private String checkAlphanumericDashes(String username, String password) {
		StringBuilder errorBuilder = new StringBuilder();
		if (!StringUtils.isAlphanumericSpace(username.replace('-', ' '))) {
			errorBuilder.append(username).append(" should contain only letters, numbers and hyphens").append("<br>");
		}
		if (!StringUtils.isAlphanumericSpace(password.replace('-', ' '))) {
			errorBuilder.append(password).append(" should contain only letters, numbers and hyphens").append("<br>");
		}
		return errorBuilder.toString();
	}

}
