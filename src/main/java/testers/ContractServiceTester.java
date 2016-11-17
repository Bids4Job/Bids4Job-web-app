package testers;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import domain.Contract;
import service.ContractService;

/**
 * Service class that executes all required business logic regarding Contracts.
 * 
 * @author george
 *
 */
public class ContractServiceTester {

	public static void main(String[] args) {
		ContractService contractService = new ContractService();
		Contract contract;
		List<Contract> contracts;
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			// findOne
			System.out.println("findOne()\n" + contractService.findOne(2));
			// findAll
			System.out.println("\nfindAll()");
			contracts = contractService.findAll();
			for (Contract s : contracts) {
				System.out.println(s);
			}
			// create
			contract = new Contract(1, 1, 1, 1, new Timestamp(System.currentTimeMillis()));
			System.out.println("\ncreate()\n" + contractService.create(contract));
			// update
			System.out.println("\nupdate()\n" + contractService.update(contract.setTaskID(7)));
			System.out.println(contractService.findOne(contract.getContractID()));
			// delete
			System.out.println("\ndelete()\n" + contractService.delete(contract));
			System.out.println(contractService.findOne(contract.getContractID()));
			// findByBidID
			System.out.println("\nfindByBidID()\n" + contractService.findByBidID(6));
			System.out.println("\nfindByBidID()\n" + contractService.findByBidID(2));

			// findByTaskID
			System.out.println("\nfindByTaskID()\n" + contractService.findByTaskID(6));
			System.out.println("\nfindByTaskID()\n" + contractService.findByTaskID(4));

			// findByProUserID
			System.out.println("\nfindByProUserID()");
			contracts = contractService.findByProUserID(1);
			for (Contract s : contracts) {
				System.out.println(s);
			}

			// findBySimpleUserID
			System.out.println("\nfindBySimpleUserID()");
			contracts = contractService.findBySimpleUserID(1);
			for (Contract s : contracts) {
				System.out.println(s);
			}
			System.out.println("\nfindBySimpleUserID()");
			contracts = contractService.findBySimpleUserID(2);
			for (Contract s : contracts) {
				System.out.println(s);
			}

			// findByLocation
			System.out.println("\nfindByLocation()");
			contracts = contractService.findByLocation("Thessaloniki");
			for (Contract c : contracts) {
				System.out.println(c);
			}

			// findByContractTime
			System.out.println("\nfindByContractTime()");
			contracts = contractService.findByContractTime(
					simpleDateFormat.format(new Timestamp(simpleDateFormat.parse("2016-11-01").getTime())));
			for (Contract c : contracts) {
				System.out.println(c);
			}

			// findRatingByProUserID
			System.out.println("\nfindRatingByProUserID()\n pro user 11: " + contractService.findRatingByProUserID(11));
			System.out.println("\nfindRatingByProUserID()\n pro user 111: " + contractService.findRatingByProUserID(111));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException
				| ParseException e) {
			e.printStackTrace();
		}
	}
}
