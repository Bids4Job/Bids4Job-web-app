package testers;

import java.util.ArrayList;

import simple_user.SimpleUser;
import simple_user.SimpleUserList;

public class SimpleUserListTester {

	public static void main(String[] args) {
		SimpleUserList simpleUserList = new SimpleUserList();
		
		// Register a new SimpleUser
		simpleUserList.registerSimpleUser(new SimpleUser(
				simpleUserList.getNextSimpleUserID(),
				"George",
				"Spyridakis",
				"Athens"));
		
		// Get all SimpleUsers
		ArrayList<SimpleUser> simpleUsers = simpleUserList.getAllSimpleUsers();
		for (SimpleUser simpleUser : simpleUsers) {
			System.out.println(simpleUser.toString());
		}
	}
}
