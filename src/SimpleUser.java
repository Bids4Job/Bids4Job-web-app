
public class SimpleUser {

	private final int simpleUserID;
	private String firstName;
	private String lastName;
	private String location;
	public static int counterID = 0;

	public SimpleUser() {
		counterID++;
		this.simpleUserID = counterID;
	}

	public SimpleUser(String firstName, String lastName, String location) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
	}

	public int getSimpleUserID() {
		return this.simpleUserID;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return this.location;
	}
	
	public String toString() {
		return this.getClass().getName() + " " + this.simpleUserID + ": " + this.firstName + " " + this.lastName + ", " + this.location;
	}
}
