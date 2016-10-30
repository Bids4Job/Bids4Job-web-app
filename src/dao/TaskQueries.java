package dao;

import java.util.Scanner;
import java.sql.*;

/**
 * If you want to try this code in your own pc just change the pass for the
 * database!!!
 */
public class TaskQueries {

	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost/bids4job_db?useSSL=false";
	public static final String USER = "root";
	public static final String PASS = "fooled!";

	public static void getTasksBySimpleUserID() {
		System.out.println("Enter the userID:");
		Scanner input = new Scanner(System.in);
		int userID = input.nextInt();
		try {
			Connection conn = null;
			Statement stmt = null;
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM TASK WHERE SIMPLE_USER_ID = " + userID;
			ResultSet tasksBySimpleUserID = stmt.executeQuery(sql);
			while (tasksBySimpleUserID.next()) {
				System.out.println(tasksBySimpleUserID.getInt(1) + "  " + tasksBySimpleUserID.getDate(2) + "  "
						+ tasksBySimpleUserID.getString(3) + "  " + tasksBySimpleUserID.getInt(4));
			}
			tasksBySimpleUserID.close();
			conn.close();
			stmt.close();
			// input.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static void getTasksByWorkField() {
		System.out.println("Enter the work field:");
		Scanner input = new Scanner(System.in);
		String workField = input.nextLine();
		try {
			Connection conn = null;
			Statement stmt = null;
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM TASK WHERE WORK_FIELD = '" + workField + "'";
			ResultSet tasksByWorkField = stmt.executeQuery(sql);
			while (tasksByWorkField.next()) {
				System.out.println(tasksByWorkField.getInt(1) + "  " + tasksByWorkField.getDate(2) + "  "
						+ tasksByWorkField.getString(3) + "  " + tasksByWorkField.getInt(4));
			}
			tasksByWorkField.close();
			conn.close();
			stmt.close();
			// input.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static void getTasksByDeadline() {
		System.out.println("Enter the deadline in a format of yyyy-mm-dd hh:mm:ss");
		Scanner input = new Scanner(System.in);
		String dateTime = input.nextLine();
		Timestamp timeStamp = Timestamp.valueOf(dateTime);
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM TASK WHERE deadline = '" + timeStamp + "'";
			ResultSet tasksByDeadline = stmt.executeQuery(sql);
			while (tasksByDeadline.next()) {
				System.out.println(tasksByDeadline.getInt(1) + "  " + tasksByDeadline.getDate(2) + "  "
						+ tasksByDeadline.getString(3) + "  " + tasksByDeadline.getInt(4));
			}
			tasksByDeadline.close();
			conn.close();
			stmt.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static void getTasksByLocation() {
		System.out.println("Enter the location");
		Scanner input = new Scanner(System.in);
		String location = input.nextLine();
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM TASK INNER JOIN SIMPLE_USER ON TASK.SIMPLE_USER_ID = SIMPLE_USER.SIMPLE_USER_ID WHERE LOCATION = '"
					+ location + "'";
			ResultSet tasksByLocation = stmt.executeQuery(sql);
			while (tasksByLocation.next()) {
				System.out.println(tasksByLocation.getInt(1) + "  " + tasksByLocation.getDate(2) + "  "
						+ tasksByLocation.getString(3) + "  " + tasksByLocation.getInt(4));
			}
			tasksByLocation.close();
			conn.close();
			stmt.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static void getTasksByLocationDeadlineWorkField() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Location");
		String location = input.nextLine();
		System.out.println("Enter the Deadline");
		String deadline = input.nextLine();
		Timestamp timeStamp = Timestamp.valueOf(deadline);
		System.out.println("Enter the Bussiness field");
		String workField = input.nextLine();

		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM TASK INNER JOIN SIMPLE_USER ON SIMPLE_USER.SIMPLE_USER_ID = TASK.SIMPLE_USER_ID WHERE LOCATION = '"
					+ location + "' AND WORK_FIELD = '" + workField + "' AND DEADLINE = '" + timeStamp + "'";
			ResultSet tasksByLocationDeadlineWorkField = stmt.executeQuery(sql);
			while (tasksByLocationDeadlineWorkField.next()) {
				System.out.println(
						tasksByLocationDeadlineWorkField.getInt(1) + "  " + tasksByLocationDeadlineWorkField.getDate(2)
								+ "  " + tasksByLocationDeadlineWorkField.getString(3) + "  "
								+ tasksByLocationDeadlineWorkField.getInt(4));
			}
			tasksByLocationDeadlineWorkField.close();
			conn.close();
			stmt.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}
