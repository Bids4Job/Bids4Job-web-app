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
    
    public static final String PROFFESIONAL_USER_TABLE = "pro_user";
    public static final String PRO_USER_ID = "pro_user_ID";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String LOCATION = "location";
    public static final String PROFESSION = "profession";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String ACTIVE = "active_account";
    public static final String PHOTO_NAME = "pro_photo";
    
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
	String query = "UPDATE " + PROFFESIONAL_USER_TABLE + " SET " + FIRST_NAME +  "= ?, " + LAST_NAME + "= ?, " + LOCATION + "= ?, " + PROFESSION + "= ?, " + USERNAME + "= ?, " + PASSWORD + "= ?, " + EMAIL + "= ?, " + ACTIVE + "= ? WHERE " + PRO_USER_ID +  "=?";
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setString(1, professionalUser.getFirstName());
	    statement.setString(2, professionalUser.getLastName());
	    statement.setString(3, professionalUser.getLocation());
	    statement.setString(4, professionalUser.getProfession());
	    statement.setString(5, professionalUser.getUsername());
	    statement.setString(6, professionalUser.getPassword());
	    statement.setString(7, professionalUser.getEmail());
	    statement.setBoolean(8, professionalUser.getActive());
	    statement.setInt(9, professionalUser.getProUserId());
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
	String query = "INSERT INTO " + PROFFESIONAL_USER_TABLE + "(" + FIRST_NAME + ", " + LAST_NAME + ", " + LOCATION + ", " + PROFESSION + ", " + USERNAME + ", " + PASSWORD + ", " + EMAIL + ", " + ACTIVE + ", " + PHOTO_NAME + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	this.prepareResources();;
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
	    statement.setString(1, professionalUser.getFirstName());
	    statement.setString(2, professionalUser.getLastName());
	    statement.setString(3, professionalUser.getLocation());
	    statement.setString(4, professionalUser.getProfession());
	    statement.setString(5, professionalUser.getUsername());
	    statement.setString(6, professionalUser.getPassword());
	    statement.setString(7, professionalUser.getEmail());
	    statement.setBoolean(8, professionalUser.getActive());
	    statement.setString(9, professionalUser.getPhotoName());
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
     * Find all active Professional Users
     * @param active
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public List<ProfessionalUser> findActive(boolean active)  throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	List<ProfessionalUser> activeProfessionalUsers = new ArrayList<>();
	String query = "SELECT * FROM " + PROFFESIONAL_USER_TABLE + " WHERE " + ACTIVE + " = ?";
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setBoolean(1, active);
	    resultSet = statement.executeQuery();
	    while (resultSet.next()){
		ProfessionalUser professionalUser = populate(resultSet);
		activeProfessionalUsers.add(professionalUser);
	    }
	} finally {
	    DaoUtils.closeResources(resultSet, statement, connection);
	}
	return activeProfessionalUsers;
	
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
    
    public ProfessionalUser findByEmailPassword(String email, String password) throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
	
	ProfessionalUser pro = null;
	String query = "SELECT * FROM " + PROFFESIONAL_USER_TABLE + " WHERE " + EMAIL + " =? AND " + PASSWORD + "=?;";
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setString(1, email);
	    statement.setString(2, password);
	    resultSet = statement.executeQuery();
	    if (resultSet.next()) {
		pro = populate(resultSet);
	    }
	    
	} finally {
		DaoUtils.closeResources(resultSet, statement, connection);
	}
	return pro;
    }
    
    
    public ProfessionalUser findByUsernamePassword(String username, String password) throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
	
	ProfessionalUser pro = null;
	String query = "SELECT * FROM " + PROFFESIONAL_USER_TABLE + " WHERE " + USERNAME + " =? AND " + PASSWORD + "=?;";
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setString(1, username);
	    statement.setString(2, password);
	    resultSet = statement.executeQuery();
	    if (resultSet.next()) {
		pro = populate(resultSet);
	    }
	    
	} finally {
		DaoUtils.closeResources(resultSet, statement, connection);
	}
	return pro;
    }
    
    
    public boolean exist(String name, String value) throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
	
	String query = "SELECT * FROM " + PROFFESIONAL_USER_TABLE + " WHERE " + name + " =?;";
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setString(1, value);
	    resultSet = statement.executeQuery();
	    if (resultSet.next()) {
		return true;
	    } else {
		return false;
	    }
	    
	} finally {
		DaoUtils.closeResources(resultSet, statement, connection);
	}
	
    }
        
              
    /**
     * Utility method that takes a result set and returns a ProfessionalUser object.
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private ProfessionalUser populate(ResultSet resultSet) throws SQLException {
	return new ProfessionalUser()
		.setProUSerId(resultSet.getInt(PRO_USER_ID))
		.setFirstName(resultSet.getString(FIRST_NAME))
		.setLastName(resultSet.getString(LAST_NAME))
		.setLocation(resultSet.getString(LOCATION))
		.setProfession(resultSet.getString(PROFESSION))
		.setUsername(resultSet.getString(USERNAME))
		.setPassword(resultSet.getString(PASSWORD))
		.setEmail(resultSet.getString(EMAIL))
		.setActive(resultSet.getBoolean(ACTIVE))
		.setPhotoName(resultSet.getString(PHOTO_NAME));
    }   
    
}
