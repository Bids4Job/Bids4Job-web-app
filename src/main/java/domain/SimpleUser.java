package domain;

/**
 * @author george
 *
 */
public class SimpleUser {

	private int simpleUserID;
	private String firstName;
	private String lastName;
	private String location;
	private String username;
	private String password;
	private String email;
	private boolean active_account;
	private String photoName;
	
	public SimpleUser() {
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

	public SimpleUser setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getUsername() {
		return this.username;
	}

	public SimpleUser setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getPassword() {
		return this.password;
	}

	public SimpleUser setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getEmail() {
		return this.email;
	}

	public SimpleUser setActiveAccount(boolean active_account) {
		this.active_account = active_account;
		return this;
	}

	public boolean getActiveAccount() {
		return this.active_account;
	}

	public SimpleUser setPhotoName(String photoName) {
		this.photoName = photoName;
		return this;
	}

	public String getPhotoName() {
		return this.photoName;
	}
	
	@Override
	public int hashCode() {
		return this.simpleUserID;
	}

	@Override
	public String toString() {
		return "Simple User" + " ID: " + this.simpleUserID + "\nFirst Name: " + this.firstName + "\nLast Name: "
				+ this.lastName + "\nUsername: " + this.username + "\nPassword: " + this.password + "\nEmail: "
				+ this.email + "\nLocation: " + this.location + "\nActive: " + this.active_account;
	}
}
