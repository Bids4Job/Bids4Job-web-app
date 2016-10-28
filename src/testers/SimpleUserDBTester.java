package testers;

import simple_user.SimpleUser;
import simple_user.SimpleUserDB;

public class SimpleUserDBTester {

	public static void main(String[] args) {
		SimpleUserDB simpleUserDB = new SimpleUserDB();
		System.out.println("Try to open and close the connection");
		simpleUserDB.openConnection();
		simpleUserDB.closeConnection();
		System.out.println("\nTry to open and close the connection once again");
		simpleUserDB.openConnection();
		simpleUserDB.closeConnection();
		
		System.out.println("\nTest insert into statement");
		SimpleUser user1 = new SimpleUser("Dimitris", "Dimitriou", "Zografou");
		System.out.println(simpleUserDB.insertSimpleUser(user1));
		System.out.println(user1.getSimpleUserID());
		
		System.out.println("\nTest delete statement");
		System.out.println(simpleUserDB.deleteSimpleUser(user1));
	}

}
