package nl.centric.webwinkel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.centric.webwinkel.dao.LoginDao;
import nl.centric.webwinkel.model.Login;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	@Transactional
	public void addLogin(Login login){
		loginDao.addLogin(login);
	}
	@Transactional
	public List<Login> getAllLogins() throws Exception{
		return loginDao.getAllLogins();
	}
	@Transactional
	public Login getLogin(String gebruikersnaam) throws Exception{
		return loginDao.getLogin(gebruikersnaam);
	}

}
