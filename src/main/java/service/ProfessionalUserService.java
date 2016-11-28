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

	public ProfessionalUser findOne(int proUserid)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.findOne(proUserid);
	}

	public List<ProfessionalUser> findActive(boolean active)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.findActive(active);
	}

	public List<ProfessionalUser> findFromLocation(String location)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.findFromLocation(location);
	}

	public List<ProfessionalUser> findAll()
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.fiandAll();
	}

	public ProfessionalUser create(ProfessionalUser professionalUser)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		// Hash the password
		professionalUser.setPassword(BCrypt.hashpw(professionalUser.getPassword(), BCrypt.gensalt(12)));
		return dao.create(professionalUser);
	}

	public boolean remove(ProfessionalUser professionalUser)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.remove(professionalUser);
	}

	public boolean update(ProfessionalUser professionalUser)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.update(professionalUser);
	}

	public ProfessionalUser authenticateByEmail(String email, String password)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		ProfessionalUser pro = dao.findByEmail(email);
		if (pro != null && BCrypt.checkpw(password, pro.getPassword()) && pro.getActive()) {
			return pro;
		} else {
			return null;
		}
	}

	public ProfessionalUser authenticateByUsername(String username, String password)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		ProfessionalUser pro = dao.findByUsername(username);
		if (pro != null && BCrypt.checkpw(password, pro.getPassword()) && pro.getActive()) {
			return pro;
		} else {
			return null;
		}
	}

	public boolean exist(String name, String value)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return dao.exist(name, value);
	}

}
