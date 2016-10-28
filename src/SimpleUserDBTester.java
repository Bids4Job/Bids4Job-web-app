
public class SimpleUserDBTester {

	public static void main(String[] args) {
		SimpleUserDB query = new SimpleUserDB();
		System.out.println("Try to open and close the connection");
		query.openConnection();
		query.closeConnection();
		System.out.println("\nTry to open and close the connection once again");
		query.openConnection();
		query.closeConnection();
	}

}
