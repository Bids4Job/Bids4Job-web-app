package testers;

import domain.SimpleUser;

public class SimpleUserTester {

	public static void main(String[] args) {
		// User 1
		SimpleUser george = new SimpleUser();
		System.out.println(george.toString());
		System.out.println(george.getSimpleUserID());
		System.out.println(george.getFirstName());
		System.out.println(george.getLastName());
		System.out.println(george.getLocation());
		System.out.println("\n");
		// User 2
		SimpleUser dimitris = new SimpleUser();
		System.out.println(dimitris.toString());
		dimitris.setFirstName("Dimitris");
		dimitris.setLastName("Theodoropoulos");
		dimitris.setLocation("Neo Irakleio");
		dimitris.setUsername("jim");
		dimitris.setPassword("jim-pass");
		dimitris.setEmail("jim@example.com");
		dimitris.setActiveAccount(true);
		System.out.println(dimitris.toString());
		System.out.println("\n");
		// User 3 - Low Dependency from Constructor
		SimpleUser giannis = new SimpleUser()
				.setLastName("Kranas")
				.setFirstName("Giannis")
				.setSimpleUserID(1)
				.setLocation("Faliro")
				.setUsername("johny")
				.setPassword("1234")
				.setEmail("john@example.com")
				.setActiveAccount(false);
		System.out.println(giannis.toString());
	}
	
}
