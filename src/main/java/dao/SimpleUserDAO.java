package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.SimpleUser;

/**
 * Class for accessing database data regarding SimpleUsers.
 * 
 * @author george
 *
 */
public class SimpleUserDAO {

	// Necessary fields to connect to DB, execute queries and store the result
	// sets.
	private static final String SIMPLE_USER_TABLE = "simple_user";
	private static final String SIMPLE_USER_ID = "simple_user_ID";
	private static final String FIRST_NAME = "first_name";
	private static final String LAST_NAME = "last_name";
	private static final String LOCATION = "location";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String EMAIL = "email";
	private static final String ACTIVE_ACCOUNT = "active_account";
	private static final String PHOTO_NAME = "simple_photo";
	private Connection conn;
	private PreparedStatement preStmt;
	private ResultSet rs;

	public SimpleUserDAO() {
	}

	/**
	 * Sets the connection, the preparedStatement and the resultSet to null.
	 */
	private void prepareResources() {
		this.conn = null;
		this.preStmt = null;
		this.rs = null;
	}

	// CRUD operations
	/**
	 * Finds the Simple User with the given ID.
	 * 
	 * @param simpleUserID
	 * @return The SimpleUser with the specified ID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public SimpleUser findOne(int simpleUserID)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		SimpleUser simpleUser = null;
		String sql = "SELECT * FROM " + SIMPLE_USER_TABLE + " WHERE " + SIMPLE_USER_ID + " = ?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, simpleUserID);
			rs = preStmt.executeQuery();
			if (rs.next()) {
				simpleUser = SimpleUserDAO.populate(rs);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return simpleUser;
	}

	/**
	 * Finds all existing Simple Users in the database.
	 *
	 * @return A list with all SimpleUsers
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<SimpleUser> findAll()
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		List<SimpleUser> simpleUsers = new ArrayList<>();
		String sql = "SELECT * FROM " + SIMPLE_USER_TABLE + ";";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				SimpleUser simpleUser = SimpleUserDAO.populate(rs);
				simpleUsers.add(simpleUser);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return simpleUsers;
	}

	/**
	 * Adds a new Simple User in the database.
	 * 
	 * @param simpleUser
	 * @return The SimpleUser object that was added in database
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public SimpleUser create(SimpleUser simpleUser)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		String sql = "INSERT INTO " + SIMPLE_USER_TABLE + "(" + FIRST_NAME + ", " + LAST_NAME + ", " + LOCATION + ", "
				+ USERNAME + ", " + PASSWORD + ", " + EMAIL + ", " + ACTIVE_ACCOUNT + ", " + PHOTO_NAME
				+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preStmt.setString(1, simpleUser.getFirstName());
			preStmt.setString(2, simpleUser.getLastName());
			preStmt.setString(3, simpleUser.getLocation());
			preStmt.setString(4, simpleUser.getUsername());
			preStmt.setString(5, simpleUser.getPassword());
			preStmt.setString(6, simpleUser.getEmail());
			preStmt.setBoolean(7, simpleUser.getActiveAccount());
			preStmt.setString(8, simpleUser.getPhotoName());
			preStmt.executeUpdate();
			rs = preStmt.getGeneratedKeys();
			if (rs.next()) {
				simpleUser.setSimpleUserID(rs.getInt(1));
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return simpleUser;
	}

	/**
	 * Updates a Simple User in database based on ID.
	 * 
	 * @param simpleUser
	 * @return True if the update operation was succeeded, else false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public boolean update(SimpleUser simpleUser)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		int rowsAffected = 0;
		String sql = "UPDATE " + SIMPLE_USER_TABLE + " SET " + FIRST_NAME + "=?, " + LAST_NAME + "=?, " + LOCATION
				+ "=?," + USERNAME + "=?, " + PASSWORD + "=?, " + EMAIL + "=?, " + ACTIVE_ACCOUNT + "=? WHERE "
				+ SIMPLE_USER_ID + "=?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, simpleUser.getFirstName());
			preStmt.setString(2, simpleUser.getLastName());
			preStmt.setString(3, simpleUser.getLocation());
			preStmt.setString(4, simpleUser.getUsername());
			preStmt.setString(5, simpleUser.getPassword());
			preStmt.setString(6, simpleUser.getEmail());
			preStmt.setBoolean(7, simpleUser.getActiveAccount());
			preStmt.setInt(8, simpleUser.getSimpleUserID());
			rowsAffected = preStmt.executeUpdate();
			if (rowsAffected == 1) {
				return true;
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return false;
	}

	/**
	 * Deletes a SimpleUser from database based on ID.
	 * 
	 * @param simpleUser
	 * @return True if the delete operation was succeeded, else false
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean delete(SimpleUser simpleUser)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		int rowsAffected = 0;
		String sql = "DELETE FROM " + SIMPLE_USER_TABLE + " WHERE " + SIMPLE_USER_ID + "=?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, simpleUser.getSimpleUserID());
			rowsAffected = preStmt.executeUpdate();
			if (rowsAffected == 1) {
				return true;
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return false;
	}

	/**
	 * Finds Simple Users based on given location.
	 * 
	 * @param location
	 * @return A list with SimpleUsers from the specified location
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<SimpleUser> findByLocation(String location)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		List<SimpleUser> simpleUsers = new ArrayList<>();
		String sql = "SELECT * FROM " + SIMPLE_USER_TABLE + " WHERE " + LOCATION + "=?;";
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, location);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				SimpleUser simpleUser = SimpleUserDAO.populate(rs);
				simpleUsers.add(simpleUser);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return simpleUsers;
	}

	/**
	 * Finds Simple Users that have unsigned Task.
	 * 
	 * @param location
	 * @return A list with SimpleUsers that have at least one unsigned Task
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<SimpleUser> findWithUnsignedTask()
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		List<SimpleUser> simpleUsers = new ArrayList<>();
		String sql = "SELECT * FROM " + SIMPLE_USER_TABLE + " INNER JOIN task ON " + SIMPLE_USER_TABLE + "."
				+ SIMPLE_USER_ID
				+ " = task.simple_user_ID WHERE task.task_ID NOT IN (SELECT contract.task_ID FROM contract);";
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				SimpleUser simpleUser = SimpleUserDAO.populate(rs);
				simpleUsers.add(simpleUser);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return simpleUsers;
	}

	/**
	 * Finds Simple Users based on given account status.
	 * 
	 * @param active_account
	 *            Represents if the account is active or not
	 * @return A List of SimpleUsers that have the specified account status
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<SimpleUser> findByActiveAccount(boolean active_account)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		List<SimpleUser> simpleUsers = new ArrayList<>();
		String sql = "SELECT * FROM " + SIMPLE_USER_TABLE + " WHERE " + ACTIVE_ACCOUNT + "=?;";
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setBoolean(1, active_account);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				SimpleUser simpleUser = SimpleUserDAO.populate(rs);
				simpleUsers.add(simpleUser);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return simpleUsers;
	}

	/**
	 * Finds the Simple User with the given email and password.
	 * 
	 * @param email
	 *            the email of the user
	 * @param password
	 *            the password of the user
	 * @return The SimpleUser with the specified ID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public SimpleUser findByEmailPassword(String email, String password)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		SimpleUser simpleUser = null;
		String sql = "SELECT * FROM " + SIMPLE_USER_TABLE + " WHERE " + EMAIL + " =? AND " + PASSWORD + "=?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, email);
			preStmt.setString(2, password);
			rs = preStmt.executeQuery();
			if (rs.next()) {
				simpleUser = SimpleUserDAO.populate(rs);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return simpleUser;
	}

	/**
	 * Checks if username or email already exists.
	 * 
	 * @param name
	 * @param value
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean exist(String name, String value)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {

		String query = "SELECT * FROM " + SIMPLE_USER_TABLE + " WHERE " + name + " =?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(query);
			preStmt.setString(1, value);
			rs = preStmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}

	}

	/**
	 * Utility method that takes a result set and returns a SimpleUser object.
	 *
	 * @param resultSet
	 * @return A SimpleUser object
	 * @throws SQLException
	 */
	private static SimpleUser populate(ResultSet resultSet) throws SQLException {
		return new SimpleUser().setSimpleUserID(resultSet.getInt(SIMPLE_USER_ID))
				.setFirstName(resultSet.getString(FIRST_NAME)).setLastName(resultSet.getString(LAST_NAME))
				.setLocation(resultSet.getString(LOCATION)).setUsername(resultSet.getString(USERNAME))
				.setPassword(resultSet.getString(PASSWORD)).setEmail(resultSet.getString(EMAIL))
				.setActiveAccount(resultSet.getBoolean(ACTIVE_ACCOUNT)).setPhotoName(resultSet.getString(PHOTO_NAME));
	}
}
