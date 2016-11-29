package service;

import dao.BidDAO;
import domain.Bid;

import java.sql.SQLException;
import java.util.List;


/**
 * 
 * @author Ioannis
 *
 */
public class BidService {

    private BidDAO dao = new BidDAO();
    
    /**
     * Add a new bid at the database
     * 
     * @param bid
     * @return The Bid Object that was added to database.
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public Bid create(Bid bid) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.create(bid);
    }
    
    /**
     * Update a Bid in database on bidId.
     * 
     * @param bid
     * @return The Bid object that was updated to database
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public boolean update(Bid bid) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.update(bid);
    }
    
    /**
     * Remove a Bid from database on bidId.
     * 
     * @param bid
     * @return The Bid object that was removed from database
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public boolean remove(Bid bid) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.remove(bid);
    }
    
    /**
     * Finds the Bid with the given ID.
     * 
     * @param bidId
     * @return The Bid with the given ID.
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public Bid findOne(int bidId) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.findOne(bidId);
    }
    
    /**
     * Finds the Bid from professional user id, who makes the bid
     * 
     * @param proUserId
     * @return The Bid of the professional user with specific proUseid.
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public List<Bid> findFromProfessionalUserId(int proUserId) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.findFromProfessionalUserId(proUserId);
    }
    
    /**
     * Finds the list of bids from a specific taskiId
     * 
     * @param taskId
     * @return the list of bids from a specifictaskId
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public List<Bid> findFromTaskId(int taskId) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.findFromTaskId(taskId);
    }
    
    /**
     * Find all existing bids in the database.
     * 
     * @return a list with all existing bids
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public List<Bid> findAll() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.findAll();
    }
    
    
    
    
}
