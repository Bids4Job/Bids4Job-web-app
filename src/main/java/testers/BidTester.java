package testers;

import java.sql.Timestamp;

import domain.Bid;

public class BidTester {

    public static void main(String[] args) {
	
	Bid bid1 = new Bid(21, new Timestamp(System.currentTimeMillis()), 300, 4, 10);
	System.out.println(bid1);
	System.out.println("Bid ID: " + bid1.getBidId());
	System.out.println("Bid Time: " + bid1.getBidTime());
	System.out.println("Amount: " + bid1.getAmount());
	System.out.println("Pro User ID: " + bid1.getProUserId());
	System.out.println("Task ID: " + bid1.getTaskId());
	
	Bid bid2 = new Bid().setBidId(22).setBidTime(new Timestamp(System.currentTimeMillis()))
		.setAmount(200).setProUserId(5).setTaskId(10);
	System.out.println(bid2);
    }
}
