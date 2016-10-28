package testers;

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
	}

}
