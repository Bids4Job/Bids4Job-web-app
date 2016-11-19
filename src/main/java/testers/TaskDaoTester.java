package testers;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dao.TaskDAO;
import domain.Task;

public class TaskDaoTester {

	public static void main(String[] args) {
		CachedRowSet crs;

		try {
			TaskDAO task = new TaskDAO();
			/**
			 * Testing the findOne method of TaskDao.
			 */
			System.out.println(task.findOne(1).toString());

			/**
			 * Testing the findAll method of TaskDao.
			 */
			List<Task> xyz = task.findAll();
			for (Task q : xyz) {
				System.out.println(q);
			}
			/**
			 * Testing the create method of TaskDao.
			 */
			Task task1;
			task1 = task.create(new Task().setDeadline(Timestamp.valueOf("2017-06-21 00:00:00")).setSimpleUserId(3)
					.setTitle("My task title").setWorkField("mathematician").setDescription("what about some math?"));
			System.out.println(task1);
			/**
			 * Testing the update method of TaskDao.
			 */
			if (task.update(new Task().setDeadline(Timestamp.valueOf("2018-06-21 00:00:00")).setSimpleUserId(3)
					.setWorkField("mathematician").setTaskId(10))) {
				System.out.println("Update completed!");
				System.out.println(task.findOne(10));
			}
			/**
			 * Testing the delete method of TaskDao.
			 */
			// if (task.delete(new
			// Task().setDeadline(Timestamp.valueOf("2018-06-21
			// 00:00:00")).setSimpleUserId(3)
			// .setWorkField("mathematician").setTaskId(17))) {
			// System.out.println("Deleted!");
			// }
			System.out.println("\nfindTenTasks()");
			crs = task.findTenTasks();
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					System.out.println("task id: " + crs.getInt("task_id") + "\nbid id: " + crs.getInt("bid_id")
							+ "\namount: " + crs.getInt("amount") + "\npro username: " + crs.getString("username")
							+ "\nrating: " + crs.getDouble("rating") + "\nbid_time: " + crs.getTimestamp("bid_time")
							+ "\n");
				}
			}
			/**
			 * Testing the findDetailsBySimpleUserID method of TaskDao.
			 */
			System.out.println("\n============================================findDetailsBySimpleUserID()");
			crs = task.findDetailsBySimpleUserID(1);
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					System.out.println("task id: " + crs.getInt("task_id") + "\nbid id: " + crs.getInt("bid_id")
							+ "\namount: " + crs.getInt("amount") + "\npro username: " + crs.getString("username")
							+ "\nrating: " + crs.getDouble("rating") + "\nbid_time: " + crs.getTimestamp("bid_time")
							+ "\n");
				}
			}
			/**
			 * Testing the findDetailsByProfessionalUserID method of TaskDao.
			 */
			System.out.println("\n============================================findDetailsByProfessionalUserID()");
			crs = task.findDetailsByProfessionalUserID(2);
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					System.out.println("task id: " + crs.getInt("task_id") + "\nbid id: " + crs.getInt("bid_id")
							+ "\namount: " + crs.getInt("amount") + "\npro username: " + crs.getString("username")
							+ "\nrating: " + crs.getDouble("rating") + "\nbid_time: " + crs.getTimestamp("bid_time")
							+ "\n");
				}
			}
			System.out.println("\n============================================findDetailsByProfessionalUserID()");
			crs = task.findDetailsByProfessionalUserID(1);
			if (!crs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (crs.next()) {
					System.out.println("task id: " + crs.getInt("task_id") + "\nbid id: " + crs.getInt("bid_id")
							+ "\namount: " + crs.getInt("amount") + "\npro username: " + crs.getString("username")
							+ "\nrating: " + crs.getDouble("rating") + "\nbid_time: " + crs.getTimestamp("bid_time")
							+ "\n");
				}
			}
			/**
			 * Testing the setInactiveByID method of TaskDao.
			 */
			if (task.setInactiveByID(96)) {
				System.out.println("SetInactive completed!");
				System.out.println(task.findOne(96));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}