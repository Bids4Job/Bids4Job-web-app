package domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Contract {

	private int contractID;
	private int bidID;
	private int taskID;
	private double proRating;
	private Timestamp contractTime;

	public Contract() {
	}

	public Contract(int contractID, int taskID, int bidID, double proRating, Timestamp contractTime) {
		this.contractID = contractID;
		this.taskID = taskID;
		this.bidID = bidID;
		this.proRating = proRating;
		this.contractTime = contractTime;
	}

	/**
	 * @param contractID
	 *            contract ID to set
	 * @return current Contract with the new inserted ID
	 */
	public Contract setContractID(int contractID) {
		this.contractID = contractID;
		return this;
	}

	/**
	 * @return contract's ID
	 */
	public int getContractID() {
		return this.contractID;
	}

	/**
	 * @param bidID
	 *            bid ID to set
	 * @return current Contract with the new inserted bid ID
	 */
	public Contract setBidID(int bidID) {
		this.bidID = bidID;
		return this;
	}

	/**
	 * @return contract's bid id
	 */
	public int getBidID() {
		return this.bidID;
	}

	/**
	 * @param taskID
	 *            task ID to set
	 * @return current Contract with the new inserted task ID
	 */
	public Contract setTaskID(int taskID) {
		this.taskID = taskID;
		return this;
	}

	/**
	 * @return contract's task id
	 */
	public int getTaskID() {
		return this.taskID;
	}

	/**
	 * @param proRating
	 *            professional user rating to set
	 * @return current Contract with the new inserted professional user rating
	 */
	public Contract setProRating(double proRating) {
		this.proRating = proRating;
		return this;
	}

	/**
	 * @return contract's pro rating
	 */
	public double getProRating() {
		return this.proRating;
	}

	/**
	 * @param contractTime
	 *            exact time the contract was signed
	 * @return current Contract with the new inserted contract time
	 */
	public Contract setContractTime(Timestamp contractTime) {
		this.contractTime = contractTime;
		return this;
	}

	/**
	 * @return exact time the contract was signed
	 */
	public Timestamp getContractTime() {
		return this.contractTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "Contract " + this.contractID + ": task " + this.taskID + ", bid " + this.bidID + ", pro rating "
				+ this.proRating + ", contract time " + simpleDateFormat.format(this.contractTime);
	}
}
