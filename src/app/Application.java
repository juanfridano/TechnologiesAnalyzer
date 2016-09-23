package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Tech;

public class Application {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("postgres");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Tech tech = new Tech();
		tech.setTechName("Java");
		entitymanager.persist(tech);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}

}
