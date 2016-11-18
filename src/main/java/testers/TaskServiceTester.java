package testers;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import domain.Task;
import service.TaskService;

public class TaskServiceTester {

	public static void main(String[] args) {
		TaskService taskService = new TaskService();
		Task task;
		List<Task> tasks;
		CachedRowSet crs;

		try {
			/**
			 * Testing the findOne method of TaskService class.
			 */
			System.out.println(taskService.findOne(1));

			/**
			 * Testing the findAll method of TaskService class.
			 */
			tasks = taskService.findAll();
			for (Task taskTest : tasks) {
				System.out.println(taskTest);
			}

			/**
			 * Testing the create method of TaskService class.
			 */
			task = taskService.create(new Task().setDeadline(Timestamp.valueOf("2021-09-06 23:45:39"))
					.setSimpleUserId(6).setWorkField("musician"));
			System.out.println(task);

			/**
			 * Testing the update method of TaskService class.
			 */
			task = taskService.findOne(11);
			if (taskService.update(task.setWorkField("doorman"))) {
				System.out.println("Success" + "\n" + task);
			}

			/**
			 * Testing the delete method of TaskService class.
			 */
			if (taskService.delete(task)) {
				System.out.println("Success!");
			}
			/**
			 * Testing the findDetailsBySimpleUserID method of TaskService
			 * class.
			 */
			System.out.println("\n================findDetailsBySimpleUserID()");
			crs = taskService.findDetailsBySimpleUserID(1);
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					System.out.println("task id: " + crs.getInt("task_id") + "\nbid id: "
							+ crs.getInt("bid_id") + "\namount id: " + crs.getInt("amount") + "\nrating: "
							+ crs.getDouble("rating") + "\npro username: " + crs.getString("username") + "\nbid_time: " + crs.getTimestamp("bid_time") + "\n");
				}
			}
			// findDetailsBySimpleUserID
			System.out.println("\n================findDetailsBySimpleUserID()");
			crs = taskService.findDetailsBySimpleUserID(100);
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					System.out.println("task id: " + crs.getInt("task_id") + "\nbid id: "
							+ crs.getInt("bid_id") + "\namount id: " + crs.getInt("amount") + "\nrating: "
							+ crs.getDouble("rating") + "\npro username: " + crs.getString("username") + "\nbid_time: " + crs.getTimestamp("bid_time") + "\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
