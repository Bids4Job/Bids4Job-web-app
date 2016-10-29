package testers;

import java.util.ArrayList;

import domain.SimpleUser;
import dao.SimpleUserDAO;

public class SimpleUserDBTester {

	public static void main(String[] args) {
		SimpleUserDAO simpleUserDAO = new SimpleUserDAO();

		// OPEN & CLOSE CONNECTION
		System.out.println("TEST: open and close the connection");
		simpleUserDAO.openConnection();
		simpleUserDAO.closeConnection();
		System.out.println("\nTEST: to open and close the connection once again");
		simpleUserDAO.openConnection();
		simpleUserDAO.closeConnection();

		// INSERT INTO
		System.out.println("\nTEST: insert into statement");
		SimpleUser user1 = new SimpleUser(simpleUserDAO.getHighestID() + 1, "Dimitris", "Dimitriou", "Zografou");
		System.out.println("SimpleUser registered: " + simpleUserDAO.insertSimpleUser(user1));
		System.out.println(user1.getSimpleUserID());

		// UPDATE
		System.out.println("\nTEST: update statement");
		System.out.println("SimpleUser updated: "
				+ simpleUserDAO.updateSimpleUser(new SimpleUser(2, "George", "Spyridakis", "Athens")));

		// SELECT SIMPLE USER BY ID
		System.out.println("\nTEST: select simple user by id");
		System.out.println(simpleUserDAO.selectSimpleUser(4).toString());

		// DELETE
		System.out.println("\nTEST: delete statement");
		System.out.println("SimpleUser deleted: " + simpleUserDAO.deleteSimpleUser(user1));

		// GET THE HIGHEST SIMPLE_USER_ID
		System.out.println("\nTEST: select the highest ID in Simple_User table");
		System.out.println(simpleUserDAO.getHighestID());

		// COUNT ALL
		System.out.println("\nTEST: count all registered SimpleUsers");
		System.out.println(simpleUserDAO.countSimpleUsers());

		// SELECT SIMPLE USERS BASED ON LOCATION
		System.out.println("\nTEST: select all Simple Users from Zografou");
		ArrayList<SimpleUser> simpleUsersByLocation = simpleUserDAO.selectSimpleUsers("Zografou");
		for (SimpleUser simpleUser : simpleUsersByLocation) {
			System.out.println(simpleUser.toString());
		}

		// SELECT SIMPLE USERS BASED ON NAME (FIRST & LAST)
		System.out.println("\nTEST: select all Simple Users named George Spyridakis");
		ArrayList<SimpleUser> simpleUsersByName = simpleUserDAO.selectSimpleUsers("George", "Spyridakis");
		for (SimpleUser simpleUser : simpleUsersByName) {
			System.out.println(simpleUser.toString());
		}

		// SELECT ALL SIMPLE USERS
		System.out.println("\nTEST: select all Simple Users");
		ArrayList<SimpleUser> simpleUsers = simpleUserDAO.selectAllSimpleUsers();
		for (SimpleUser simpleUser : simpleUsers) {
			System.out.println(simpleUser.toString());
		}
	}

}
