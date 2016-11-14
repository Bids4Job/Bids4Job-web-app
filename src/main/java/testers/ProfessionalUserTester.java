package testers;

import domain.ProfessionalUser;

public class ProfessionalUserTester {
    
    public static void main(String[] args) {
	
	ProfessionalUser pro1 = new ProfessionalUser(1, "Giannis", "Kranas", "Faliro", "Developer", "johny", "qwerty", "johny@example.com", true);
	System.out.println(pro1);
	System.out.println("Pro ID: " + pro1.getProUserId());
	System.out.println("First: " + pro1.getFisrtName());
	System.out.println("Last: " + pro1.getLastName());
	System.out.println("Location: " + pro1.getLocation());
	System.out.println("Profession: " + pro1.getProfession());
	System.out.println("Username: " + pro1.getUsername());
	System.out.println("Password: " + pro1.getPassword());
	System.out.println("Email: " + pro1.getEmail());
	System.out.println("Active: " + pro1.getActive());
	
	ProfessionalUser pro2 = new ProfessionalUser().setProUSerId(2).setFirstName("Marielena").setLastName("Rossetou").setLocation("Stuttgard").setProfession("Designer").setUsername("marielena-rou").setPassword("123abc").setEmail("rousetou@example.com").setActive(false);
	System.out.println(pro2);
    }

}
