package service;

import dao.DaoUtils;
import dao.TaskDAO;
import domain.Task;

import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

/**
 * Service class that executes all required business logic regarding tasks.
 *
 * @author Dimitris.
 */
public class TaskService {

	private final TaskDAO dao = new TaskDAO();

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

	/**
	 * Finds the last ten active tasks that were created.
	 * 
	 * @author Dimitris
	 * @return a CacheRowSet with the last ten active tasks created.
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 */
	public CachedRowSet findTenTasks()
			throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
		return dao.findTenTasks();
	}

	/**
	 * Finds all Tasks(and their Bids) in the database from a specified Simple
	 * User. (taks_id, bid_id, pro_username, amount, rating, bid_time)
	 *
	 * @author george
	 * @return a CachedRowSet with all Tasks(in detail) based on simple user ID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public CachedRowSet findDetailsBySimpleUserID(int simpleUserID)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.findDetailsBySimpleUserID(simpleUserID);
	}

	/**
	 * Finds all Tasks(and their Bids) in the database based on ProfessionalUser
	 * bids. (taks_id, bid_id, pro_username, amount, rating, bid_time)
	 *
	 * @return a CachedRowSet with all Tasks(in detail) based on simple user ID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public CachedRowSet findDetailsByProfessionalUserID(int proUserId)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.findDetailsByProfessionalUserID(proUserId);
	}

	/**
	 * Finds all Tasks(title, description, workfield, location, deadline,
	 * bidders, ratings, amount, bid dates) in the database from a specified
	 * profession
	 *
	 * @return all Tasks(full detailed) based on a profession
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public CachedRowSet findDetailsByProfession(String profession)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.findDetailsByProfession(profession);
	}

	/**
	 * Finds all Tasks(and their Bids) in the database starting from the latest
	 * deadline. (taks_id, bid_id, pro_username, amount, rating, bid_time)
	 * 
	 * @param limit
	 *            the number of Tasks to be shown
	 * @return a CachedRowSet with all Tasks(in detail) based on latest
	 *         deadlines
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public CachedRowSet findDetailsByDeadlineDesc(int limit)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.findDetailsByDeadlineDesc(limit);
	}

}
