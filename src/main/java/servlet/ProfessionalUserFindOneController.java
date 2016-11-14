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
 * Servlet implementation class FindOneController
 */
@WebServlet("/ProfessionalUserFindOne")
public class ProfessionalUserFindOneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessionalUserFindOneController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    	// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		//define RequestDispatcher object to forward any errors
		RequestDispatcher errors = getServletContext().getRequestDispatcher("/ProfessionalUserErrorPage.jsp");
		
		//Initialization
		ProfessionalUserService service = new ProfessionalUserService();
		int proUserId = 0;
		String errormsg = "";
		//int ercounter = 0;
		
		//Checks if the user type numbers and not characters
		if (request.getParameter("proUserId").matches("[0-9]+")){
		    proUserId = Integer.parseInt(request.getParameter("proUserId"));
		} else {
		    errormsg = "Wrong input. Ids have only numbers, not characters";
		    request.setAttribute("errormessage", errormsg);
		    errors.forward(request, response);
		    return;
		}

		    try {
			
			ProfessionalUser pro = service.findOne(proUserId);
			
			//Check if Professional User Id does not belong to a Professional User.
			if (pro == null){
			    errormsg = "The user with id: " + proUserId + " does not exist.\nPlease try again.";
			    request.setAttribute("errormessage", errormsg);
			    errors.forward(request, response);
			    return;
			}
			
			request.setAttribute("pro", pro);
			RequestDispatcher succdis = getServletContext().getRequestDispatcher("/ProfessionalUserFindOneResults.jsp");
			succdis.forward(request, response);
			
		    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			request.setAttribute("errormessage", e.getMessage());
			errors.forward(request, response);
		    }
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
