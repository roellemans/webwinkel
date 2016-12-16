package nl.centric.webwinkel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.centric.webwinkel.dao.LoginDao;
import nl.centric.webwinkel.model.Users;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	@Transactional
	public void addUser(Users user){
		loginDao.addUser(user);
	}
	@Transactional
	public List<Users> getAllUsers() throws Exception{
		return loginDao.getAllUsers();
	}
	@Transactional
	public Users getUser(String gebruikersnaam) throws Exception{
		return loginDao.getUser(gebruikersnaam);
	}

}
