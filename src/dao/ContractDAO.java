package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Contract;

/**
 * Class for accessing database data regarding Contracts.
 * 
 * @author george
 *
 */
public class ContractDAO {

	// Necessary fields to connect to DB, execute queries and store the result
	// sets.
	private static final String CONTRACT_TABLE = "Contract";
	private static final String CONTRACT_ID = "contract_ID";
	private static final String TASK_ID = "task_id";
	private static final String BID_ID = "bid_id";
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
		String sql = "UPDATE " + CONTRACT_TABLE + " SET " + BID_ID + "=?, " + TASK_ID + "=?, " + CONTRACT_TIME
				+ "=? WHERE " + CONTRACT_ID + "=?;";
		this.prepareResources();
		try {
			conn = DaoUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, contract.getBidID());
			preStmt.setInt(2, contract.getTaskID());
			preStmt.setTimestamp(3, contract.getContractTime());
			preStmt.setInt(4, contract.getContractID());
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
		String sql = "SELECT " + CONTRACT_TABLE + ".* FROM " + CONTRACT_TABLE + " INNER JOIN Bid ON Bid.bid_ID = "
				+ CONTRACT_TABLE + "." + BID_ID + " WHERE Bid.pro_user_ID = ?;";
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
		String sql = "SELECT " + CONTRACT_TABLE + ".* FROM " + CONTRACT_TABLE + " INNER JOIN Task ON Task.task_ID = "
				+ CONTRACT_TABLE + "." + TASK_ID + " WHERE Task.simple_user_ID = ?;";
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
		String sql = "SELECT " + CONTRACT_TABLE + ".* FROM " + CONTRACT_TABLE + " INNER JOIN Task ON Task.task_ID = "
				+ CONTRACT_TABLE + "." + TASK_ID + " INNER JOIN Simple_User ON Simple_User.simple_user_ID = Task.simple_user_ID"
				+ " WHERE Simple_User.location = ?;";
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
	 * Utility method that takes a result set and returns a Contract object.
	 *
	 * @param resultSet
	 * @return A Contract object
	 * @throws SQLException
	 */
	private static Contract populate(ResultSet resultSet) throws SQLException {
		return new Contract().setContractID(resultSet.getInt(CONTRACT_ID)).setTaskID(resultSet.getInt(TASK_ID))
				.setBidID(resultSet.getInt(BID_ID)).setContractTime(resultSet.getTimestamp(CONTRACT_TIME));
	}
}
