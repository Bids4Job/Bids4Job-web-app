package dao;

<<<<<<< HEAD
import java.sql.*;


/**
 * 
 * @author Ioannis
 *
 */
public class DaoUtils {
    
    private static final String databaseUrl = "jdbc:mysql://localhost/bids4job_db?useSSL=false";
    private static final String databaseUsername = "root";
    private static final String databasePassword = "@dc@v@j0@";
    
    public static Connection getConnection() throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (!DriverManager.getDrivers().hasMoreElements()) {
            registerDriver();
        }
        return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
    }
    
    private static void registerDriver() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
    }

=======
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class used for retrieving database connection
 * 
 * @author Dimitris
 */
public class DaoUtils {
	private static final String databaseUrl = "jdbc:mysql://localhost/bids4job_db?useSSL=false";
	private static final String databaseUsername = "root";
	private static final String databasePassword = "xxxxx";

	public static Connection getConnection()
			throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		if (!DriverManager.getDrivers().hasMoreElements()) {
			registerDriver();
		}
		return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
	}

	public static void registerDriver()
			throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
		DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
	}
>>>>>>> dimitris
}
