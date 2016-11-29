package service;

import dao.ProfessionalUserDao;
import domain.ProfessionalUser;

import java.sql.*;
import java.util.*;

import org.mindrot.jbcrypt.BCrypt;

/**
 * 
 * @author Ioannis
 *
 */
public class ProfessionalUserService {

	private ProfessionalUserDao dao = new ProfessionalUserDao();

	/**
	 * Find a specific professional user from proUserId
	 * 
	 * @param proUserid
	 * @return the professional user with the specific id.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public ProfessionalUser findOne(int proUserid)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.findOne(proUserid);
	}

	/**
	 * Find all the professional users that has active account.
	 * 
	 * @param active
	 * @return a list of all the professional users that has active account.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<ProfessionalUser> findActive(boolean active)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.findActive(active);
	}

	/**
	 * Find all the professional users from a specific location.
	 * 
	 * @param location
	 * @return a list of professional users from a specific location.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<ProfessionalUser> findFromLocation(String location)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.findFromLocation(location);
	}

	/**
	 * Find all existing Professional Users in the database.
	 * 
	 * @return a list of all existing Professional Users
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<ProfessionalUser> findAll()
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.fiandAll();
	}

	/**
	 * Creates a Professional User in the database.
	 * 
	 * @param professionalUser
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public ProfessionalUser create(ProfessionalUser professionalUser)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		// Hash the password
		professionalUser.setPassword(BCrypt.hashpw(professionalUser.getPassword(), BCrypt.gensalt(12)));
		return dao.create(professionalUser);
	}

	/**
	 * Remove a Professional User from database.
	 * 
	 * @param professionalUser
	 * @return true if the Professional User removed, else returns false.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public boolean remove(ProfessionalUser professionalUser)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.remove(professionalUser);
	}

	/**
	 * Updates a Professional User in the database
	 * 
	 * @param professionalUser
	 * @return true if the Professional User updated, else returns false.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public boolean update(ProfessionalUser professionalUser)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.update(professionalUser);
	}

	/**
	 * Finds the Professional User with the given email and password.
	 * 
	 * @param email
	 * 		the email of the Professional User
	 * @param password
	 * 		the password of the Professional User
	 * @return the Professional User with the specified email and passsword
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public ProfessionalUser authenticateByEmail(String email, String password)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		ProfessionalUser pro = dao.findByEmail(email);
		if (pro != null && BCrypt.checkpw(password, pro.getPassword()) && pro.getActive()) {
			return pro;
		} else {
			return null;
		}
	}
	
	/**
	 * Finds the Professional User with the given username and password.
	 * 
	 * @param username
	 * 		the username of the Professional User
	 * @param password
	 * 		the password of the Professional User
	 * @return the Professional User with the specified username and password
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public ProfessionalUser authenticateByUsername(String username, String password)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		ProfessionalUser pro = dao.findByUsername(username);
		if (pro != null && BCrypt.checkpw(password, pro.getPassword()) && pro.getActive()) {
			return pro;
		} else {
			return null;
		}
	}

	/**
	 * Checks if a specified name already exists in the database
	 * 
	 * @param name
	 * @param value
	 * @return true if exists, false otherwise 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public boolean exist(String name, String value)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.exist(name, value);
	}

}
