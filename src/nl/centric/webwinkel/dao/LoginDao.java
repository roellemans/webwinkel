package nl.centric.webwinkel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nl.centric.webwinkel.model.Login;

@Repository
public class LoginDao {

	@PersistenceContext
	private EntityManager entityManager;

	public LoginDao() {
	}

	@Transactional
	public void addLogin(Login login) {
		entityManager.persist(login);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Login> getAllLogins() throws Exception {
		Query query = entityManager.createQuery("SELECT l from Login as l");
		return query.getResultList();
	}

	@Transactional
	public Login getLogin(String gebruikersnaam) throws Exception {
		Query query = entityManager.createQuery("SELECT l from Login as l where l.gebruikersnaam = :gebruikersnaam");
		query.setParameter("gebruikersnaam", gebruikersnaam);
		return (Login) query.getSingleResult();
	}
}
