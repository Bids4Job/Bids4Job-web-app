package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Utility class used to open and close database connection.
 * 
 * @author george
 *
 */
public class DaoUtils {

	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/bids4job_db?useSSL=false";

	// Database credentials
	private static final String USER = "root";
	private static final String PASS = "pass";

	/**
	 * Attempts to establish a connection to the database.
	 * 
	 * @return A connection to the DB_URL
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection()
			throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		if (!DriverManager.getDrivers().hasMoreElements()) {
			registerDriver();
		}
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}

	/**
	 * Registers the JDBC driver with the DriverManager.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SQLException
	 */
	private static void registerDriver()
			throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
		DriverManager.registerDriver((Driver) Class.forName(JDBC_DRIVER).newInstance());
	}

	/**
	 * Utility method for closing open database resources.
	 *
	 * @param resultSet
	 * @param statement
	 * @param connection
	 * @throws SQLException
	 */
	public static void closeResources(ResultSet resultSet, PreparedStatement statement, Connection connection)
			throws SQLException {
		// Close resources with the opposite turn that they were opened.
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null) {
			connection.close();
		}
	}
}
