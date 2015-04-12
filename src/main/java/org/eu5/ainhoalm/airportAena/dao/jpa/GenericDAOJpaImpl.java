package org.eu5.ainhoalm.airportAena.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;









import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.eu5.ainhoalm.airportAena.dao.GenericDAO;
import org.eu5.ainhoalm.airportAena.utils.JPAUtil;

public abstract class GenericDAOJpaImpl <T, Id extends Serializable> implements GenericDAO<T,Id> {
	
	private Class<T> claseDePersistencia;
	//private EntityManagerFactory entityManagerFactory;
	
	//Métodos que nos permiten inyectar la dependencia de EntityMangerFactory a nuestras clases DAO
	//por medio de Spring
//	public EntityManagerFactory getEntityManagerFactory() {
//		return entityManagerFactory;
//	}
//	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
//		this.entityManagerFactory = entityManagerFactory;
//	}
	
	@SuppressWarnings("unchecked")
	public GenericDAOJpaImpl() {
		this.claseDePersistencia = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
	@Override
	public T findById(Id id) {		
		EntityManagerFactory factoriaSession = JPAUtil.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		T object = null;
		try {
			object = (T) manager.find(claseDePersistencia, id);
			return object;
		}catch(Exception e){
			//manager.getTransaction().rollback();
			throw e;
		}
		finally {
			manager.close();
		}

	}

	@Override
	public List<T> findAll() {		
		EntityManagerFactory factoriaSession = JPAUtil.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		List<T> listOfObject = null;
		try {
		TypedQuery<T> consulta = manager.createQuery("select o from "+ claseDePersistencia.getSimpleName()+ " o",claseDePersistencia);
		listOfObject = consulta.getResultList();
		return listOfObject;
		} catch(Exception e){
			//manager.getTransaction().rollback();
			throw e;
		}
		finally {
			manager.close();
		}
	}


	@Override
	public String insert(T object) {
		EntityManagerFactory factoriaSession = JPAUtil.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		String id="";
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(object);
			tx.commit();
			return id;
		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {
			manager.close();
		}

	}


	@Override
	public void save(T object) {
		EntityManagerFactory factoriaSession = JPAUtil.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.merge(object);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {
			manager.close();
		}
	}


	@Override
	public void remove(T object) {
		EntityManagerFactory factoriaSession = JPAUtil.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.remove(manager.merge(object));
			tx.commit();
		} catch(Exception e){
			manager.getTransaction().rollback();
			throw e;
		}
		finally {
			manager.close();
		}
	}

}
