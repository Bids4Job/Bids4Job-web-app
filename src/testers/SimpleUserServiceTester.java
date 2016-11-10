package testers;

import java.util.List;

import domain.SimpleUser;
import service.SimpleUserService;

public class SimpleUserServiceTester {

	public static void main(String[] args) {
		SimpleUserService simpleUserService = new SimpleUserService();
		SimpleUser simpleUser;
		List<SimpleUser> simpleUsers;
		
		try {
			// findOne
			System.out.println("findOne()\n" + simpleUserService.findOne(2));
			// findAll
			System.out.println("\nfindAll()");
			simpleUsers = simpleUserService.findAll();
			for (SimpleUser s : simpleUsers) {
				System.out.println(s);
			}
			// create
			simpleUser = new SimpleUser().setFirstName("Kostas").setLastName("Georgiou").setLocation("Faliro");
			System.out.println("\ncreate()\n"+ simpleUserService.create(simpleUser));
			// update
			System.out.println("\nupdate()\n"+ simpleUserService.update(simpleUser.setFirstName("George")));
			System.out.println(simpleUserService.findOne(simpleUser.getSimpleUserID()));
			// delete
			System.out.println("\ndelete()\n"+ simpleUserService.delete(simpleUser));
			System.out.println(simpleUserService.findOne(simpleUser.getSimpleUserID()));
			// findByLocation
			System.out.println("\nfindByLocation()");
			simpleUsers = simpleUserService.findByLocation("Faliro");
			for (SimpleUser s : simpleUsers) {
				System.out.println(s);
			}
			// findWithUnsignedTask
			System.out.println("\nfindWithUnsignedTask()");
			simpleUsers = simpleUserService.findWithUnsignedTask();
			for (SimpleUser s : simpleUsers) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
