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
			System.out.println(
					"\n==============================================\nfindOne()\n==============================================\n"
							+ simpleUserService.findOne(2));
			// findAll
			System.out.println(
					"\n==============================================\nfindAll()\n==============================================");
			simpleUsers = simpleUserService.findAll();
			for (SimpleUser s : simpleUsers) {
				System.out.println(s + "\n");
			}
			// create
			simpleUser = new SimpleUser().setFirstName("Kostas").setLastName("Georgiou").setLocation("Faliro")
					.setUsername("kgg").setPassword("kostas-faliro").setEmail("georgiou@example.com")
					.setActiveAccount(false);
			System.out.println(
					"\n==============================================\ncreate()\n==============================================\n"
							+ simpleUserService.create(simpleUser));
			// update
			System.out.println(
					"\n==============================================\nupdate()\n==============================================\n"
							+ simpleUserService.update(simpleUser.setFirstName("George")));
			System.out.println(simpleUserService.findOne(simpleUser.getSimpleUserID()));
			// delete
			System.out.println(
					"\n==============================================\ndelete()\n==============================================\n"
							+ simpleUserService.delete(simpleUser));
			System.out.println(simpleUserService.findOne(simpleUser.getSimpleUserID()));
			// findByLocation
			System.out.println("\n==============================================\nfindByLocation()");
			simpleUsers = simpleUserService.findByLocation("Faliro");
			for (SimpleUser s : simpleUsers) {
				System.out.println(s + "\n");
			}
			// findWithUnsignedTask
			System.out.println("\n==============================================\nfindWithUnsignedTask()");
			simpleUsers = simpleUserService.findWithUnsignedTask();
			for (SimpleUser s : simpleUsers) {
				System.out.println(s + "\n");
			}
			// findByActiveAccount - true
			System.out.println("\n==============================================\nfindByActiveAccount(true)");
			simpleUsers = simpleUserService.findByActiveAccount(true);
			for (SimpleUser s : simpleUsers) {
				System.out.println(s + "\n");
			}
			// findByActiveAccount - false
			System.out.println("\n==============================================\nfindByActiveAccount(false)");
			simpleUsers = simpleUserService.findByActiveAccount(false);
			for (SimpleUser s : simpleUsers) {
				System.out.println(s + "\n");
			}
			// authenticateByEmail - existing
			System.out.println(
					"\n==============================================\nauthenticateByEmail()\n==============================================\n"
							+ simpleUserService.authenticateByEmail("example1@mail.com", "pass1"));
			// authenticateByEmail - not existing
						System.out.println(
								"\n==============================================\nauthenticateByEmail()\n==============================================\n"
										+ simpleUserService.authenticateByEmail("example1@mail.com", "pass2"));
			// authenticateByUsername - existing
			System.out.println("\n==============================================\nauthenticate()\n==============================================\n"
							+ simpleUserService.authenticateByUsername("george-sp", "pass4"));
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
