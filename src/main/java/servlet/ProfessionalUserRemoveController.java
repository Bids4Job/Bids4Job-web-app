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
 * Servlet implementation class RemoveController
 */
@WebServlet("/ProfessionalUserRemove")
public class ProfessionalUserRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessionalUserRemoveController() {
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
		
		//initialization
		ProfessionalUserService service = new ProfessionalUserService();
		String errormsg = "";
		boolean check = true;
		int proUserId = 0;
		
		 try {
			
			//Checks if the user type numbers and not characters
			if (request.getParameter("proUserId").matches("[0-9]+")){
			    proUserId = Integer.parseInt(request.getParameter("proUserId"));
			} else {
			    errormsg = "Wrong input. Ids have only numbers, not characters";
			    request.setAttribute("errormessage", errormsg);
			    errors.forward(request, response);
			    return;
			}
			    
			ProfessionalUser pro = service.findOne(proUserId);
			
			//Check if Professional User Id does not belong to a Professional User.
			if (pro == null){
			    errormsg = "The user with id: " + proUserId + " does not exist.\nPlease try again.";
			    request.setAttribute("errormessage", errormsg);
			    errors.forward(request, response);
			    return;
			}
			
			check = service.remove(pro);
			
			//if user doesn't update any field
			if (check == false) {
			    errormsg = "<h3>Error Found</h3><br>No Professional User removed";
			    request.setAttribute("errormessage", errormsg);
			    errors.forward(request, response);
			    return;
			}
			
			request.setAttribute("pro", pro);
			request.setAttribute("check", check);  
			RequestDispatcher succdis = getServletContext().getRequestDispatcher("/ProfessionalUserRemoveResults.jsp");
			succdis.forward(request, response);
			
		    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			request.setAttribute("errormessage", e.getMessage());
			errors.forward(request, response);
		    }
		
	}

}
