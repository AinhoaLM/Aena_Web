package org.eu5.ainhoalm.airportAena.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirplaneDAO;
import org.eu5.ainhoalm.airportAena.model.Airplane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("airplaneDAO")
public class AirplaneDAOHibernateImpl extends GenericDAOHibernateImpl<Airplane, Long> implements AirplaneDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Airplane findByKey(String plateNumber) {
		List<Airplane> listOfObj=null;
		Session session= getSessionFactory().getCurrentSession();
		Query q=session.createQuery(" from Airplane  where plateNumber=:pt");
		q.setString("pt",plateNumber);
		listOfObj = q.list(); 
		return (Airplane)listOfObj.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Airplane> findByState(int code) {
		Session session= getSessionFactory().getCurrentSession();
		List<Airplane> listOfObj;
		Query q=session.createQuery(" from Airplane  where state.code=:pcode");
		q.setInteger("pcode", code);
		listOfObj = q.list();       
		return listOfObj;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Airplane> expirationLicense() {
		Session session= getSessionFactory().getCurrentSession();
		List<Airplane> listOfObj;
		Query q=session.createQuery(" from Airplane  where company.expirationDate < :pdate");
		q.setDate("pdate", new Date());
		listOfObj = q.list();       
		return listOfObj;
	}

}
