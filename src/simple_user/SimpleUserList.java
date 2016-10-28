package simple_user;

import java.util.ArrayList;

public class SimpleUserList {

	private ArrayList<SimpleUser> simpleUsers;
	private SimpleUserDB simpleUserDB;
	
	public SimpleUserList() {
		this.simpleUserDB = new SimpleUserDB();
	}
	
	public void setSimpleUsers(ArrayList<SimpleUser> simpleUsers) {
		this.simpleUsers = simpleUsers;
	}
	
	public ArrayList<SimpleUser> getSimpleUsers() {
		return this.simpleUsers;
	}
	
	public void registerSimpleUser(SimpleUser simpleUser) {
		if (this.simpleUserDB.insertSimpleUser(simpleUser)) {
			System.out.println("Registration Succeeded!");
		} else {
			System.out.println("Registration Failed!");
		}
	}
	
	public int getNextSimpleUserID() {
		return this.simpleUserDB.getHighestID() + 1;
	}
	
	public ArrayList<SimpleUser> getAllSimpleUsers() {
		return this.simpleUserDB.getAllSimpleUsers();
	}
}
