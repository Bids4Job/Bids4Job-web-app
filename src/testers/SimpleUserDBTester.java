package testers;

import java.util.ArrayList;

import simple_user.SimpleUser;
import simple_user.SimpleUserDB;

public class SimpleUserDBTester {

	public static void main(String[] args) {
		SimpleUserDB simpleUserDB = new SimpleUserDB();
		
		// OPEN & CLOSE CONNECTION
		System.out.println("Try to open and close the connection");
		simpleUserDB.openConnection();
		simpleUserDB.closeConnection();
		System.out.println("\nTry to open and close the connection once again");
		simpleUserDB.openConnection();
		simpleUserDB.closeConnection();
		
		// INSERT INTO
		System.out.println("\nTest insert into statement");
		SimpleUser user1 = new SimpleUser("Dimitris", "Dimitriou", "Zografou");
		System.out.println(simpleUserDB.insertSimpleUser(user1));
		System.out.println(user1.getSimpleUserID());
		
		// DELETE
		System.out.println("\nTest delete statement");
		System.out.println(simpleUserDB.deleteSimpleUser(user1));
		
		// GET THE HIGHEST SIMPLE_USER_ID
		System.out.println("\nGet the highest ID in Simple_User table");
		System.out.println(simpleUserDB.getHighestID());
		
		// SELECT ALL SIMPLE USERS
		System.out.println("\nGet all Simple Users");
		ArrayList<SimpleUser> simpleUsers = simpleUserDB.getAllSimpleUsers();
		for (SimpleUser simpleUser : simpleUsers) {
			System.out.println(simpleUser.toString());
		}
	}

}
