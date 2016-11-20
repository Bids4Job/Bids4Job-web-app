package testers;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
			System.out.println("\n================findDetailsBySimpleUserID(1)");
			crs = taskService.findDetailsBySimpleUserID(1);
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					System.out.println("task id: " + crs.getInt("task_id") + "\nbid id: " + crs.getInt("bid_id")
							+ "\ntask title: " + crs.getString("title") + "\ntask description: "
							+ crs.getString("description") + "\nwork field: " + crs.getString("work_field")
							+ "\ntask deadline: " + simpleDateFormat.format(crs.getTimestamp("deadline"))
							+ "\nlocation: " + crs.getString("location") + "\namount id: " + crs.getInt("amount")
							+ "\nrating: " + crs.getDouble("rating") + "\npro username: " + crs.getString("username")
							+ "\nbid_time: " + crs.getTimestamp("bid_time") + "\n");
				}
			}
			// findDetailsBySimpleUserID
			System.out.println("\n================findDetailsBySimpleUserID(100)");
			crs = taskService.findDetailsBySimpleUserID(100);
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					System.out.println("task id: " + crs.getInt("task_id") + "\nbid id: " + crs.getInt("bid_id")
							+ "\ntask title: " + crs.getString("title") + "\ntask description: "
							+ crs.getString("description") + "\nwork field: " + crs.getString("work_field")
							+ "\ntask deadline: " + simpleDateFormat.format(crs.getTimestamp("deadline"))
							+ "\nlocation: " + crs.getString("location") + "\namount id: " + crs.getInt("amount")
							+ "\nrating: " + crs.getDouble("rating") + "\npro username: " + crs.getString("username")
							+ "\nbid_time: " + crs.getTimestamp("bid_time") + "\n");
				}
			}
			/**
			 * Testing the findDetailsByProfessionalUserID method of TaskService
			 * class.
			 */
			System.out.println("\n================findDetailsByProfessionalUserID(1)");
			crs = taskService.findDetailsByProfessionalUserID(1);
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					System.out.println("task id: " + crs.getInt("task_id") + "\nbid id: " + crs.getInt("bid_id")
							+ "\ntask title: " + crs.getString("title") + "\ntask description: "
							+ crs.getString("description") + "\nwork field: " + crs.getString("work_field")
							+ "\ntask deadline: " + simpleDateFormat.format(crs.getTimestamp("deadline"))
							+ "\nlocation: " + crs.getString("location") + "\namount id: " + crs.getInt("amount")
							+ "\nrating: " + crs.getDouble("rating") + "\npro username: " + crs.getString("username")
							+ "\nbid_time: " + crs.getTimestamp("bid_time") + "\n");
				}
			}
			// findDetailsByProfessionalUserID
			System.out.println("\n================findDetailsByProfessionalUserID(100)");
			crs = taskService.findDetailsByProfessionalUserID(100);
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					System.out.println("task id: " + crs.getInt("task_id") + "\nbid id: " + crs.getInt("bid_id")
							+ "\ntask title: " + crs.getString("title") + "\ntask description: "
							+ crs.getString("description") + "\nwork field: " + crs.getString("work_field")
							+ "\ntask deadline: " + simpleDateFormat.format(crs.getTimestamp("deadline"))
							+ "\nlocation: " + crs.getString("location") + "\namount id: " + crs.getInt("amount")
							+ "\nrating: " + crs.getDouble("rating") + "\npro username: " + crs.getString("username")
							+ "\nbid_time: " + crs.getTimestamp("bid_time") + "\n");
				}
			}
			// findDetailsByProfession
			System.out.println("\n============================================findDetailsByProfession(\"Developer\")");
			crs = taskService.findDetailsByProfession("Developer");
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					// System.out.println("task id: " + crs.getInt("task_id") +
					// "\ntask title: " + crs.getString("title")
					// + "\ndescription: " + crs.getString("description") +
					// "\nworkfield: "
					// + crs.getString("work_field") + "\nlocation: " +
					// crs.getString("location")
					// + "\ncontract time: " + crs.getTimestamp("deadline") +
					// "\namount: " + crs.getInt("amount")
					// + "\npro username: " + crs.getString("username") +
					// "\nrating: " + crs.getDouble("rating")
					// + "\nbid_time: " + crs.getTimestamp("bid_time") + "\n");
				}
			}
			System.out.println("\n============================================findDetailsByProfession(\"\")");
			crs = taskService.findDetailsByProfession("");
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					// System.out.println("task id: " + crs.getInt("task_id") +
					// "\ntask title: " + crs.getString("title")
					// + "\ndescription: " + crs.getString("description") +
					// "\nworkfield: "
					// + crs.getString("work_field") + "\nlocation: " +
					// crs.getString("location")
					// + "\ncontract time: " + crs.getTimestamp("deadline") +
					// "\namount: " + crs.getInt("amount")
					// + "\npro username: " + crs.getString("username") +
					// "\nrating: " + crs.getDouble("rating")
					// + "\nbid_time: " + crs.getTimestamp("bid_time") + "\n");
				}
			}
			// findDetailsByDeadlineDesc
			System.out.println("\n============================================findDetailsByDeadlineDesc(10)");
			crs = taskService.findDetailsByDeadlineDesc(10);
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					// System.out.println("task id: " + crs.getInt("task_id") +
					// "\ntask title: " + crs.getString("title")
					// + "\ndescription: " + crs.getString("description") +
					// "\nworkfield: "
					// + crs.getString("work_field") + "\nlocation: " +
					// crs.getString("location")
					// + "\ncontract time: " + crs.getTimestamp("deadline") +
					// "\namount: " + crs.getInt("amount")
					// + "\npro username: " + crs.getString("username") +
					// "\nrating: " + crs.getDouble("rating")
					// + "\nbid_time: " + crs.getTimestamp("bid_time") + "\n");
				}
			}
			// findDetailsByDeadlineDesc
			System.out.println("\n============================================findDetailsByDeadlineDesc(2)");
			crs = taskService.findDetailsByDeadlineDesc(2);
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					// System.out.println("task id: " + crs.getInt("task_id") +
					// "\ntask title: " + crs.getString("title")
					// + "\ndescription: " + crs.getString("description") +
					// "\nworkfield: "
					// + crs.getString("work_field") + "\nlocation: " +
					// crs.getString("location")
					// + "\ncontract time: " + crs.getTimestamp("deadline") +
					// "\namount: " + crs.getInt("amount")
					// + "\npro username: " + crs.getString("username") +
					// "\nrating: " + crs.getDouble("rating")
					// + "\nbid_time: " + crs.getTimestamp("bid_time") + "\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
