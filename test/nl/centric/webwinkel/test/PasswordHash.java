package nl.centric.webwinkel.test;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import junit.framework.TestCase;

public class PasswordHash extends TestCase {
	
	public void testMD5Hash(){
		
		String password = "test1234";
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String hashPassword = passwordEncoder.encodePassword(password, null);
		
		System.out.println("hashed password = " + hashPassword);
	}
}
