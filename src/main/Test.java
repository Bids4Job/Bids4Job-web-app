package main;

import domain.ProfessionalUser;
import service.ProfessionalUserService;

import java.util.*;
import java.io.*;


/**
 * 
 * @author Ioannis
 *
 */
public class Test {
        
    private static Scanner scan1;
    
    public static void main(String[] args) throws IOException{
	
	
	scan1 = new Scanner (System.in);
	int inputINT = 0;
	String inputSTRING1 = null;
	String inputSTRING2= null;
	String inputSTRING3 = null;
	String inputSTRING4 = null;
	
	ProfessionalUserService service = new ProfessionalUserService();
//	System.out.println("Find Professional User by id: ");
//	inputINT = scan1.nextInt();
//	try {
//	    ProfessionalUser professionalUser = service.findOne(inputINT);
//	    System.out.println(professionalUser);
//	} catch (Exception e) {
//	    e.printStackTrace();
//	}
//	
//	System.out.println("Find Professional User by location: ");
//	inputSTRING1 = scan1.nextLine();
//	try {
//	    List<ProfessionalUser> professionalUser = service.findFromLocation(inputSTRING1);
//	    System.out.println(professionalUser);
//	} catch (Exception e) {
//	    e.printStackTrace();
//	}
	
//	System.out.println("Add a Professional User:");
//	System.out.println("First Name:");
//	inputSTRING1 = scan1.nextLine();
//	System.out.println("Last Name:");
//	inputSTRING2 = scan1.nextLine();
//	System.out.println("Location:");
//	inputSTRING3 = scan1.nextLine();
//	System.out.println("Profession:");
//	inputSTRING4 = scan1.nextLine();
//	try{
//	    ProfessionalUser professionalUser = new ProfessionalUser();
//	    professionalUser.setFirstName(inputSTRING1);
//	    professionalUser.setLastName(inputSTRING2);
//	    professionalUser.setLocation(inputSTRING3);
//	    professionalUser.setProfession(inputSTRING4);
//	    service.create(professionalUser);
//	} catch (Exception e) {
//	    e.printStackTrace();
//	}
	
	
//	System.out.println("Type the Professional User id to remove.");
//	inputINT = scan1.nextInt();
//	try{
//	    service.remove(inputINT);
//	} catch (Exception e) {
//	    e.printStackTrace();
//	}
   	
	
	System.out.println("Type the Professional User id to update");
	inputINT = scan1.nextInt();
	System.out.println("Type the new location");
	inputSTRING1 = scan1.nextLine();
	inputSTRING1 = scan1.nextLine();
	try {
	    ProfessionalUser professionalUser = service.findOne(inputINT);
	    professionalUser.setLocation(inputSTRING1);
	    service.update(professionalUser);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	
	
	try {
	    List<ProfessionalUser> professionalUsers = service.findAll();
	    System.out.println(professionalUsers);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
    }
    
    

}
