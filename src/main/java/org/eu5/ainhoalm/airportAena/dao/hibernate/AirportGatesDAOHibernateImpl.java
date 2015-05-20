package org.eu5.ainhoalm.airportAena.dao.hibernate;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirportGatesDAO;
import org.eu5.ainhoalm.airportAena.model.AirportGates;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("airportGatesDAO")
public class AirportGatesDAOHibernateImpl extends GenericDAOHibernateImpl<AirportGates, Long> implements AirportGatesDAO  {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<AirportGates> findByFreeGates(Long idAirport) {
		Session session= getSessionFactory().getCurrentSession();
		List<AirportGates> listOfObj;
		Query q=session.createQuery("from AirportGates where airport.id = :pid and idAirplane is null");
		q.setLong("pid", idAirport);	
		listOfObj = q.list();       
		return listOfObj;
	}



	
	

}
