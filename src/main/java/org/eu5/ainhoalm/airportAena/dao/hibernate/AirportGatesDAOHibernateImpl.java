package org.eu5.ainhoalm.airportAena.dao.hibernate;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirportGatesDAO;
import org.eu5.ainhoalm.airportAena.model.AirportGates;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class AirportGatesDAOHibernateImpl extends GenericDAOHibernateImpl<AirportGates, Long> implements AirportGatesDAO  {

	@SuppressWarnings("unchecked")
	@Override
	public List<AirportGates> findByFreeGates(Long idAirport) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		List<AirportGates> listOfObj;
		try{
			session.beginTransaction();
			Query q=session.createQuery("from AirportGates where airport.id = :pid and status = :pstatus");
			q.setLong("pid", idAirport);
			q.setBoolean("pstatus", true);
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
