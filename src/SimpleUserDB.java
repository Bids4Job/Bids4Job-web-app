import java.sql.Connection;
import java.sql.DriverManager;
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
	private static Connection conn;
	private Statement stmt;
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
}
