package service;

import dao.ProfessionalUserDao;
import domain.ProfessionalUser;

import java.sql.*;
import java.util.*;

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

    public ProfessionalUser authenticate(String email, String password)
	    throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	ProfessionalUser pro = dao.findByEmailPassword(email, password);
	if (pro != null && pro.getActive()) {
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
