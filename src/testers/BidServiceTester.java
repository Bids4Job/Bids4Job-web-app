package testers;

import java.sql.Timestamp;
import java.util.List;

import domain.Bid;
import service.BidService;


public class BidServiceTester {
    
    public static void main(String[] args) {
	BidService bidService = new BidService();
	Bid bid;
	List<Bid> bids;
	
	try {
	    //findOne
	    System.out.print("findOne();\n" + bidService.findOne(3));
	    //findAll
	    System.out.println("\nfindAll()");
	    bids = bidService.findAll();
	    for (Bid b : bids){
		System.out.println(b);
	    }
	    //create()
	    bid = new Bid(30, new Timestamp(System.currentTimeMillis()), 1000, 1, 1);
	    System.out.println("\ncreate()\n"+ bidService.create(bid));
	    //update()
	    System.out.println("\nupdate\n" + bidService.update(bid.setAmount(2000)));
	    System.out.println(bidService.findOne(bid.getBidId()));
	    //remove()
	    System.out.println("\ndelete()\n" + bidService.remove(bid));
	    System.out.println(bidService.findOne(bid.getBidId()));
	    //findFromProfessionalUserId()
	    System.out.println("\nfindFromProfessionalUserId()");
	    bids = bidService.findFromProfessionalUserId(10);
	    for (Bid b : bids){
		System.out.println(b);
	    }
	    //findFromTaskId()
	    System.out.println("\nfindFromTaskId()");
	    bids = bidService.findFromTaskId(9);
	    for (Bid b : bids){
		System.out.println(b);
	    }
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	
    }

}
