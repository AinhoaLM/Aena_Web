package org.eu5.ainhoalm.airportAena.dao.impl.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.GenericDAO;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.hibernate.Session;




public abstract class GenericDAOHibernateImpl <T, Id extends Serializable> implements GenericDAO<T,Id> {

	private Class<T> claseDePersistencia;
	//Session session=HibernateHelper.getSessionFactory().openSession();
	//session= HibernateHelper.getSessionFactory().getCurrentSession();
	
	
	@SuppressWarnings("unchecked")
	public GenericDAOHibernateImpl() {
		this.claseDePersistencia = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Id id) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		T object=null;
		try{
			session.beginTransaction();
			object=(T)session.get(claseDePersistencia,id);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		return object;
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		List<T> listOfState=null;
		try{
			session.beginTransaction();
			listOfState = session.createQuery(" from "+claseDePersistencia.getSimpleName()).list(); 
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		return listOfState;
	}


	@Override
	public String insert(T object) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		String id;
		try{
			session.beginTransaction();
			id=	session.save(object).toString();
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		return id;
		
	}


	@Override
	public void save(T object) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
	}


	@Override
	public void remove(T object) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
	}



	
	
	
}
