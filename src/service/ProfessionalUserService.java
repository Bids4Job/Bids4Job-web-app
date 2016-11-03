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
    
    public ProfessionalUser findOne(int proUserid) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.findOne(proUserid);
    }
    
    public List<ProfessionalUser> findFromLocation(String location) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
  	return dao.findFromLocation(location);
    }
    
    public List<ProfessionalUser> findAll() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	return dao.fiandAll();
    }
    
    public ProfessionalUser create(ProfessionalUser professionalUser) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
  	return dao.create(professionalUser);
    }
    
    public void remove(ProfessionalUser professionalUser) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	 dao.remove(professionalUser);
    }

    public void update(ProfessionalUser professionalUser) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	 dao.update(professionalUser);
   }
}
