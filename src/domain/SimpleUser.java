package domain;

public class SimpleUser {

	private int simpleUserID;
	private String firstName;
	private String lastName;
	private String location;

	public SimpleUser() {}

	public SimpleUser(String firstName, String lastName, String location) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
	}
	
	public SimpleUser(int simpleUserID, String firstName, String lastName, String location) {
		this.simpleUserID = simpleUserID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
	}
	
	public SimpleUser setSimpleUserID(int simpleUserID) {
		this.simpleUserID = simpleUserID;
		return this;
	}

	public int getSimpleUserID() {
		return this.simpleUserID;
	}
	
	public SimpleUser setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public SimpleUser setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getLastName() {
		return this.lastName;
	}

	public SimpleUser setLocation(String location) {
		this.location = location;
		return this;
	}

	public String getLocation() {
		return this.location;
	}
	
	@Override
	public String toString() {
		return "SimpleUser " + this.simpleUserID + ": " + this.firstName + " " + this.lastName + ", " + this.location;
	}
}
