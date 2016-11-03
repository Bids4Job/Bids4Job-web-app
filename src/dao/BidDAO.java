package dao;

import domain.Bid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 * 
 * @author Ioannis
 *
 */
public class BidDAO {
    
    private static final String BID_TABLE = "bid";
    private static final String BID_ID = "bid_ID";
    private static final String TASK_ID = "task_ID";
    private static final String PRO_USER_ID = "pro_user_ID";
    private static final String AMOUNT = "amount";
    private static final String BID_TIME = "bid_time";
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    
    /**
     * Sets the connection, the preparedStatement and the resultSet to null.
     */
    private void prepareResources(){
	this.connection = null;
	this.statement = null;
	this.resultSet = null;
    }
    
    /**
     * Create a new Bid in the bids4job_DB
     * @param bid
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public Bid create(Bid bid) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	String query = "INSERT INTO " + BID_TABLE + "(" + TASK_ID + ", " + PRO_USER_ID + ", " + AMOUNT + ", " + BID_TIME + ") VALUES (?, ?, ?, ?)";
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
	    statement.setInt(1, bid.getTaskId());
	    statement.setInt(2, bid.getProUserId());
	    statement.setDouble(3, bid.getAmount());
	    statement.setTimestamp(4, bid.getBidTime());
	    statement.executeUpdate();
	    resultSet = statement.getGeneratedKeys();
	    if (resultSet.next()){
		bid.setBidId(resultSet.getInt(1));
	    }
	} finally {
	    DaoUtils.closeResources(resultSet, statement, connection);
	}
	return bid;
    }
    
    /**
     * Update a specific bid
     * @param bid
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public boolean update(Bid bid) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	String query = "UPDATE " + BID_TABLE + " SET " + TASK_ID + "=?, " + PRO_USER_ID + "=?, " + AMOUNT + "= ?, " + BID_TIME + "=? WHERE " + BID_ID + "=?";
	this.prepareResources();
	try{
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setInt(1, bid.getTaskId());
	    statement.setInt(2, bid.getProUserId());
	    statement.setDouble(3, bid.getAmount());
	    statement.setTimestamp(4, bid.getBidTime());
	    statement.setInt(5, bid.getBidId());
	    int affectedRows = statement.executeUpdate();
	    if (affectedRows ==1){
		return  true;
	    }
	} finally {
	    DaoUtils.closeResources(resultSet, statement, connection);
	}
	return false;
    }
    
    /**
     * Remove a specific Bid
     * @param bid
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public boolean remove(Bid bid) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	String query = "DELETE FROM " + BID_TABLE + " WHERE " + BID_ID + " = ?";
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setInt(1, bid.getBidId());
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
     * Find a specific bid from bidID
     * @param bidId
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public Bid findOne(int bidId) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	Bid bid = null;
	String query = "SELECT * FROM " + BID_TABLE + " WHERE " + BID_ID + " =?";
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setInt(1, bidId);
	    resultSet = statement.executeQuery();
	    if (resultSet.next()){
		bid = populate(resultSet);
	    }
	} finally {
	    DaoUtils.closeResources(resultSet, statement, connection);
	}
	return bid;
    } 
    
    /**
     * Find all Bids
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public List<Bid> findAll()  throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	List<Bid> bids = new ArrayList<>();
	String query = "SELECT * FROM " + BID_TABLE;
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    resultSet = statement.executeQuery();
	    while (resultSet.next()) {
		Bid bid = populate(resultSet);
		bids.add(bid);
	    }
	} finally {
	     DaoUtils.closeResources(resultSet, statement, connection);
	 }
	return bids;
    }
    
    /**
     * Find a specidic Bid from a Professional User Id
     * @param proUserId
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public List<Bid> findFromProfessionalUserId (int proUserId) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	List<Bid> bids = new ArrayList<>();
	String query = "SELECT * FROM " + BID_TABLE + " WHERE " + PRO_USER_ID + "= ?";
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setInt(1, proUserId);
	    resultSet = statement.executeQuery();
	    while (resultSet.next()){
		Bid bid = populate(resultSet);
		bids.add(bid);
	    }
	} finally {
	    DaoUtils.closeResources(resultSet, statement, connection);
	}
	return bids;
    }
    
    /**
     * Find a specific bid from taskId
     * @param taskId
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public List<Bid> findFromTaskId (int taskId) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
	List<Bid> bids = new ArrayList<>();
	String query = "SELECT * FROM " + BID_TABLE + " WHERE " + TASK_ID + "= ?";
	this.prepareResources();
	try {
	    connection = DaoUtils.getConnection();
	    statement = connection.prepareStatement(query);
	    statement.setInt(1, taskId);
	    resultSet = statement.executeQuery();
	    while (resultSet.next()){
		Bid bid = populate(resultSet);
		bids.add(bid);
	    }
	} finally {
	    DaoUtils.closeResources(resultSet, statement, connection);
	}
	return bids;
    }  
    
    /**
     * Utility method that takes a result set and returns a Bid object.
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private Bid populate(ResultSet resultSet) throws SQLException {
	return new Bid()
		.setBidId(resultSet.getInt("bid_ID"))
		.setTaskId(resultSet.getInt("task_ID"))
		.setProUserId(resultSet.getInt("pro_user_ID"))
		.setAmount(resultSet.getDouble("amount"))
		.setBidTime(resultSet.getTimestamp("bid_time"));
    }
    
    
    
    
    
}
