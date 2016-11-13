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
    
    public Bid create(Bid bid) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.create(bid);
    }
    
    public boolean update(Bid bid) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.update(bid);
    }
    
    public boolean remove(Bid bid) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.remove(bid);
    }
    
    public Bid findOne(int bidId) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.findOne(bidId);
    }
    
    public List<Bid> findFromProfessionalUserId(int proUserId) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.findFromProfessionalUserId(proUserId);
    }
    
    public List<Bid> findFromTaskId(int taskId) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.findFromTaskId(taskId);
    }
    
    public List<Bid> findAll() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.findAll();
    }
    
    
    
    
}
