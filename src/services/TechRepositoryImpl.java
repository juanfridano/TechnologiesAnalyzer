package services;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Account;
import entities.RequestData;
import entities.Source;
import entities.Tech;

public class TechRepositoryImpl {

	EntityManager em;

	public void emStart() {
		em = Persistence.createEntityManagerFactory("entityManager").createEntityManager();
		

	}
	public void emPersist(Object object){
		em.persist(object);
	}
	
	public void emCommitAndClose(){

		em.getTransaction().commit();
		em.close();
		
	}
	
	

	public Tech getTech(String name) {
		em.getTransaction().begin();
		try {
			Tech results = (Tech) em.createQuery("SELECT t FROM Tech t where t.techName = :value1")
					.setParameter("value1", name.toLowerCase().trim()).getSingleResult();
			return results;
		} catch (NoResultException e) {

			return null;
		}

	}

	public Source getSource(String name) {

		try {
			Source results = (Source) em.createQuery("SELECT s FROM Source s where sourceName = :value1")
					.setParameter("value1", name.toLowerCase().trim()).getSingleResult();
			return results;
		} catch (NoResultException e) {

			return null;
		}
	}

	public RequestData getRequestData(String link) {

		try {
			RequestData results = (RequestData) em.createQuery("SELECT r FROM RequestData r where link = :value1")
					.setParameter("value1", link.toLowerCase().trim()).getSingleResult();
			return results;

		} catch (NoResultException e) {

			return null;
		}
	}

	public Account getAccount(String firma) {

		try {
			Account results = (Account) em.createQuery("SELECT ab FROM Account ab where firma = :value1")
					.setParameter("value1", firma.toLowerCase().trim()).getSingleResult();
			return results;

		} catch (NoResultException e) {

			return null;
		}
	}

	public boolean eventIsDuplicate(int rd, int source, int tech) {

		Query query = em.createQuery(
				"SELECT fe FROM FoundEvents fe where requestdata_id= :rd AND source_id = :source AND tech_id = :tech");
		query.setParameter("rd", rd);
		query.setParameter("source", source);
		query.setParameter("tech", tech);

		int results = query.getResultList().size();

		if (results == 0) {
			return false;
		} else {
			return true;
		}

	}

}
