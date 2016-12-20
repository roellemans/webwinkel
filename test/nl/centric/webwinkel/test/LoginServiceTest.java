package nl.centric.webwinkel.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import nl.centric.webwinkel.model.Authorities;
import nl.centric.webwinkel.model.AuthoritiesPK;
import nl.centric.webwinkel.model.Users;
import nl.centric.webwinkel.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:/mvc-dispatcher-servlet.xml" })
public class LoginServiceTest {

	@Autowired
	private LoginService loginService;
	
	@Test
	public void testAddUsers(){
		Users user = maakUser("UnitTester", "unit");
		loginService.addUser(user);
	}
	
	@Test
	public void testAddAuthorities(){
		Authorities authority = maakAuthority("UnitTester", "ROLE_USER");
		loginService.addAuthority(authority);
	}	

	@Test
	public void testGetAllUsers() {
		try {
			List<Users> list = loginService.getAllUsers();
			assertTrue(list.size() > 0);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testGetUser(){
		try {
			Users user = loginService.getUser("unitTester");
			assertTrue(user != null);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	private Users maakUser(String naam, String wachtwoord){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashPassword = passwordEncoder.encode(wachtwoord);
		return new Users(naam,hashPassword);
	}
	
	private Authorities maakAuthority(String naam, String authority){
		return new Authorities(maakAuthoritiesPk(naam,authority));
	}
	
	private AuthoritiesPK maakAuthoritiesPk(String naam, String authority){
		return new AuthoritiesPK(naam,authority);
	}

}
