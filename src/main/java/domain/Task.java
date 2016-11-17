package domain;

import java.sql.Timestamp;

/**
 * @author Dimitris
 * 
 */

public class Task {

	private String title;
	private int taskId;
	private Timestamp deadline;
	private String workField;
	private int simpleUserId;
	private int active_task;
	private String description;

	public String getTitle() {
		return this.title;
	}

	public Task setTitle(String title) {
		this.title = title;
		return this;
	}

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

	public int getActive_task() {
		return active_task;
	}

	public Task setActive_task(int active_task) {
		this.active_task = active_task;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Task setDescription(String description) {
		this.description = description;
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
		return "Task [title=" + title + ", taskId=" + taskId + ", deadline=" + deadline + ", profession=" + workField
				+ ", simpleUserId=" + simpleUserId + ", active_task=" + active_task + ", description=" + description
				+ "]";
	}
}
