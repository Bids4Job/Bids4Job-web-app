package testers;

import domain.SimpleUser;

public class SimpleUserTester {

	public static void main(String[] args) {
		// User 1
		SimpleUser george = new SimpleUser(1, "George", "Spyridakis", "Zografou");
		System.out.println(george.toString());
		System.out.println(george.getSimpleUserID());
		System.out.println(george.getFirstName());
		System.out.println(george.getLastName());
		System.out.println(george.getLocation());
		// User 2
		SimpleUser dimitris = new SimpleUser();
		System.out.println(dimitris.toString());
		dimitris.setFirstName("Dimitris");
		dimitris.setLastName("Theodoropoulos");
		dimitris.setLocation("Neo Irakleio");
		System.out.println(dimitris.toString());
		// User 3 - Low Dependency from Constructor
		SimpleUser giannis = new SimpleUser()
				.setLastName("Kranas")
				.setFirstName("Giannis")
				.setSimpleUserID(1)
				.setLocation("Faliro");
		System.out.println(giannis.toString());
	}
	
}
