package testers;

import domain.ProfessionalUser;
import service.ProfessionalUserService;

import java.util.List;

public class ProfessionalUserServiceTester {

	public static void main(String[] args) {

		ProfessionalUserService proService = new ProfessionalUserService();
		ProfessionalUser pro;
		List<ProfessionalUser> pros;

		try {
			// findOne()
			System.out.println("\nfindOne()" + proService.findOne(7));
			// findAll()
			System.out.println("\nfindAll()");
			pros = proService.findAll();
			for (ProfessionalUser p : pros) {
				System.out.println(p);
			}
			// create()
			pro = new ProfessionalUser(21, "Antonis", "Antoniou", "Cyprous", "teacher", "ant-ant", "ant123password!",
					"antoniou@example.com", true);
			System.out.println("\ncreate()\n" + proService.create(pro));
			// update()
			System.out.println("\nupdate()\n");
			proService.update(pro.setLocation("Berlin"));
			System.out.println(proService.findOne(pro.getProUserId()));
			// remove()
			System.out.println("\nremove()\n");
			proService.remove(pro);
			System.out.println(proService.findOne(pro.getProUserId()));
			// AuthenticateByEmail
			System.out.println("AuthenticateByEmail()");
			pro = proService.authenticateByEmail("example1@mail.com", "pass1");
			System.out.println(pro.toString());
			// AuthenticateByUsername
			System.out.println("AuthenticateByUsername()");
			pro = proService.authenticateByUsername("i.kranas", "pass1");
			System.out.println(pro.toString());
			// findFromLocation()
			System.out.println("\nfindFromLocation()");
			pros = proService.findFromLocation("Patra");
			for (ProfessionalUser p : pros) {
				System.out.println(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
