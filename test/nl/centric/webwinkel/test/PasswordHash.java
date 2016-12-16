package nl.centric.webwinkel.test;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import junit.framework.TestCase;

public class PasswordHash extends TestCase {
	
	public void testBcryptHash(){
		String password = "admin";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashPassword = passwordEncoder.encode(password);
		
		System.out.println("hashed bcrypt password = " + hashPassword);
	}
	
	public void testMD5Hash(){
		String password = "test1234";
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String hashPassword = passwordEncoder.encodePassword(password, null);
		
		System.out.println("hashed md5 password = " + hashPassword);
	}
}
