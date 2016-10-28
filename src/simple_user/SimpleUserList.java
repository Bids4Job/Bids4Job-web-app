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
	
	public ArrayList<SimpleUser> getAllSimpleUsers() {
		return this.simpleUserDB.getAllSimpleUsers();
	}
}
