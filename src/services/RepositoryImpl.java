package services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Account;
import entities.FoundEvents;
import entities.RequestData;
import entities.Source;
import entities.Tech;
import services.TechParameterBuilder.TechParameters;

public class RepositoryImpl implements Repository {

	private static EntityManager em; 
	private Date firstDate = new Date();
	private RequestData requestData;
	private Source source;

	@Override
	public void persistObject(TechParameters params) {

		em = Persistence.createEntityManagerFactory("entityManager").createEntityManager();
		em.getTransaction().begin();

		source = getSource(params.getSourceName(), params.getDomain());
		requestData = getRequestData(params.getRequestTitle(), params.getMessageDate(), params.getLink(),
				params.getFirma());

		for (String tech : params.getCategories()) {
			FoundEvents fe = new FoundEvents();
			fe.setRequestData(requestData);
			fe.setTech(getTech(tech));
			fe.setSource(source);
			if (!eventIsDuplicate(requestData.getId(), source.getId(), getTech(tech).getId())){
				em.persist(fe);
			}
			
		}

		em.getTransaction().commit();

		em.close();

	}

	@Override
	public Tech getTech(String name) {

		@SuppressWarnings("unchecked")
		List<Tech> results = em.createQuery("SELECT t FROM Tech t where t.techName = :value1")
				.setParameter("value1", name.toLowerCase().trim()).getResultList();

		if (results.isEmpty()) {
			Tech tech = new Tech();
			tech.setTechName(name.toLowerCase().trim());
			em.persist(tech);
			return tech;
		} else {
			return results.get(0);
		}
	}

	@Override
	public Source getSource(String name, String domain) {

		@SuppressWarnings("unchecked")
		List<Source> results = em.createQuery("SELECT s FROM Source s where sourceName = :value1")
				.setParameter("value1", name.toLowerCase().trim()).getResultList();

		if (results.isEmpty()) {
			firstDate.setTime(System.currentTimeMillis());
			Source source = new Source();
			source.setDomain(domain);
			source.setSourceName(name.toLowerCase().trim());
			source.setFirstEntryDate(firstDate);
			em.persist(source);
			return source;
		} else {
			return results.get(0);
		}
	}

	@Override
	public RequestData getRequestData(String requestTitle, Date messageDate, String link, String firma) {

		@SuppressWarnings("unchecked")
		List<RequestData> results = em.createQuery("SELECT r FROM RequestData r where link = :value1")
				.setParameter("value1", link.toLowerCase().trim()).getResultList();

		if (results.isEmpty()) {
			RequestData rd = new RequestData();
	//		rd.setAddressbook(getAddressBook(firma));
			rd.setLink(link.toLowerCase().trim());
			rd.setMessageDate(messageDate);
			rd.setRequestTitle(requestTitle);
			em.persist(rd);
			return rd;
		} else {
			return results.get(0);
		}
	}

	private Account getAddressBook(String firma) {
		@SuppressWarnings("unchecked")
		List<Account> results = em.createQuery("SELECT ab FROM AddressBook ab where firma = :value1")
				.setParameter("value1", firma.toLowerCase().trim()).getResultList();

		if (results.isEmpty()) {
			Account ab = new Account();
			ab.setFirma(firma.toLowerCase().trim());
			em.persist(ab);
			return ab;
		} else {
			return results.get(0);
		}
	}

	private boolean eventIsDuplicate(int rd, int source, int tech) {

		Query query = em.createQuery(
				"SELECT fe FROM FoundEvents fe where requestdata_id= :rd AND source_id = :source AND tech_id = :tech");
		query.setParameter("rd", rd);
		query.setParameter("source", source); 
		query.setParameter("tech", tech);
		
		int results = query.getResultList().size();
		
		if (results == 0){
			return false;
		}
		else{
			return true;
		}

	}

}
