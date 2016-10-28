package testers;

import java.util.ArrayList;

import simple_user.SimpleUser;
import simple_user.SimpleUserList;

public class SimpleUserListTester {

	public static void main(String[] args) {
		SimpleUserList simpleUserList = new SimpleUserList();

		// Register a new SimpleUser
		simpleUserList.registerSimpleUser(
				new SimpleUser(simpleUserList.getNextSimpleUserID(), "George", "Spyridakis", "Marousi"));
		System.out.println("\n");

		// Update SimpleUser
		simpleUserList.updateSimpleUser(new SimpleUser(4, "George", "Spyridakis", "Marousi"));
		System.out.println("\n");

		// Delete SimpleUser
		simpleUserList.unregisterSimpleUser(
				new SimpleUser(simpleUserList.getNextSimpleUserID(), "George", "Spyridakis", "Marousi"));
		System.out.println("\n");
		simpleUserList.unregisterSimpleUser(new SimpleUser(4, "George", "Spyridakis", "Marousi"));
		System.out.println("\n");
		simpleUserList.unregisterSimpleUser(new SimpleUser(25, "", "", ""));
		System.out.println("\n");

		// Find SimpleUser by ID
		System.out.println(simpleUserList.findSimpleUser(2).toString() + " found\n");

		// Check if SimpleUser is registered
		System.out.println("ID 300 is registered: " + simpleUserList.isRegistered(300) + "\n");
		System.out.println("ID 2 is registered: " + simpleUserList.isRegistered(2) + "\n");

		// Get SimpleUsers by location
		System.out.println("Marousi: " + simpleUserList.checkByLocation("Marousi"));
		ArrayList<SimpleUser> simpleUsersByLocation = simpleUserList.getSimpleUsers("Marousi");
		for (SimpleUser simpleUser : simpleUsersByLocation) {
			System.out.println(simpleUser.toString());
		}
		System.out.println();
		System.out.println("Marousiaaaaa: " + simpleUserList.checkByLocation("Marousiaaaaa"));
		simpleUsersByLocation = simpleUserList.getSimpleUsers("Marousiaaaaa");
		for (SimpleUser simpleUser : simpleUsersByLocation) {
			System.out.println(simpleUser.toString());
		}
		System.out.println();

		// Get SimpleUsers by name
		System.out.println("George Spyridakis exists: " + simpleUserList.checkByName("George", "Spyridakis"));
		ArrayList<SimpleUser> simpleUsersByName = simpleUserList.getSimpleUsers("George", "Spyridakis");
		for (SimpleUser simpleUser : simpleUsersByName) {
			System.out.println(simpleUser.toString());
		}
		System.out.println();
		System.out.println("George Spydakis exists: " + simpleUserList.checkByName("George", "Spydakis"));
		simpleUsersByName = simpleUserList.getSimpleUsers("George", "Spydakis");
		for (SimpleUser simpleUser : simpleUsersByName) {
			System.out.println(simpleUser.toString());
		}
		System.out.println();

		// Get all SimpleUsers
		ArrayList<SimpleUser> simpleUsers = simpleUserList.getAllSimpleUsers();
		for (SimpleUser simpleUser : simpleUsers) {
			System.out.println(simpleUser.toString());
		}

		// Get total number of Registered SimpleUsers
		System.out.println("\nNumber of SimpleUsers: " + simpleUserList.getNumberOfSimpleUsers());
	}
}
