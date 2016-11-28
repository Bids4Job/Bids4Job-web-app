package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

import domain.Contract;

/**
 * Class for accessing database data regarding Contracts.
 * 
 * @author george
 *
 */
public class ContractDAO {

	// Necessary fields to connect to DB, execute queries and store the result
	private static final String CONTRACT_TABLE = "contract";
	private static final String CONTRACT_ID = "contract_ID";
	private static final String TASK_ID = "task_id";
	private static final String BID_ID = "bid_id";
	private static final String PRO_RATING = "rating";
	private static final String CONTRACT_TIME = "contract_time";
	private Connection conn;
	private PreparedStatement preStmt;
	private ResultSet rs;

	public ContractDAO() {
	}

	/**
	 * Sets the connection, the preparedStatement and the resultSet to null.
	 */
	private void prepareResources() {
		this.conn = null;
		this.preStmt = null;
		this.rs = null;
	}

	// CRUD operations
	/**
	 * Finds the Contract with the given ID.
	 * 
	 * @param cotractID
	 * @return The Contract with the specified ID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Contract findOne(int contractID)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Contract contract = null;
		String sql = "SELECT * FROM " + CONTRACT_TABLE + " WHERE " + CONTRACT_ID + " = ?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, contractID);
			rs = preStmt.executeQuery();
			if (rs.next()) {
				contract = ContractDAO.populate(rs);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return contract;
	}

	/**
	 * Finds all Contracts in the database.
	 *
	 * @return A list with all Contracts
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<Contract> findAll()
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		List<Contract> contracts = new ArrayList<>();
		String sql = "SELECT * FROM " + CONTRACT_TABLE + ";";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				Contract simpleUser = ContractDAO.populate(rs);
				contracts.add(simpleUser);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return contracts;
	}

	/**
	 * Adds a new Contract in the database.
	 * 
	 * @param contract
	 * @return The Contract object that was added in database
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Contract create(Contract contract)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		String sql = "INSERT INTO " + CONTRACT_TABLE + "(" + BID_ID + ", " + TASK_ID + ", " + CONTRACT_TIME
				+ ") VALUES (?, ?, ?);";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preStmt.setInt(1, contract.getBidID());
			preStmt.setInt(2, contract.getTaskID());
			preStmt.setTimestamp(3, contract.getContractTime());
			preStmt.executeUpdate();
			rs = preStmt.getGeneratedKeys();
			if (rs.next()) {
				contract.setContractID(rs.getInt(1));
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return contract;
	}

	/**
	 * Updates a Contract in database based on ID.
	 * 
	 * @param contract
	 * @return True if the update operation was succeeded, else false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public boolean update(Contract contract)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		int rowsAffected = 0;
		String sql = "UPDATE " + CONTRACT_TABLE + " SET " + BID_ID + "=?, " + PRO_RATING + "=?, " + TASK_ID + "=?, "
				+ CONTRACT_TIME + "=? WHERE " + CONTRACT_ID + "=?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, contract.getBidID());
			preStmt.setDouble(2, contract.getProRating());
			preStmt.setInt(3, contract.getTaskID());
			preStmt.setTimestamp(4, contract.getContractTime());
			preStmt.setInt(5, contract.getContractID());
			rowsAffected = preStmt.executeUpdate();
			if (rowsAffected == 1) {
				return true;
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return false;
	}

	/**
	 * Deletes a Contract from database based on ID.
	 * 
	 * @param contract
	 * @return True if the delete operation was succeeded, else false
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean delete(Contract contract)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		int rowsAffected = 0;
		String sql = "DELETE FROM " + CONTRACT_TABLE + " WHERE " + CONTRACT_ID + "=?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, contract.getContractID());
			rowsAffected = preStmt.executeUpdate();
			if (rowsAffected == 1) {
				return true;
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return false;
	}

	/**
	 * Finds the Contract with the given bid ID.
	 * 
	 * @param bidID
	 * @return The Contract with the specified bid ID
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Contract findByBidID(int bidID)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		Contract contract = null;
		String sql = "SELECT * FROM " + CONTRACT_TABLE + " WHERE " + BID_ID + " = ?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, bidID);
			rs = preStmt.executeQuery();
			if (rs.next()) {
				contract = ContractDAO.populate(rs);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return contract;
	}

	/**
	 * Finds the Contract with the given task ID.
	 * 
	 * @param bidID
	 * @return The Contract with the specified task ID
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Contract findByTaskID(int taskID)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		Contract contract = null;
		String sql = "SELECT * FROM " + CONTRACT_TABLE + " WHERE " + TASK_ID + " = ?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, taskID);
			rs = preStmt.executeQuery();
			if (rs.next()) {
				contract = ContractDAO.populate(rs);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return contract;
	}

	/**
	 * Finds all Contracts in the database from a specified Professional User.
	 *
	 * @return A list with all Contracts based on pro user ID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<Contract> findByProUserID(int proUserID)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		List<Contract> contracts = new ArrayList<>();
		String sql = "SELECT " + CONTRACT_TABLE + ".* FROM " + CONTRACT_TABLE + " INNER JOIN bid ON bid.bid_ID = "
				+ CONTRACT_TABLE + "." + BID_ID + " WHERE bid.pro_user_ID = ?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, proUserID);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				Contract simpleUser = ContractDAO.populate(rs);
				contracts.add(simpleUser);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return contracts;
	}

	/**
	 * Finds all Contracts in the database from a specified Simple User.
	 *
	 * @return A list with all Contracts based on simple user ID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<Contract> findBySimpleUserID(int simpleUserID)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		List<Contract> contracts = new ArrayList<>();
		String sql = "SELECT " + CONTRACT_TABLE + ".* FROM " + CONTRACT_TABLE + " INNER JOIN task ON task.task_ID = "
				+ CONTRACT_TABLE + "." + TASK_ID + " WHERE task.simple_user_ID = ?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, simpleUserID);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				Contract simpleUser = ContractDAO.populate(rs);
				contracts.add(simpleUser);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return contracts;
	}

	/**
	 * Finds all Contracts in the database from a specified Simple User.
	 * (pro_username, amount, rating, contract_date)
	 *
	 * @return a CachedRowSet with all Contracts(in details) based on simple
	 *         user ID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public CachedRowSet findDetailsBySimpleUserID(int simpleUserID)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		CachedRowSet crs = new CachedRowSetImpl();
		String sql = "SELECT a." + CONTRACT_ID + ", a." + CONTRACT_TIME
				+ ", a.rating, b.pro_user_id, b.amount, e.pro_username FROM " + CONTRACT_TABLE
				+ " as a INNER JOIN bid as b ON a." + BID_ID + " = b." + BID_ID
				+ " INNER JOIN pro_user as e ON e.pro_user_id = b.pro_user_id" + " INNER JOIN task as c ON b." + TASK_ID
				+ " = c." + TASK_ID + " INNER JOIN simple_user as d ON c.simple_user_id = d.simple_user_id"
				+ " WHERE d.simple_user_ID = ?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, simpleUserID);
			rs = preStmt.executeQuery();
			crs.populate(rs);
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return crs;
	}

	/**
	 * Finds all Contracts in the database from a specified location.
	 *
	 * @return A list with all Contracts based on location
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<Contract> findByLocation(String location)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		List<Contract> contracts = new ArrayList<>();
		String sql = "SELECT " + CONTRACT_TABLE + ".* FROM " + CONTRACT_TABLE + " INNER JOIN task ON task.task_ID = "
				+ CONTRACT_TABLE + "." + TASK_ID
				+ " INNER JOIN simple_user ON simple_user.simple_user_ID = task.simple_user_ID"
				+ " WHERE simple_user.location = ?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, location);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				Contract simpleUser = ContractDAO.populate(rs);
				contracts.add(simpleUser);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return contracts;
	}

	/**
	 * Finds all Contracts that were signed later than the specified contract
	 * time.
	 *
	 * @return A list with all Contracts based on contract time
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<Contract> findByContractTime(String timestampStr)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		List<Contract> contracts = new ArrayList<>();
		String sql = "SELECT * FROM " + CONTRACT_TABLE + " WHERE " + CONTRACT_TIME + " > ?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, timestampStr);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				Contract simpleUser = ContractDAO.populate(rs);
				contracts.add(simpleUser);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return contracts;
	}

	/**
	 * Finds the average rating from contracts in the database signed by the
	 * specified Professional User.
	 *
	 * @return the average rating of the specified professional user, default
	 *         value is 0.0
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public double findRatingByProUserID(int proUserID)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		double averageRating = -1;
		String sql = "SELECT AVG(" + CONTRACT_TABLE + "." + PRO_RATING + ") AS " + PRO_RATING + " FROM "
				+ CONTRACT_TABLE + " INNER JOIN bid ON bid.bid_ID = " + CONTRACT_TABLE + "." + BID_ID
				+ " WHERE bid.pro_user_ID = ?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, proUserID);
			rs = preStmt.executeQuery();
			if (rs.next()) {
				averageRating = rs.getDouble(PRO_RATING);
			}
		} finally {
			DaoUtils.closeResources(rs, preStmt, conn);
		}
		return averageRating;
	}

	/**
	 * Utility method that takes a result set and returns a Contract object.
	 *
	 * @param resultSet
	 * @return A Contract object
	 * @throws SQLException
	 */
	private static Contract populate(ResultSet resultSet) throws SQLException {
		return new Contract().setContractID(resultSet.getInt(CONTRACT_ID)).setTaskID(resultSet.getInt(TASK_ID))
				.setProRating(resultSet.getDouble(PRO_RATING)).setBidID(resultSet.getInt(BID_ID))
				.setContractTime(resultSet.getTimestamp(CONTRACT_TIME));
	}
}
