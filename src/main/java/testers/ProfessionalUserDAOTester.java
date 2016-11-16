package testers;

import dao.ProfessionalUserDao;
import domain.ProfessionalUser;

import java.util.List;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class ProfessionalUserDAOTester {
    
    public static void main(String[] args) {
	
	ProfessionalUserDao proDao = new ProfessionalUserDao();
	ProfessionalUser pro;
	List<ProfessionalUser> pros;
	
	try {
	    //findOne()
	    pro = proDao.findOne(1);
	    System.out.println("findOne()\n" + pro.toString());
	    
	    //findAll()
	    System.out.println("\nfindAll()");
	    pros = proDao.fiandAll();
	    for (ProfessionalUser p : pros){
		System.out.println(p);
	    }
	    //create()
	    System.out.println("\ncreate()");
	    try {
		pro = proDao.create(new ProfessionalUser().setFirstName("Antonis").setLastName("Antoniou").setLocation("Kentro").setProfession("Teacher"));
		System.out.println(pro);
	    } catch (MySQLIntegrityConstraintViolationException e) {
		System.out.println(e.getMessage());
	    }
	    //update()
	    System.out.println("\nupdate()");
	    System.out.println(pro.toString() + "updated: 0" + proDao.update(pro.setFirstName("Petros")) + "\nto" + pro.toString());
//	    //remove()
//	    System.out.println("\nremove()");
//	    System.out.println(proDao.remove(pro));
	    
	    pro = proDao.findByEmailPassword("example1@mail.com", "pass1");
	    System.out.println("Authenticate user 1" + pro.toString());
	    pro = proDao.findByEmailPassword("example1@mail.com", "pass");
	    System.out.println("Authenticate don't work" + pro.toString());
	    
	    
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
    }

}
