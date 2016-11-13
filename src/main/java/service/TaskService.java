package service;

import dao.TaskDao;
import domain.Task;

import java.sql.SQLException;
import java.util.List;

/**
 * Service class that executes all required business logic regarding bids.
 *
 * @author Dimitris.
 */
public class TaskService {

	private TaskDao dao = new TaskDao();

	/**
	 * Finds specific Task by id.
	 * 
	 * @param taskId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Task findOne(int taskId)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.findOne(taskId);
	}

	/**
	 * Find all existing Tasks in database.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<Task> findAll()
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.findAll();
	}

	/**
	 * Add a new Task in the database.
	 * 
	 * @param task
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Task create(Task task)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.create(task);
	}

	/**
	 * Updates one or more columns in a Task record in database.
	 * 
	 * @param task
	 * @return
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	public boolean update(Task task)
			throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		return dao.update(task);
	}

	/**
	 * Deletes a Task record in database.
	 * 
	 * @param task
	 * @return
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	public boolean delete(Task task)
			throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		return dao.delete(task);
	}

}
