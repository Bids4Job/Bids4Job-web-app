import com.sun.jmx.snmp.Timestamp;

import dao.TaskQueries;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Hello Team!");
		TaskQueries.getTasksBySimpleUserID();
		TaskQueries.getTasksByWorkField();
		TaskQueries.getTasksByDeadline();
		TaskQueries.getTasksByLocation();
		TaskQueries.getTasksByLocationDeadlineWorkField();
	}
}
