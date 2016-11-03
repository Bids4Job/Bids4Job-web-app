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
    
    private static final String PROFFESIONAL_USER_TABLE = "pro_user";
    private static final String PRO_USER_ID = "pro_user_ID";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String LOCATION = "location";
    private static final String PROFESSION = "profession";
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    
    /**
     * Sets the connection, the preparedStatement and the resultSet to null.
     */
    private void prepareResources() {
	this.connection = null;
	this.statement = null;
	this.resultSet = null;
    }
    
    
    /**
     * Update a specific Professional User
     * @param professionalUser
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public boolean update (ProfessionalUser professionalUser) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	String query = "UPDATE " + PROFFESIONAL_USER_TABLE + " SET " + FIRST_NAME +  "= ?, " + LAST_NAME + "= ?, " + LOCATION + "= ?, " + PROFESSION + "= ? WHERE " + PRO_USER_ID +  "=?";
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setString(1, professionalUser.getFisrtName());
	    statement.setString(2, professionalUser.getLastName());
	    statement.setString(3, professionalUser.getLocation());
	    statement.setString(4, professionalUser.getProfession());
	    statement.setInt(5, professionalUser.getProUserId());
	    int affectedRows = statement.executeUpdate();
	    if (affectedRows == 1){
		return true;
	    }
	} finally {
	    DaoUtils.closeResources(resultSet, statement, connection);
	}
	return false;
    }
    
    
    /**
     * Remove a specific Professional User
     * @param proUserid
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public boolean remove(ProfessionalUser professionalUser) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	String query = "DELETE FROM " + PROFFESIONAL_USER_TABLE + " WHERE " + PRO_USER_ID + " = ?";
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setInt(1, professionalUser.getProUserId());
	    int affectedRows = statement.executeUpdate();
	    if (affectedRows == 1){
		return true;
	    }
	} finally {
	    DaoUtils.closeResources(resultSet, statement, connection);
	}
	return false;
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
	String query = "INSERT INTO " + PROFFESIONAL_USER_TABLE + "(" + FIRST_NAME + ", " + LAST_NAME + ", " + LOCATION + ", " + PROFESSION + ") VALUES (?, ?, ?, ?)";
	this.prepareResources();;
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
	    DaoUtils.closeResources(resultSet, statement, connection);
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
	String query = "SELECT * FROM " + PROFFESIONAL_USER_TABLE + " WHERE " + LOCATION + " = ?";
	this.prepareResources();
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
	    DaoUtils.closeResources(resultSet, statement, connection);
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
	String query = "SELECT * FROM " + PROFFESIONAL_USER_TABLE + " WHERE " + PRO_USER_ID + " = ?";
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setInt(1, proUserid);
	    resultSet = statement.executeQuery();
	    if (resultSet.next()){
		professionalUser = populate(resultSet);
	    }
	} finally {
	    DaoUtils.closeResources(resultSet, statement, connection);
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
	 String query = "SELECT * FROM " + PROFFESIONAL_USER_TABLE;
	 this.prepareResources();
	 try {
	     connection = DaoUtils.getConnection();
	     statement = connection.prepareStatement(query);
	     resultSet = statement.executeQuery();
	     while (resultSet.next()) {
		 ProfessionalUser professionalUser = populate(resultSet);
		 professionalUsers.add(professionalUser);
	     }
	 } finally {
	     DaoUtils.closeResources(resultSet, statement, connection);
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
    
}
