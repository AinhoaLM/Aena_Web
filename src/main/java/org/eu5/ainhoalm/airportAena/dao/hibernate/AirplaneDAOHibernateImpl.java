package org.eu5.ainhoalm.airportAena.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirplaneDAO;
import org.eu5.ainhoalm.airportAena.model.Airplane;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;


public class AirplaneDAOHibernateImpl extends GenericDAOHibernateImpl<Airplane, Long> implements AirplaneDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Airplane findByKey(String plateNumber) {
		List<Airplane> listOfObj=null;
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query q=session.createQuery(" from Airplane  where plateNumber=:pt");
			q.setString("pt",plateNumber);
			listOfObj = q.list(); 
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		return (Airplane)listOfObj.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Airplane> findByState(int code) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		List<Airplane> listOfObj;
		try{
		session.beginTransaction();
		Query q=session.createQuery(" from Airplane  where state.code=:pcode");
		q.setInteger("pcode", code);
		listOfObj = q.list();       
        session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		return listOfObj;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Airplane> expirationLicense() {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		List<Airplane> listOfObj;
		try{
		session.beginTransaction();
		Query q=session.createQuery(" from Airplane  where company.expirationDate < :pdate");
		q.setDate("pdate", new Date());
		listOfObj = q.list();       
        session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		return listOfObj;
	}

}
