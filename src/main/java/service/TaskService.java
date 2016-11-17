package service;

import dao.TaskDao;
import domain.Task;

import java.sql.SQLException;
import java.util.List;

/**
 * Service class that executes all required business logic regarding tasks.
 *
 * @author Dimitris.
 */
public class TaskService {

	private final TaskDao dao = new TaskDao();

	/**
	 * Finds specific Task by ID.
	 *
	 * @param taskId
	 * @return The task with the specified ID.
	 */
	public Task findOne(int taskId) {
		try {
			return dao.findOne(taskId);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	/**
	 * Find all existing Tasks in database.
	 *
	 * @return A list of all the Tasks in the database.
	 */
	public List<Task> findAll() {
		try {
			return dao.findAll();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Add a new Task in the database.
	 *
	 * @param task
	 * @return A Task object, the one that was created.
	 */
	public Task create(Task task) {
		try {
			return dao.create(task);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	/**
	 * Updates one or more columns in a Task based on ID.
	 *
	 * @param task
	 * @return True if the update operation was succeeded, else false.
	 *
	 */
	public boolean update(Task task) {
		try {
			return dao.update(task);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Deletes a Task from database, based on ID.
	 *
	 * @param task
	 * @return True if the delete operation was succeeded, else false.
	 */
	public boolean delete(Task task) {
		try {
			return dao.delete(task);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
