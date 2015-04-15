package org.eu5.ainhoalm.airportAena.dao.hibernate;


import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirportDAO;
import org.eu5.ainhoalm.airportAena.model.Airport;
import org.eu5.ainhoalm.airportAena.model.AirportGates;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;



public class AirportDAOHibernateImpl extends GenericDAOHibernateImpl<Airport, Long> implements AirportDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<AirportGates> findByFreeGates(Long idAirport) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		List<AirportGates> listOfObj=null;
		try{
			session.beginTransaction();
		
			Query q=session.createQuery("select A.gates from Airport A where A.id = :pid");
			q.setLong("pid", idAirport);
			//q.setBoolean("pstatus", true);
			listOfObj=q.list();
			       
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
