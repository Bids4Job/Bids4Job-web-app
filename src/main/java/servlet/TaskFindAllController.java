package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Task;
import service.TaskService;

/**
 * Servlet implementation class ListServlet
 *
 * @author Dimitris
 */
@WebServlet("/list")
public class TaskFindAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final TaskService mService = new TaskService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskFindAllController() {
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
		List<Task> tasks = mService.findAll();
		if (tasks == null) {
			response.getWriter().append("Error!");
			return;
		}

		request.setAttribute("task_list", tasks);
		getServletContext().getRequestDispatcher("/task_find_all_result.jsp").forward(request, response);

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

	}

}
