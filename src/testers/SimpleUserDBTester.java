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
		SimpleUser user1 = new SimpleUser(simpleUserDB.getHighestID() + 1, "Dimitris", "Dimitriou", "Zografou");
		System.out.println("SimpleUser registered: " + simpleUserDB.insertSimpleUser(user1));
		System.out.println(user1.getSimpleUserID());

		// UPDATE
		System.out.println("\nTest update statement");
		System.out.println("SimpleUser updated: " + simpleUserDB.updateSimpleUser(new SimpleUser(2, "George", "Spyridakis", "Athens")));

		// SELECT SIMPLE USER BY ID
		System.out.println("\nTest select simple user by id");
		System.out.println(simpleUserDB.selectSimpleUser(4).toString());
		
		// DELETE
		System.out.println("\nTest delete statement");
		System.out.println("SimpleUser deleted: " + simpleUserDB.deleteSimpleUser(user1));

		// GET THE HIGHEST SIMPLE_USER_ID
		System.out.println("\nGet the highest ID in Simple_User table");
		System.out.println(simpleUserDB.getHighestID());

		// COUNT ALL
		System.out.println("\nCount all registered SimpleUsers");
		System.out.println(simpleUserDB.countSimpleUsers());
		
		// SELECT ALL SIMPLE USERS
		System.out.println("\nGet all Simple Users");
		ArrayList<SimpleUser> simpleUsers = simpleUserDB.selectAllSimpleUsers();
		for (SimpleUser simpleUser : simpleUsers) {
			System.out.println(simpleUser.toString());
		}
	}

}
