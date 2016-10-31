package testers;

import java.sql.Timestamp;

import domain.Contract;

public class ContractTester {

	public static void main(String[] args) {
		// Contract 1
		Contract contract1 = new Contract(1, 5, 18, new Timestamp(System.currentTimeMillis()));
		System.out.println(contract1);
		System.out.println("Contract ID: " + contract1.getContractID());
		System.out.println("Bid ID: " + contract1.getBidID());
		System.out.println("Task ID: " + contract1.getTaskID());
		System.out.println("ContractTime: " + contract1.getContractTime());
		// Contract 2
		Contract contract2 = new Contract().setTaskID(20).setBidID(13).setContractID(10)
				.setContractTime(new Timestamp(System.currentTimeMillis()));
		System.out.println(contract2);
		System.out.println("ContractTime: " + contract2.getContractTime());
	}

}
