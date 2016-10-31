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
			System.out.println("findOne()\n" + simpleUser.toString());
			// findAll
			System.out.println("\nfindAll()");
			simpleUsers = simpleUserDAO.findAll();
			for (SimpleUser eachSimpleUser : simpleUsers) {
				System.out.println(eachSimpleUser.toString());
			}
			// create
			System.out.println("\ncreate()");
			simpleUser = simpleUserDAO
					.create(new SimpleUser().setFirstName("Nick").setLastName("Papas").setLocation("Zografos"));
			System.out.println(simpleUser.toString());
			// update
			System.out.println("\nupdate()");
			System.out.println(simpleUser.toString() + " updated: "
					+ simpleUserDAO.update(simpleUser.setLastName("Papadopoulos")) + " to " + simpleUser.toString());
			// findOne
			simpleUser = simpleUserDAO.findOne(simpleUser.getSimpleUserID());
			System.out.println("findOne()\n" + simpleUser.toString());
			// delete
			System.out.println("\ndelete()");
			System.out.println(simpleUser.toString() + " delete: " + simpleUserDAO.delete(simpleUser));
			// findOne
			simpleUser = simpleUserDAO.findOne(simpleUser.getSimpleUserID());
			try {
				System.out.println("findOne()\n" + simpleUser.toString());
			} catch (NullPointerException e) {
				System.out.println("User not found!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
