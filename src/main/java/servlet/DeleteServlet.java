package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Task;
import service.TaskService;

/**
 * Servlet implementation class DeleteServlet
 *
 * @author Dimitris
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TaskService mService = new TaskService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
	}

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/delete.jsp").forward(request, response);
	}

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("deleteId"));
		Task task = mService.findOne(id);
		// Check if the requested Task does not exists.
		if (task == null) {
			String msg = "This Task does not exist. Please try again!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}
		if (mService.delete(task)) {
			response.sendRedirect("index");
		} else {
			response.getWriter()
					.append("You cannot delete this Task because the primary key of this Task is a foreign key in other tables"
							+ " and we have not decide yet what to do in the team project in case of delete!"
							+ "This personal project, the manipulation of Tasks is part of a team project, as it is declared in the project description file in github!"
							+ " Thank you for your understanding!");
		}
	}
}
