package domain;

import java.sql.Timestamp;

/**
 * 
 * @author Dimitris
 */

public class Task {

	private int taskId;
	private Timestamp deadline;
	private String workField;
	private int simpleUserId;

	public int getTaskId() {
		return this.taskId;
	}

	public Task setTaskId(int taskId) {
		this.taskId = taskId;
		return this;
	}

	public Timestamp getDeadline() {
		return this.deadline;
	}

	public Task setDeadline(Timestamp deadline) {
		this.deadline = deadline;
		return this;
	}

	public String getWorkField() {
		return this.workField;
	}

	public Task setWorkField(String workField) {
		this.workField = workField;
		return this;
	}

	public int getSimpleUserId() {
		return simpleUserId;
	}

	public Task setSimpleUserId(int simpleUserId) {
		this.simpleUserId = simpleUserId;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Task)) {
			return false;
		}
		Task task = (Task) o;
		return taskId == task.taskId;
	}

	@Override
	public int hashCode() {
		return taskId;
	}

	@Override
	public String toString() {
		return "Task{" + "TaskId = " + taskId + ", Deadline = " + deadline + ", workField = " + workField
				+ ", simpleUserId = " + simpleUserId + "}";

	}
}
