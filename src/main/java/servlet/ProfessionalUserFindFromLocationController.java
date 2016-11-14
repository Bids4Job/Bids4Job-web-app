package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProfessionalUser;
import service.ProfessionalUserService;

/**
 * Servlet implementation class FindFromLocationController
 */
@WebServlet("/ProfessionalUserFindFromLocation")
public class ProfessionalUserFindFromLocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessionalUserFindFromLocationController() {
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
		
		ProfessionalUserService service = new ProfessionalUserService();
		String location = null;
		String errormsg = "";
		//int ercounter = 0;
		
		//Get the location from user's input
		    location = request.getParameter("location");
		    List<ProfessionalUser> users = null;
		    
		    try {
			
			users = service.findFromLocation(location);
			
			//Check if Professional User Location does not exist.
			if (users.isEmpty()) {
			    errormsg = "The location: " + location + " does not exist.\nPlease try again.";
			    request.setAttribute("errormessage", errormsg);
			    errors.forward(request, response);
			    return;
			}
			
			request.setAttribute("location", location);
			request.setAttribute("users", users);
			RequestDispatcher succdis = getServletContext().getRequestDispatcher("/ProfessionalUserFindFromLocationResults.jsp");
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
