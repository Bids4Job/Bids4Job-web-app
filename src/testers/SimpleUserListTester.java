package testers;

import java.util.ArrayList;

import domain.SimpleUser;
import service.SimpleUserService;

public class SimpleUserListTester {

	public static void main(String[] args) {
		SimpleUserService simpleUserService = new SimpleUserService();

		// Register a new SimpleUser
		simpleUserService.registerSimpleUser(
				new SimpleUser(simpleUserService.getNextSimpleUserID(), "George", "Spyridakis", "Marousi"));
		System.out.println("\n");

		// Update SimpleUser
		simpleUserService.updateSimpleUser(new SimpleUser(4, "George", "Spyridakis", "Marousi"));
		System.out.println("\n");

		// Delete SimpleUser
		simpleUserService.unregisterSimpleUser(
				new SimpleUser(simpleUserService.getNextSimpleUserID(), "George", "Spyridakis", "Marousi"));
		System.out.println("\n");
		simpleUserService.unregisterSimpleUser(new SimpleUser(4, "George", "Spyridakis", "Marousi"));
		System.out.println("\n");
		simpleUserService.unregisterSimpleUser(new SimpleUser(25, "", "", ""));
		System.out.println("\n");

		// Find SimpleUser by ID
		System.out.println(simpleUserService.findSimpleUser(2).toString() + " found\n");

		// Check if SimpleUser is registered
		System.out.println("ID 300 is registered: " + simpleUserService.isRegistered(300) + "\n");
		System.out.println("ID 2 is registered: " + simpleUserService.isRegistered(2) + "\n");

		// Get SimpleUsers by location
		System.out.println("Marousi: " + simpleUserService.checkByLocation("Marousi"));
		ArrayList<SimpleUser> simpleUsersByLocation = simpleUserService.getSimpleUsers("Marousi");
		for (SimpleUser simpleUser : simpleUsersByLocation) {
			System.out.println(simpleUser.toString());
		}
		System.out.println();
		System.out.println("Marousiaaaaa: " + simpleUserService.checkByLocation("Marousiaaaaa"));
		simpleUsersByLocation = simpleUserService.getSimpleUsers("Marousiaaaaa");
		for (SimpleUser simpleUser : simpleUsersByLocation) {
			System.out.println(simpleUser.toString());
		}
		System.out.println();

		// Get SimpleUsers by name
		System.out.println("George Spyridakis exists: " + simpleUserService.checkByName("George", "Spyridakis"));
		ArrayList<SimpleUser> simpleUsersByName = simpleUserService.getSimpleUsers("George", "Spyridakis");
		for (SimpleUser simpleUser : simpleUsersByName) {
			System.out.println(simpleUser.toString());
		}
		System.out.println();
		System.out.println("George Spydakis exists: " + simpleUserService.checkByName("George", "Spydakis"));
		simpleUsersByName = simpleUserService.getSimpleUsers("George", "Spydakis");
		for (SimpleUser simpleUser : simpleUsersByName) {
			System.out.println(simpleUser.toString());
		}
		System.out.println();

		// Get all SimpleUsers
		ArrayList<SimpleUser> simpleUsers = simpleUserService.getAllSimpleUsers();
		for (SimpleUser simpleUser : simpleUsers) {
			System.out.println(simpleUser.toString());
		}

		// Get total number of Registered SimpleUsers
		System.out.println("\nNumber of SimpleUsers: " + simpleUserService.getNumberOfSimpleUsers());
	}
}
