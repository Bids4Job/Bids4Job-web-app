package testers;

import java.sql.Timestamp;

import domain.Task;

public class TaskTester {

	public static void main(String[] args) {
		/**
		 * Low dependency from constructor.
		 */
		Task task = new Task().setDeadline(Timestamp.valueOf("2019-11-12 00:00:00")).setSimpleUserId(5)
				.setWorkField("musician").setTaskId(20);
		System.out.println(task);
		/**
		 * Testing the getters.
		 */
		System.out.println(task.getSimpleUserId());
		System.out.println(task.getTaskId());
		System.out.println(task.getWorkField());
		System.out.println(task.getDeadline());
		/**
		 * Testing the setters and toString() method.
		 */
		task.setDeadline(Timestamp.valueOf("2020-12-12 00:00:00"));
		task.setSimpleUserId(32);
		task.setTaskId(55);
		task.setWorkField("artist");
		System.out.println(task.toString());
	}
}
