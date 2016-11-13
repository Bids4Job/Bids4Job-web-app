package dao;

import domain.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for accessing database data regarding Tasks.
 * 
 * @author Dimitris
 */
public class TaskDao {
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
	 * 
	 * @param taskId
	 * @return an object of Task type, the one that was founded.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Task findOne(int taskId)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Task task = null;
		String query = "SELECT * FROM TASK WHERE TASK_ID = ?";
		prepareResources();
		try {
			connection = DaoUtils.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, taskId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				task = populate(resultSet);
			}

		} finally

		{
			closeResources(resultSet, statement, connection);
		}
		return task;
	}

	/**
	 * 
	 * @return A List of objects type Task, the whole records.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<Task> findAll()
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		List<Task> tasks = new ArrayList<>();
		String query = "SELECT * FROM TASK";
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
			closeResources(resultSet, statement, connection);
		}
		return tasks;
	}

	/**
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
		String query = "INSERT INTO TASK (deadline, work_field, simple_user_id) VALUES (?,?,?)"; // taskId
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
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				task.setTaskId(resultSet.getInt(1));
			}
		} finally {
			closeResources(resultSet, statement, connection);
		}
		return task;
	}

	/**
	 * 
	 * @param task
	 * @return true if the update took place or false if nothing changed.
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	public boolean update(Task task)
			throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		int rowsAffected = 0;
		String query = "UPDATE TASK SET DEADLINE = ?, WORK_FIELD = ?, SIMPLE_USER_ID = ? WHERE TASK_ID = ?";
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
			closeResources(resultSet, statement, connection);
		}
		return false;
	}

	/**
	 * 
	 * @param task
	 * @return true if the task was deleted, else false.
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	public boolean delete(Task task)
			throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		int rowsAffected;
		String query = "DELETE FROM TASK WHERE TASK_ID = ?";
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
			closeResources(resultSet, statement, connection);
		}
		return false;
	}

	/**
	 * Utility method that takes a resultSet and returns a Task object.
	 * 
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	public Task populate(ResultSet resultSet) throws SQLException {
		return new Task().setTaskId(resultSet.getInt("task_id")).setDeadline(resultSet.getTimestamp("deadline"))
				.setWorkField(resultSet.getString("work_field")).setSimpleUserId(resultSet.getInt("simple_user_id"));
	}

	/**
	 * Utility method for closing open database resources.
	 * 
	 * @param resultSet
	 * @param statement
	 * @param connection
	 * @throws SQLException
	 */
	private void closeResources(ResultSet resultSet, PreparedStatement statement, Connection connection)
			throws SQLException {
		// The order for closing the resources is from the last opened inside
		// each method (lifo logic).
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}

}
