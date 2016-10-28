import java.sql.Date;

public class Task {

	public String workField;
	public Date deadline;
	public int simpleUserID;
	public int taskID = 0;
	public static int counter = 0;

	public Task() {
		
	}

	public Task(Date deadline, String workField) {
		this.deadline = deadline;
		this.workField = workField;
		counter += 1;
		taskID = counter;
	}

	public void setWorkField(String workField) {
		this.workField = workField;
	}

	public String getWorkField() {
		return this.workField;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getDeadline() {
		return this.deadline;
	}
	public String toString() {
		return "Task id: "+taskID+" deadline: "+deadline+" field of bussiness: "+workField;
	}

}
