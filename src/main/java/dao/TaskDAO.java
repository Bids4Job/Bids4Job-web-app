package dao;

import domain.SimpleUser;
import domain.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

/**
 * Class for accessing database data regarding Tasks.
 *
 * @author Dimitris
 */
public class TaskDAO {

	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;

	/**
	 * Utility method that prepares the connection with database setting
	 * connection, statement and resultSet null.
	 */
	private void prepareResources() {
		this.connection = null;
		this.statement = null;
		this.resultSet = null;
	}

	/**
	 * Finds the task with the given ID.
	 * 
	 * @param taskId
	 * @return An object of Task type, the one that was founded.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Task findOne(int taskId)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Task task = null;
		String query = "SELECT * FROM task WHERE task_id = ?";
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, taskId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				task = populate(resultSet);
			}

		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return task;
	}

	/**
	 * Find all tasks in the database.
	 * 
	 * @return A List of objects type Task, the whole tasks.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<Task> findAll()
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		List<Task> tasks = new ArrayList<>();
		String query = "SELECT * FROM task";
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Task task = populate(resultSet);
				tasks.add(task);
			}
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return tasks;
	}

	/**
	 * Adds a new task in the database.
	 * 
	 * @param task
	 * @return An object of type Task, the one that was created.
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	public Task create(Task task)
			throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		String query = "INSERT INTO task (deadline, work_field, simple_user_ID, description, active_task, title) VALUES (?,?,?,?,?,?)"; // taskId
		// is
		// auto
		// incremented.
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setTimestamp(1, task.getDeadline());
			statement.setString(2, task.getWorkField());
			statement.setInt(3, task.getSimpleUserId());
			statement.setString(4, task.getDescription());
			statement.setInt(5, task.getActive_task());
			statement.setString(6, task.getTitle());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				task.setTaskId(resultSet.getInt(1));
			}
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return task;
	}

	/**
	 * Updates a task in the database based on the given ID.
	 * 
	 * @param task
	 * @return True if the update took place or false if nothing changed.
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	public boolean update(Task task)
			throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		int rowsAffected;
		String query = "UPDATE task SET deadline = ?, work_field = ?, simple_user_ID = ? WHERE task_ID = ?";
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setTimestamp(1, task.getDeadline());
			statement.setString(2, task.getWorkField());
			statement.setInt(3, task.getSimpleUserId());
			statement.setInt(4, task.getTaskId());
			rowsAffected = statement.executeUpdate();
			if (rowsAffected == 1) {
				return true;
			}
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return false;
	}

	/**
	 * Delets a task from database, based on ID.
	 * 
	 * @param task
	 * @return True if the task was deleted, else false.
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	public boolean delete(Task task)
			throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		int rowsAffected;
		String query = "DELETE FROM task WHERE task_ID = ?";
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, task.getTaskId());
			rowsAffected = statement.executeUpdate();
			if (rowsAffected == 1) {
				return true;
			}
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return false;
	}

	/**
	 * Finds tasks based on location, deadline and profession.
	 * 
	 * @param task
	 * @param sm
	 * @return A list of tasks that serve the user's criteria.
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	public List<Task> findByAll(Task task, SimpleUser sm)
			throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		List<Task> tasks = new ArrayList<>();
		String query = "SELECT * FROM task inner join simple_user on simple_user.simple_user_id = task.simple_user_id where location = ? and deadline = ? and work_field = ?";
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, sm.getLocation());
			statement.setString(2, task.getDeadline().toString());
			statement.setString(3, task.getWorkField());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Task task1 = populate(resultSet);
				tasks.add(task1);
			}
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return tasks;
	}

	/**
	 * Finds tasks based on location.
	 * 
	 * @param task
	 * @param sm
	 * @return A list of tasks based on the location the user selects.
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	public List<Task> findByLocation(Task task, SimpleUser sm)
			throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		List<Task> tasks = new ArrayList<>();
		String query = "SELECT * FROM task inner join simple_user on simple_user.simple_user_id = task.simple_user_id where location = ?";
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, sm.getLocation());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Task task1 = populate(resultSet);
				tasks.add(task1);
			}
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return tasks;
	}

	/**
	 * Finds tasks based on profession.
	 * 
	 * @param task
	 * @return A list of tasks based on profession.
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	public List<Task> findByProfession(Task task)
			throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		List<Task> tasks = new ArrayList<>();
		String query = "SELECT * FROM task where work_field = ?";
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, task.getWorkField());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Task task1 = populate(resultSet);
				tasks.add(task1);
			}
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return tasks;
	}

	/**
	 * Finds the tasks that a simple user has posted.
	 * 
	 * @param sm
	 * @return A list of tasks posted by the simple user.
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public List<Task> findByUserId(SimpleUser sm)
			throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		List<Task> tasks = new ArrayList<>();
		String query = "SELECT * FROM task where simple_user_id = ?";
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, sm.getSimpleUserID());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Task task1 = populate(resultSet);
				tasks.add(task1);
			}
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return tasks;

	}

	/**
	 * Finds tasks based on deadline.
	 * 
	 * @param task
	 * @return A list of tasks with specified deadline.
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public List<Task> findByDeadline(Task task)
			throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		List<Task> tasks = new ArrayList<>();
		String query = "SELECT * FROM task where deadline = ?";
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setTimestamp(1, task.getDeadline());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Task task1 = populate(resultSet);
				tasks.add(task1);
			}
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return tasks;

	}

	/**
	 * Finds tasks based on location and profession.
	 * 
	 * @param task
	 * @param sm
	 * @return A list of tasks based on location and profession.
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public List<Task> findByLocationProfession(Task task, SimpleUser sm)
			throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		List<Task> tasks = new ArrayList<>();
		String query = "SELECT * FROM task inner join simple_user on task.simple_user_id = simple_user.simple_user_id where location = ? and work_field = ?";
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, sm.getLocation());
			statement.setString(2, task.getWorkField());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Task task1 = populate(resultSet);
				tasks.add(task1);
			}
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return tasks;
	}

	/**
	 * Finds tasks based on location and deadline.
	 * 
	 * @param task
	 * @param sm
	 * @return A list of tasks based on location and deadline.
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public List<Task> findByLocationDeadline(Task task, SimpleUser sm)
			throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		List<Task> tasks = new ArrayList<>();
		String query = "SELECT * FROM task inner join simple_user on task.simple_user_id = simple_user.simple_user_id where location = ? and deadline = ?";
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, sm.getLocation());
			statement.setTimestamp(2, task.getDeadline());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Task task1 = populate(resultSet);
				tasks.add(task1);
			}
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return tasks;
	}

	/**
	 * Finds tasks based on profession and deadline.
	 * 
	 * @param task
	 * @return A list of tasks based on profession and deadline.
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public List<Task> findByProfessionDeadline(Task task)
			throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		List<Task> tasks = new ArrayList<>();
		String query = "SELECT * FROM task where work_field = ? and deadline = ?";
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, task.getWorkField());
			statement.setTimestamp(2, task.getDeadline());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Task task1 = populate(resultSet);
				tasks.add(task1);
			}
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return tasks;
	}

	/**
	 * Finds the ten last active tasks created and their bids.
	 * 
	 * @author Dimitris
	 * @return A CachedRowSet with the 10 last active tasks that were created.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public CachedRowSet findTenTasks()
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		CachedRowSet crs = new CachedRowSetImpl();
		String sql1 = "DROP VIEW IF EXISTS l;";
		String sql2 = "create view l as " + "SELECT a.task_id, a.bid_id, a.amount, a.bid_time, b.username, e.rating "
				+ "FROM " + "bid AS a " + "INNER JOIN " + "pro_user AS b ON a.pro_user_id = b.pro_user_id "
				+ "INNER JOIN " + "task AS c ON a.task_id = c.task_id " + "INNER JOIN " + "(SELECT "
				+ "f.pro_user_id, AVG(g.rating) AS rating " + "FROM " + "contract AS g "
				+ "INNER JOIN bid AS f ON g.bid_id = f.bid_id "
				+ "GROUP BY f.pro_user_id) AS e ON e.pro_user_id = b.pro_user_id;";
		String sql3 = "SELECT " + "* " + "FROM " + "l " + "INNER JOIN " + "(SELECT " + "task_id " + "FROM " + "task "
				+ "WHERE " + "task.active_task = TRUE " + "ORDER BY task.task_id DESC "
				+ "LIMIT 10) AS k ON k.task_id = l.task_id;";
		this.prepareResources();
		try {
			connection = DaoUtils.getConnection();
			PreparedStatement statement1 = null;
			PreparedStatement statement2 = null;
			statement1 = connection.prepareStatement(sql1);
			statement2 = connection.prepareStatement(sql2);
			statement = connection.prepareStatement(sql3);
			if (!statement1.execute() && !statement2.execute()) {
				resultSet = statement.executeQuery();
				crs.populate(resultSet);
			}

		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return crs;
	}

	/**
	 * Finds all Tasks(and their Bids) in the database from a specified Simple
	 * User. (taks_id, bid_id, pro_username, amount, rating, bid_time)
	 *
	 * @return a CachedRowSet with all Tasks(in detail) based on simple user ID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public CachedRowSet findDetailsBySimpleUserID(int simpleUserID)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		CachedRowSet crs = new CachedRowSetImpl();
		String sql = "select c.task_id, a.bid_id, a.amount, a.bid_time, b.username, e.rating from bid as a inner join pro_user as b on a.pro_user_id = b.pro_user_id right outer join task as c on a.task_id = c.task_id inner join simple_user as d on c.simple_user_id = d.simple_user_id left outer join (select f.pro_user_id, avg(g.rating) as rating from contract as g inner join bid as f on g.bid_id = f.bid_id group by f.pro_user_id) as e on e.pro_user_id = b.pro_user_id where c.active_task = true and d.simple_user_id = ? order by c.task_id desc;";
		this.prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, simpleUserID);
			resultSet = statement.executeQuery();
			crs.populate(resultSet);
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return crs;
	}

	/**
	 * Finds all Tasks(and their Bids) in the database from a specified Simple
	 * User. (taks_id, bid_id, pro_username, amount, rating, bid_time)
	 *
	 * @return a CachedRowSet with all Tasks(in detail) based on simple user ID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public CachedRowSet findDetailsByProfessionalUserID(int proUserId)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		CachedRowSet crs = new CachedRowSetImpl();
		String sql = "select c.task_id, a.bid_id, a.amount, a.bid_time, b.username, e.rating from bid as a inner join pro_user as b on a.pro_user_id = b.pro_user_id inner join (select distinct z.task_id, z.active_task, z.simple_user_id	from task as z inner join bid as y on z.task_id = y.task_id inner join pro_user as w on y.pro_user_id = w.pro_user_id where w.pro_user_id = ?) as c on a.task_id = c.task_id inner join simple_user as d on c.simple_user_id = d.simple_user_id left outer join (select f.pro_user_id, avg(g.rating) as rating from contract as g inner join bid as f on g.bid_id = f.bid_id group by f.pro_user_id) as e on e.pro_user_id = b.pro_user_id where c.active_task = true order by c.task_id desc;";
		this.prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, proUserId);
			resultSet = statement.executeQuery();
			crs.populate(resultSet);
		} finally {
			DaoUtils.closeResources(resultSet, statement, connection);
		}
		return crs;
	}

	/**
	 * Utility method that takes a resultSet and returns a Task object.
	 *
	 * @param resultSet
	 * @return A task object.
	 */
	public Task populate(ResultSet resultSet) {
		try {

			return new Task().setTitle(resultSet.getString("title")).setTaskId(resultSet.getInt("task_ID"))
					.setDeadline(resultSet.getTimestamp("deadline")).setWorkField(resultSet.getString("work_field"))
					.setSimpleUserId(resultSet.getInt("simple_user_ID"))
					.setDescription(resultSet.getString("description")).setActive_task(resultSet.getInt("active_task"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
