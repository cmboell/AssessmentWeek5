/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Oct 4, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Collector;


/**
 * @author cmboe
 *
 *///helper class for collector
public class CollectorHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AssessmentWeek5");
	//methods
	public void insertCollector(Collector c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	public List<Collector> showAllCollectors(){
		EntityManager em = emfactory.createEntityManager();
		List<Collector> allCollectors = em.createQuery("SELECT ch FROM Collector ch").getResultList();
		return allCollectors;
	}
	public Collector findCollector(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Collector> typedQuery = em.createQuery("SELECT ch from Collector ch where ch.collectorName = :selectedName", Collector.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Collector foundCollector;
		try {
		foundCollector = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
		foundCollector = new Collector(nameToLookUp);
		}
		em.close();
		return foundCollector;
		}
}
