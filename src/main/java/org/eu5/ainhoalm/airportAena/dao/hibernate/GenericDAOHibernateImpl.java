package org.eu5.ainhoalm.airportAena.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.GenericDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class GenericDAOHibernateImpl <T, Id extends Serializable> implements GenericDAO<T,Id> {

	private Class<T> claseDePersistencia;
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public GenericDAOHibernateImpl() {
		this.claseDePersistencia = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public SessionFactory getSessionFactory() {return sessionFactory;}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}




	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public T findById(Id id) {	
		return (T)sessionFactory.getCurrentSession().get(claseDePersistencia, id);		
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> findAll() {
		return sessionFactory.getCurrentSession().createQuery(" from "+claseDePersistencia.getSimpleName()).list();		
	}


	@Override
	@Transactional
	public String insert(T object) {
		return sessionFactory.getCurrentSession().save(object).toString();		
	}


	@Override
	@Transactional
	public void save(T object) {
		sessionFactory.getCurrentSession().update(object);
	}


	@Override
	@Transactional
	public void remove(T object) {
		sessionFactory.getCurrentSession().delete(object);
	}
	
}
