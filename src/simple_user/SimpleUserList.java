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
	
	public boolean registerSimpleUser(SimpleUser simpleUser) {
		if (this.simpleUserDB.insertSimpleUser(simpleUser) == 1) {
			System.out.println("Registration Succeeded!");
			return true;
		} else {
			System.out.println("Registration Failed!");
			return false;
		}
	}
	
	public boolean updateSimpleUser(SimpleUser simpleUser) {
		if (this.simpleUserDB.updateSimpleUser(simpleUser) == 1) {
			System.out.println("Update Succeeded!");
			return true;
		} else {
			System.out.println("Update Failed!");
			return false;
		}
	}
	
	public boolean isRegistered(int simpleUserID) {
		return (this.findSimpleUser(simpleUserID) != null) ? true : false;
	}
	
	public SimpleUser findSimpleUser(int simpleUserID) {
		return this.simpleUserDB.selectSimpleUser(simpleUserID);
	}
	
	public boolean unregisterSimpleUser(SimpleUser simpleUser) {
		if (this.simpleUserDB.deleteSimpleUser(simpleUser) == 1) {
			System.out.println("Deletion Succeeded!");
			return true;
		} else {
			System.out.println("Deletion Failed!");
			return false;
		}
	}
	
	public int getNextSimpleUserID() {
		return this.simpleUserDB.getHighestID() + 1;
	}
	
	public int getNumberOfSimpleUsers() {
		return this.simpleUserDB.countSimpleUsers();
	}
	
	public boolean checkByLocation(String location) {
		return !this.getSimpleUsers(location).isEmpty();
	}
	
	public ArrayList<SimpleUser> getSimpleUsers(String location) {
		return this.simpleUserDB.selectSimpleUsers(location);
	}
	
	public boolean checkByName(String firstName, String lastName) {
		return !this.getSimpleUsers(firstName,lastName).isEmpty();
	}
	
	public ArrayList<SimpleUser> getSimpleUsers(String firstName, String lastName) {
		return this.simpleUserDB.selectSimpleUsers(firstName, lastName);
	}
	
	public ArrayList<SimpleUser> getAllSimpleUsers() {
		return this.simpleUserDB.selectAllSimpleUsers();
	}
}
