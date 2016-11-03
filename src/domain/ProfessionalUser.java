package domain;

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
    
    public ProfessionalUser(){}
    
    public ProfessionalUser(int proUserid, String firstName, String lastName, String location, String profession){
	this.proUserid = proUserid;
	this.firstName = firstName;
	this.lastName = lastName;
	this.location = location;
	this.profession = profession;
    }
    
    public int getProUserId(){
	return this.proUserid;
    }
    
    public ProfessionalUser setProUSerId(int proUserid){
	this.proUserid = proUserid;
	return this;
    }
    
    public String getFisrtName(){
	return this.firstName;
    }
    
    public ProfessionalUser setFirstName(String firstName){
	this.firstName = firstName;
	return this;
    }
    
    public String getLastName(){
	return this.lastName;
    }
    
    public ProfessionalUser setLastName(String lastName){
	this.lastName = lastName;
	return this;
    }
    
    public String getLocation(){
	return this.location;
    }
    
    public ProfessionalUser setLocation(String location){
	this.location = location;
	return this;
    }
    
    public String getProfession(){
	return this.profession;
    }
    
    public ProfessionalUser setProfession(String profession){
	this.profession=profession;
	return this;
    }
    
    @Override
    public boolean equals(Object o){
	if (this == o) return true;
	if (!(o instanceof ProfessionalUser)) return false;
	
	ProfessionalUser professionalUser = (ProfessionalUser) o;
	
	return proUserid == professionalUser.proUserid;
    }
    
    @Override
    public int hashCode(){
	return this.proUserid;
    }

    @Override
    public String toString(){
	return  "\nProfessional User" +
		" ID: " + proUserid + 
		"\nFirst Name: " + firstName + 
		"\nLast Name: " + lastName + 
		"\nLocation: " + location +
		"\nProfession: " + profession +
		"\n";
    }
}
