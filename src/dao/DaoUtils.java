package dao;

import java.sql.*;


/**
 * 
 * @author Ioannis
 *
 */
public class DaoUtils {
    
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String databaseUrl = "jdbc:mysql://localhost/bids4job_db?useSSL=false";
    private static final String databaseUsername = "root";
    private static final String databasePassword = "@dc@v@j0@";
    
    /**
     * The connection to the bids4job_DB
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (!DriverManager.getDrivers().hasMoreElements()) {
            registerDriver();
        }
        return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
    }
    
    /**
     * Registers the JDBC driver with the DriverManager
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SQLException
     */
    private static void registerDriver() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        DriverManager.registerDriver((Driver) Class.forName(JDBC_DRIVER).newInstance());
    }
    
    /**
     * Utility method for closing open database resources.
     * @param resultSet
     * @param statement
     * @param connection
     * @throws SQLException
     */
    public static void closeResources(ResultSet resultSet, PreparedStatement statement, Connection connection) throws SQLException {
	if (resultSet != null)
		resultSet.close();
	if (statement != null)
		statement.close();
	if (connection != null) 
		connection.close();
    }
	


}
