package testers;

import java.sql.SQLException;
import java.util.List;

import dao.TaskDao;
import domain.Task;

public class TaskDaoTester {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

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
	}
}