package domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Contract {

	private int contractID;
	private int bidID;
	private int taskID;
	private Timestamp contractTime;
	
	public Contract(){}
	
	public Contract(int contractID, int taskID, int bidID, Timestamp contractTime) {
		this.contractID = contractID;
		this.taskID = taskID;
		this.bidID = bidID;
		this.contractTime = contractTime;
	}
	
	public Contract setContractID(int contractID) {
		this.contractID = contractID;
		return this;
	}
	
	public int getContractID() {
		return this.contractID;
	}
	
	public Contract setBidID(int bidID) {
		this.bidID = bidID;
		return this;
	}
	
	public int getBidID() {
		return this.bidID;
	}
	
	public Contract setTaskID(int taskID) {
		this.taskID = taskID;
		return this;
	}
	
	public int getTaskID() {
		return this.taskID;
	}
	
	public Contract setContractTime(Timestamp contractTime) {
		this.contractTime = contractTime;
		return this;
	}
	
	public Timestamp getContractTime() {
		return this.contractTime;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "Contract " + this.contractID + ": task " + this.taskID + ", bid " + this.bidID + ", contract time " + simpleDateFormat.format(this.contractTime);
	}
}
