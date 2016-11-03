package service;

import java.sql.SQLException;
import java.util.List;

import dao.ContractDAO;
import domain.Contract;

public class ContractService {

	private ContractDAO contractDAO = new ContractDAO();

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
		return contractDAO.findOne(contractID);
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
		return contractDAO.findAll();
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
		return contractDAO.create(contract);
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
		return contractDAO.update(contract);
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
		return contractDAO.delete(contract);
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
		return contractDAO.findByBidID(bidID);
	}

	/**
	 * Finds the Contract with the given task ID.
	 * 
	 * @param taskID
	 * @return The Contract with the specified task ID
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Contract findByTaskID(int taskID)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		return contractDAO.findByTaskID(taskID);
	}

	/**
	 * Finds all Contracts in the database from a specified Professional User.
	 *
	 * @param proUserID
	 * @return A list with all Contracts based on pro user ID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<Contract> findByProUserID(int proUserID)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return contractDAO.findByProUserID(proUserID);
	}

	/**
	 * Finds all Contracts in the database from a specified Simple User.
	 * 
	 * @param simpleUserID
	 * @return A list with all Contracts based on simple user ID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<Contract> findBySimpleUserID(int simpleUserID)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return contractDAO.findBySimpleUserID(simpleUserID);
	}

	/**
	 * Finds all Contracts in the database from a specified location.
	 *
	 * @param location
	 * @return A list with all Contracts based on location
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<Contract> findByLocation(String location)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return contractDAO.findByLocation(location);
	}

	/**
	 * Finds all Contracts that were signed later than the specified contract
	 * time.
	 *
	 * @param timestampStr
	 * @return A list with all Contracts based on contract time
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<Contract> findByContractTime(String timestampStr)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return contractDAO.findByContractTime(timestampStr);
	}

}
