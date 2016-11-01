package testers;

import java.sql.Timestamp;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import dao.BidDAO;
import domain.Bid;

public class BidDAOTester {
    
    public static void main(String[] args) {
	
	BidDAO bidDAO = new BidDAO();
	Bid bid;
	List<Bid> bids;
	
	try {
	    //finOne()
	    bid = bidDAO.findOne(1);
	    System.out.println("findOne()\n" + bid.toString());
	    
	    //findAll()
	    System.out.println("\nfindAll()");
	    bids = bidDAO.findAll();
	    for (Bid b : bids){
		System.out.println(b);
	    }
	    //create()
	    System.out.println("\ncreate();");
	    try {
		bid = bidDAO.create(new Bid().setBidTime(new Timestamp(System.currentTimeMillis()))
			.setAmount(300).setProUserId(10).setTaskId(10));
		System.out.println(bid);
	    } catch (MySQLIntegrityConstraintViolationException e) {
		System.out.println("Something Wrong.");
	    }
	    
	    //update()
	    System.out.println("\nupdate()");
	    System.out.println(bid.toString() + "updated: " + bidDAO.update(bid.setTaskId(3)) + "\nto " + bid.toString());
	    
	    
	}  catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	
	
	
    }

}
