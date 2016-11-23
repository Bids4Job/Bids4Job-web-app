package controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.SimpleUser;
import domain.Task;
import service.TaskService;

/**
 * Servlet implementation class TaskCreateBySimpleUserController
 * 
 * @author Dimitris
 */
@WebServlet(name = "TaskCreateBySimpleUserController", urlPatterns = { "/create_task" })
public class CreateTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TaskService mService = new TaskService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTaskController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/suserprofile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String task_title = request.getParameter("task_title");
		String date = request.getParameter("date");
		String task_description = request.getParameter("task_description");
		String profession = request.getParameter("profession");
		int simpleUserId = ((SimpleUser) request.getSession().getAttribute("simple-user")).getSimpleUserID();
		Timestamp deadline;
		deadline = Timestamp.valueOf(date + " " + "23:59:59");
		Task task = new Task().setTitle(task_title).setDeadline(deadline).setSimpleUserId(simpleUserId)
				.setWorkField(profession).setDescription(task_description).setActive_task(1);
		Task task1;
		task1 = mService.create(task);
		response.sendRedirect("profile_simple");
	}

}
