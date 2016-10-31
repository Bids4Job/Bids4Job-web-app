package testers;

import java.sql.Timestamp;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import dao.ContractDAO;
import domain.Contract;

public class ContractDAOTester {

	public static void main(String[] args) {
		ContractDAO contractDAO = new ContractDAO();
		Contract contract;
		List<Contract> contracts;

		try {
			/* CRUD operations */
			// findOne
			contract = contractDAO.findOne(4);
			System.out.println("findOne()\n" + contract.toString());
			// findAll
			System.out.println("\nfindAll()");
			contracts = contractDAO.findAll();
			for (Contract c : contracts) {
				System.out.println(c);
			}
			// create
			System.out.println("\ncreate()");
			try {
				contract = contractDAO.create(new Contract().setBidID(1).setTaskID(2)
						.setContractTime(new Timestamp(System.currentTimeMillis())));
				System.out.println(contract);
			} catch (MySQLIntegrityConstraintViolationException e) {
				System.out.println(
						"You cannot sign a contract with a Task or a Bid that DO NOT EXIST!!\n Database Constraints");
			}
			// update
			System.out.println("\nupdate()");
			System.out.println(contract.toString() + " updated: "
					+ contractDAO.update(contract.setBidID(3)) + "\nto " + contract.toString());
			// findOne
			contract = contractDAO.findOne(contract.getContractID());
			System.out.println("findOne()\n" + contract.toString());
			// delete
			System.out.println("\ndelete()");
			System.out.println(contract.toString() + " delete: " + contractDAO.delete(contract));
			// findOne
			contract = contractDAO.findOne(contract.getContractID());
			try {
				System.out.println("findOne()\n" + contract.toString());
			} catch (NullPointerException e) {
				System.out.println("Contract not found!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
