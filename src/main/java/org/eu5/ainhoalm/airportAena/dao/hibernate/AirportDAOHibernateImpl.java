package org.eu5.ainhoalm.airportAena.dao.hibernate;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirportDAO;
import org.eu5.ainhoalm.airportAena.model.Airport;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;


public class AirportDAOHibernateImpl extends GenericDAOHibernateImpl<Airport, Long> implements AirportDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Airport findByKey(String icao) {
		List<Airport> listOfObj=null;
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query q=session.createQuery(" from Airport  where icao=:i");
			q.setString("i",icao);
			listOfObj = q.list(); 
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		return (Airport)listOfObj.get(0);
	}

	@Override
	public Integer numberOfFreeGates(Long idAirport) {
		Integer number=null;
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			//Query q=session.createQuery("select count(*) from Airport as airport left join airport.gates as gates where airport.id =:pid and gates.status = :pstatus");
			Query q=session.createQuery("select count(*) from Airport as airport left join airport.gates as gates where airport.id =:pid and gates.idAirplane is null");
			q.setLong("pid",idAirport);
			number= ((Long)q.uniqueResult()).intValue();
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		return number;
	}



}
