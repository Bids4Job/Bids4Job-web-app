package testers;

import java.sql.Timestamp;
import java.util.List;

import domain.Task;
import service.TaskService;

public class TaskServiceTester {

	public static void main(String[] args) {
		TaskService taskService = new TaskService();
		Task task;
		List<Task> tasks;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
