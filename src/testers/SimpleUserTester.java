package testers;

import simple_user.SimpleUser;

public class SimpleUserTester {

	public static void main(String[] args) {
		// User 1
		SimpleUser george = new SimpleUser("George", "Spyridakis", "Zografou");
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
	}
	
}
