package nl.centric.webwinkel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nl.centric.webwinkel.model.Users;

@Repository
public class LoginDao {

	@PersistenceContext
	private EntityManager entityManager;

	public LoginDao() {
	}

	@Transactional
	public void addUser(Users user) {
		entityManager.persist(user);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers() throws Exception {
		Query query = entityManager.createQuery("SELECT u from Users as u");
		return query.getResultList();
	}

	@Transactional
	public Users getUser(String gebruikersnaam) throws Exception {
		Query query = entityManager.createQuery("SELECT u from Users as u where u.username = :gebruikersnaam");
		query.setParameter("gebruikersnaam", gebruikersnaam);
		return (Users) query.getSingleResult();
	}
}
