package testers;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import dao.ContractDAO;
import domain.Contract;

public class ContractDAOTester {

	public static void main(String[] args) {
		ContractDAO contractDAO = new ContractDAO();
		Contract contract;
		List<Contract> contracts;
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CachedRowSet crs;

		try {
			/* CRUD operations */
			// findOne
			contract = contractDAO.findOne(2);
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
			System.out.println(contract.toString() + " updated: " + contractDAO.update(contract.setBidID(3).setProRating(2.3)) + "\nto "
					+ contract.toString());
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
			// findByBidID
			System.out.println("\nfindByBidID()");
			contract = contractDAO.findByBidID(6);
			// contract = contractDAO.findByBidID(60);
			try {
				System.out.println(contract.toString());
			} catch (NullPointerException e) {
				System.out.println("Contract not found!");
			}
			// findByTaskID
			System.out.println("\nfindByTaskID()");
			contract = contractDAO.findByTaskID(3);
			// contract = contractDAO.findByBidID(60);
			try {
				System.out.println(contract.toString());
			} catch (NullPointerException e) {
				System.out.println("Contract not found!");
			}
			// findByProUserID
			System.out.println("\nfindByProUserID()");
			contracts = contractDAO.findByProUserID(2);
			for (Contract c : contracts) {
				System.out.println(c);
			}
			// findBySimpleUserID
			System.out.println("\nfindBySimpleUserID()");
			contracts = contractDAO.findBySimpleUserID(2);
			for (Contract c : contracts) {
				System.out.println(c);
			}
			// findByLocation
			System.out.println("\nfindByLocation()");
			contracts = contractDAO.findByLocation("Faliro");
			for (Contract c : contracts) {
				System.out.println(c);
			}
			// findByContractTime
			System.out.println("\nfindByContractTime()");
			contracts = contractDAO.findByContractTime(
					simpleDateFormat.format(new Timestamp(simpleDateFormat.parse("2016-11-01").getTime())));
			for (Contract c : contracts) {
				System.out.println(c);
			}
			// findRatingByProUserID
			System.out.println("\nfindRatingByProUserID()");
			System.out.println("Average rating of pro user #11: " + contractDAO.findRatingByProUserID(11));
			// findRatingByProUserID
			System.out.println("\nfindRatingByProUserID()");
			System.out.println("Average rating of pro user #3: " + contractDAO.findRatingByProUserID(3));
			// findDetailsBySimpleUserID
			System.out.println("\nfindDetailsBySimpleUserID()");
			crs = contractDAO.findDetailsBySimpleUserID(6);
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					System.out.println("contract id: " + crs.getInt("contract_id") + "\npro username: "
							+ crs.getString("username") + "\namount id: " + crs.getInt("amount") + "\nrating: "
							+ crs.getDouble("rating") + "\ncontract_time: " + crs.getTimestamp("contract_time") + "\n");
				}
			}
			// findDetailsBySimpleUserID
			System.out.println("\nfindDetailsBySimpleUserID()");
			crs = contractDAO.findDetailsBySimpleUserID(600);
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					System.out.println("contract id: " + crs.getInt("contract_id") + "\npro username: "
							+ crs.getString("username") + "\namount id: " + crs.getInt("amount") + "\nrating: "
							+ crs.getDouble("rating") + "\ncontract_time: " + crs.getTimestamp("contract_time") + "\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
