package testers;

import java.util.List;

import dao.SimpleUserDAO;
import domain.SimpleUser;

public class SimpleUserDAOTester {

	public static void main(String[] args) {
		SimpleUserDAO simpleUserDAO = new SimpleUserDAO();
		SimpleUser simpleUser;
		List<SimpleUser> simpleUsers;

		try {
			/* CRUD operations */
			// findOne
			simpleUser = simpleUserDAO.findOne(4);
			System.out.println("\n==============================================\nfindOne()\n==============================================\n" + simpleUser.toString());
			// findAll
			System.out.println("\n==============================================\nfindAll()\n==============================================");
			simpleUsers = simpleUserDAO.findAll();
			for (SimpleUser eachSimpleUser : simpleUsers) {
				System.out.println(eachSimpleUser.toString() + "\n");
			}
			// create
			System.out.println("\n==============================================\ncreate()\n==============================================");
			simpleUser = simpleUserDAO.create(new SimpleUser().setFirstName("Nick").setLastName("Papas")
					.setLocation("Zografos").setUsername("nicpa").setPassword("n1k0s").setEmail("nickpapas@example.com")
					.setActiveAccount(true));
			System.out.println(simpleUser.toString());
			// update
			System.out.println("\n==============================================\nupdate()\n==============================================");
			System.out.println(simpleUser.toString() + " updated: "
					+ simpleUserDAO.update(simpleUser.setLastName("Papadopoulos")) + " to " + simpleUser.toString());
			// findOne
			simpleUser = simpleUserDAO.findOne(simpleUser.getSimpleUserID());
			System.out.println("\n==============================================\nfindOne()\n==============================================\n" + simpleUser.toString());
			// delete
			System.out.println("\n==============================================\ndelete()\n==============================================");
			System.out.println(simpleUser.toString() + " delete: " + simpleUserDAO.delete(simpleUser));
			// findOne
			simpleUser = simpleUserDAO.findOne(simpleUser.getSimpleUserID());
			try {
				System.out.println("\n==============================================\nfindOne()\n==============================================\n" + simpleUser.toString());
			} catch (NullPointerException e) {
				System.out.println("User not found!");
			}
			// findByLocation
			System.out.println("\n==============================================\nfindByLocation()\n==============================================");
			simpleUsers = simpleUserDAO.findByLocation("Zografou");
			for (SimpleUser eachSimpleUser : simpleUsers) {
				System.out.println(eachSimpleUser.toString() + "\n");
			}
			// findWithUnsignedTask
			System.out.println("\n==============================================\nfindWithUnsignedTask()\n==============================================");
			simpleUsers = simpleUserDAO.findWithUnsignedTask();
			for (SimpleUser eachSimpleUser : simpleUsers) {
				System.out.println(eachSimpleUser.toString() + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
