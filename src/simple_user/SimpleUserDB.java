package simple_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleUserDB {

	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/bids4job_db?useSSL=false";

	// Database credentials
	private static final String USER = "root";
	private static final String PASS = "pass";

	// Necessary fields to connect to DB, execute queries and store the result
	// sets.
	private static final String SIMPLE_USER_TABLE = "Simple_User";
	private static Connection conn;
	private Statement stmt;
	private PreparedStatement preStmt;
	private ResultSet rs;

	public SimpleUserDB() {

	}

	public void openConnection() {
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);
			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("Check if MySQL Connector/J driver exists." + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Wrong credentials or database url: " + e.getMessage());
		} finally {
			System.out.println("Connection established!");
		}
	}

	public void closeConnection() {
		System.out.println("Closing connection...");
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		System.out.println("Resources were closed!");
	}

	public boolean insertSimpleUser(SimpleUser simpleUser) {
		this.openConnection();
		try {
			String sql = "INSERT INTO " + SIMPLE_USER_TABLE + " (`first_name`, `last_name`, `location`) " + "VALUES"
					+ "('" + simpleUser.getFirstName() + "', '" + simpleUser.getLastName() + "', '"
					+ simpleUser.getLocation() + "')";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		} finally {
			this.closeConnection();
		}
		return true;
	}

	public boolean deleteSimpleUser(SimpleUser simpleUser) {
		this.openConnection();
		try {
			String sql = "DELETE FROM " + SIMPLE_USER_TABLE + " WHERE `simple_user_ID` = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, simpleUser.getSimpleUserID());
			preStmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		} finally {
			this.closeConnection();
		}
		return true;
	}

	public int getHighestID() {
		int highestID = 0;
		this.openConnection();
		try {
			String sql = "SELECT " + SIMPLE_USER_TABLE + ".`simple_user_ID` FROM " + SIMPLE_USER_TABLE + " ORDER BY "
					+ SIMPLE_USER_TABLE + ".`simple_user_ID` DESC LIMIT 1;";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				highestID = rs.getInt("simple_user_ID");
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return highestID;
	}
}
