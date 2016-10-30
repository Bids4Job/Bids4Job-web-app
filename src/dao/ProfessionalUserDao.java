package dao;

import domain.ProfessionalUser;
import java.sql.*;
import java.util.*;

/**
 * 
 * @author Ioannis
 *
 */
public class ProfessionalUserDao {
    
    
    
    public void update (ProfessionalUser professionalUser) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	String query = "UPDATE pro_user SET first_name = ?, last_name = ?, location = ?, profession = ? WHERE pro_user_ID =?";
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setString(1, professionalUser.getFisrtName());
	    statement.setString(2, professionalUser.getLastName());
	    statement.setString(3, professionalUser.getLocation());
	    statement.setString(4, professionalUser.getProfession());
	    statement.setInt(5, professionalUser.getProUserId());
	    int affectedRows = statement.executeUpdate();
	    if (affectedRows == 0){
		System.out.println("Professional User: " + professionalUser.getProUserId()+ " not updated");
	    }
	} finally {
	    closeResources(resultSet, statement, connection);
	}
    }
    
    
    /**
     * Remove a specific Professional User fro proUserid
     * @param proUserid
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public void remove(int proUserid) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	String query = "DELETE FROM pro_user WHERE pro_user_ID = ?";
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setInt(1, proUserid);
	    int affectedRows = statement.executeUpdate();
	    if (affectedRows == 0){
		System.out.println("Professional User: " + proUserid + " not found");
	    }
	} finally {
	    closeResources(resultSet, statement, connection);
	}
    }
    
            
    /**
     * Add a new Professional User in the bids4job_DB
     * @param professionalUser
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public ProfessionalUser create(ProfessionalUser professionalUser) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	String query = "INSERT INTO pro_user (first_name, last_name, location, profession) VALUES (?, ?, ?, ?)";
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
	    statement.setString(1, professionalUser.getFisrtName());
	    statement.setString(2, professionalUser.getLastName());
	    statement.setString(3, professionalUser.getLocation());
	    statement.setString(4, professionalUser.getProfession());
	    statement.executeUpdate();
	    resultSet = statement.getGeneratedKeys();
	    if (resultSet.next()) {
		professionalUser.setProUSerId(resultSet.getInt(1));
	    }
	} finally {
	    closeResources(resultSet, statement, connection);
	}
	return professionalUser;
    }
    
    
    /**
     * Find a specific Professional User from location
     * @param location
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public List<ProfessionalUser> findFromLocation(String location) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	List<ProfessionalUser> professionalUsers = new ArrayList<>();
	String query = "SELECT * FROM pro_user WHERE location = ?";
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setString(1, location);
	    resultSet = statement.executeQuery();
	    while (resultSet.next()){
		ProfessionalUser professionalUser = populate(resultSet);
		professionalUsers.add(professionalUser);
	    }
	} finally {
	    closeResources(resultSet, statement, connection);
	}
	return professionalUsers;
    }
    
    
    /**
     * Find specific Professional User from Professional User ID
     * @param proUserid
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public ProfessionalUser findOne(int proUserid) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	ProfessionalUser professionalUser = null;
	String query = "SELECT * FROM pro_user WHERE pro_user_ID = ?";
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setInt(1, proUserid);
	    resultSet = statement.executeQuery();
	    if (resultSet.next()){
		professionalUser = populate(resultSet);
	    }
	} finally {
	    closeResources(resultSet, statement, connection);
	}
	return professionalUser;
    }
    
    
    /**
     * Find all Professional Users in the bids4job_DB
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public List<ProfessionalUser> fiandAll() throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	 List<ProfessionalUser> professionalUsers = new ArrayList<>();
	 String query = "SELECT * FROM pro_user";
	 Connection connection = null;
	 PreparedStatement statement = null;
	 ResultSet resultSet = null;
	 try {
	     connection = DaoUtils.getConnection();
	     statement = connection.prepareStatement(query);
	     resultSet = statement.executeQuery();
	     while (resultSet.next()) {
		 ProfessionalUser professionalUser = populate(resultSet);
		 professionalUsers.add(professionalUser);
	     }
	 } finally {
	     closeResources(resultSet, statement, connection);
	 }
	 return professionalUsers;
    }
        
              
    /**
     * Utility method that takes a result set and returns a ProfessionalUser object.
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private ProfessionalUser populate(ResultSet resultSet) throws SQLException {
	return new ProfessionalUser()
		.setProUSerId(resultSet.getInt("pro_user_ID"))
		.setFirstName(resultSet.getString("first_name"))
		.setLastName(resultSet.getString("last_name"))
		.setLocation(resultSet.getString("location"))
		.setProfession(resultSet.getString("profession"));
    }
    
    
    /**
     *  Utility method for closing open database resources.
     * @param resultSet
     * @param statement
     * @param connection
     * @throws SQLException
     */
    private void closeResources(ResultSet resultSet, PreparedStatement statement, Connection connection) throws SQLException {
	if (resultSet != null) resultSet.close();
	if (statement != null) statement.close();
	if (connection != null) connection.close();
    }

    
}
