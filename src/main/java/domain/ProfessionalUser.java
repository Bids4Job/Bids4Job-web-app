package domain;

//import dao.ProfessionalUserDao;

/**
 * 
 * @author Ioannis
 *
 */
public class ProfessionalUser {

	private int proUserid;
	private String firstName;
	private String lastName;
	private String location;
	private String profession;
	private String username;
	private String password;
	private String email;
	private boolean active;
	private String photoName;
	
	public ProfessionalUser() {
	}

	public ProfessionalUser(int proUserid, String firstName, String lastName, String location, String profession,
			String username, String password, String email, boolean active) {
		this.proUserid = proUserid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.profession = profession;
		this.username = username;
		this.password = password;
		this.email = email;
		this.active = true;
	}

	public int getProUserId() {
		return this.proUserid;
	}

	public ProfessionalUser setProUSerId(int proUserid) {
		this.proUserid = proUserid;
		return this;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public ProfessionalUser setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return this.lastName;
	}

	public ProfessionalUser setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getLocation() {
		return this.location;
	}

	public ProfessionalUser setLocation(String location) {
		this.location = location;
		return this;
	}

	public String getProfession() {
		return this.profession;
	}

	public ProfessionalUser setProfession(String profession) {
		this.profession = profession;
		return this;
	}

	public String getUsername() {
		return this.username;
	}

	public ProfessionalUser setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return this.password;
	}

	public ProfessionalUser setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getEmail() {
		return this.email;
	}

	public ProfessionalUser setEmail(String email) {
		this.email = email;
		return this;
	}

	public boolean getActive() {
		return this.active;
	}

	public ProfessionalUser setActive(boolean active) {
		this.active = active;
		return this;
	}

	public String getPhotoName() {
		return this.photoName;
	}
	
	public ProfessionalUser setPhotoName(String photoName) {
		this.photoName = photoName;
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ProfessionalUser))
			return false;

		ProfessionalUser professionalUser = (ProfessionalUser) o;

		return proUserid == professionalUser.proUserid;
	}

	@Override
	public int hashCode() {
		return this.proUserid;
	}

	@Override
	public String toString() {
		return "\nProfessional User" + " ID: " + this.proUserid + "\nFirst Name: " + this.firstName + "\nLast Name: "
				+ this.lastName + "\nUsername: " + this.username + "\nPassword: " + this.password + "\nEmail: "
				+ this.email + "\nLocation: " + this.location + "\nProfession: " + this.profession + "\n";
	}
}
