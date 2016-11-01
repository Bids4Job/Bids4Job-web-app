
import domain.Bid;
import service.BidService;

import java.util.*;

import com.sun.jmx.snmp.Timestamp;

import java.io.*;


public class TestBid {

    private static Scanner scan1;
    
    public static void main(String[] args) {
	
	
	BidService service = new BidService();
	int inputINT1 = 0;
	int inputINT2 = 0;
	double inputDOUBLE = 0;
	//Timestamp inputTIME = null;
	
//	System.out.println("Add a Bid:");
//	System.out.println("TaskId");
//	inputINT1 = scan1.nextInt();
//	System.out.println("ProUserId:");
//	inputINT2 = scan1.nextInt();
//	System.out.println("amount:");
//	inputDOUBLE = scan1.nextDouble();
//	//System.out.println("Bid Time:");
//	//inputTIME =10:49*29.10000;
//	try{
//	    Bid bid = new Bid();
//	    bid.setTaskId(inputINT1);
//	    bid.setProUserId(inputINT2);
//	    bid.setAmount(inputDOUBLE);
//	   // bid.setBidTime(null);
//	    service.create(bid);
//	} catch (Exception e) {
//	    e.printStackTrace();
//	}
	
	
	try {
	    List<Bid> bids = service.findAll();
	    System.out.println(bids);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	
	
	
    }   
    
}
