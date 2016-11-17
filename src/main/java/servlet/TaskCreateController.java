package servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Task;
import service.TaskService;

/**
 * Servlet implementation class CreateTaskServlet
 *
 * @author Dimitris
 */
@WebServlet("/task_create")
public class TaskCreateController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    TaskService mService = new TaskService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskCreateController() {
        super();
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/task_create.jsp").forward(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fieldOfWork = request.getParameter("fieldOfWork");
        
        String date;
        date = request.getParameter("date");
        Timestamp deadline;
		deadline = Timestamp.valueOf(date + " " + "23:59:59");
        Task task = new Task().setDeadline(deadline).setSimpleUserId(1)
                .setWorkField(fieldOfWork).setDescription("tararararar").setActive_task(1);
        Task task1;
        task1 = mService.create(task);
        request.setAttribute("newTask", task1);
        request.getRequestDispatcher("/task_index.jsp").forward(request, response);
    }
}
