package testers;

import java.sql.Timestamp;
import java.util.List;

import dao.TaskDao;
import domain.Task;

public class TaskDaoTester {

	public static void main(String[] args) {
		try {
			TaskDao task = new TaskDao();
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
					.setWorkField("mathematician"));
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
			if (task.delete(new Task().setDeadline(Timestamp.valueOf("2018-06-21 00:00:00")).setSimpleUserId(3)
					.setWorkField("mathematician").setTaskId(17))) {
				System.out.println("Deleted!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
