package org.eu5.ainhoalm.airportAena.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.GenericDAO;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class GenericDAOHibernateImpl <T, Id extends Serializable> implements GenericDAO<T,Id> {

	private Class<T> claseDePersistencia;
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public GenericDAOHibernateImpl() {
		this.claseDePersistencia = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}




	@SuppressWarnings("unchecked")
	@Override
	public T findById(Id id) {
		Session session= sessionFactory.getCurrentSession();
		T object=null;
		try{
			session.beginTransaction();
			object=(T)session.get(claseDePersistencia,id);
			session.getTransaction().commit();
			return object;
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			getSessionFactory().getCurrentSession().close();
		}
		
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Session session= sessionFactory.getCurrentSession();
		List<T> listOfObject=null;
		try{
			session.beginTransaction();
			listOfObject = session.createQuery(" from "+claseDePersistencia.getSimpleName()).list();
			session.getTransaction().commit();
			return listOfObject;
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			getSessionFactory().getCurrentSession().close();
		}
		
	}


	@Override
	public String insert(T object) {
		Session session= sessionFactory.getCurrentSession();
		String id;
		try{
			session.beginTransaction();
			id=session.save(object).toString();
			session.getTransaction().commit();
			return id;
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			getSessionFactory().getCurrentSession().close();
		}
		
		
	}


	@Override
	public void save(T object) {
		Session session= sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			getSessionFactory().getCurrentSession().close();
		}
	}


	@Override
	public void remove(T object) {
		Session session= sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			getSessionFactory().getCurrentSession().close();
		}
	}
	
}
