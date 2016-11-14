package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProfessionalUser;
import service.ProfessionalUserService;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/ProfessionalUserUpdate")
public class ProfessionalUserUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessionalUserUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    	// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		RequestDispatcher errors = getServletContext().getRequestDispatcher("/ProfessionalUserErrorPage.jsp");
		
		//Get the "option" from submit button (create/update/remove)
		
		//initialization
		ProfessionalUserService service = new ProfessionalUserService();
		String errormsg = "";
		
		boolean check = true;
		int proUserId = 0;
		String firstName = null;
		String lastName = null;
		String location = null;
		String profession = null;
		String username = null;
		String password = null;
		String email = null;
		Boolean active = true;
		
		//Checks if the user type numbers and not characters
		    if (request.getParameter("proUserId").matches("[0-9]+")){
			proUserId = Integer.parseInt(request.getParameter("proUserId"));
		    }
		    else {
			errormsg = "Wrong input. Ids have only numbers, not characters";
			request.setAttribute("errormessage", errormsg);
			errors.forward(request, response);
			return;
		    }
		    
		    //Get the inputs parameters
		    firstName = request.getParameter("firstName");
		    lastName = request.getParameter("lastName");
		    location = request.getParameter("location");
		    profession = request.getParameter("profession");
		    username = request.getParameter("username");
		    password = request.getParameter("password");
		    email = request.getParameter("email");
		    	    
		    try {
					
			ProfessionalUser pro = service.findOne(proUserId);
			
			//Check if Professional User Id does not belong to a Professional User.
			if (pro == null){
			    errormsg = "The user with id: " + proUserId + " does not exist.\nPlease try again.";
			    request.setAttribute("errormessage", errormsg);
			    errors.forward(request, response);
			    return;
			}
			
			//checking if the user leave some inputs null
			if (!firstName.equals("")){
			    pro.setFirstName(firstName);
			}
			if (!lastName.equals("")){
			    pro.setLastName(lastName);
			}
			if (!location.equals("")){
			    pro.setLocation(location);
			}
			if (!profession.equals("")){
			    pro.setProfession(profession);
			}
			if (!username.equals("")){
			    pro.setUsername(username);
			}
			if (!password.equals("")){
			    pro.setPassword(password);
			}
			if (!email.equals("")){
			    pro.setEmail(email);
			}
			check = service.update(pro);
			
			//if user doesn't update any field
			if (check == false) {
			    errormsg = "<h3>Error Found</h3><br>No Professional User updated";
			    request.setAttribute("errormessage", errormsg);
			    errors.forward(request, response);
			    return;
			}
			
			request.setAttribute("pro", pro);
			request.setAttribute("check", check);
			RequestDispatcher succdis = getServletContext().getRequestDispatcher("/ProfessionalUserUpdateResults.jsp");
			succdis.forward(request, response);
		
		    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			request.setAttribute("errormessage", e.getMessage());
			errors.forward(request, response);
		    }
		
	}

}
