package org.eu5.ainhoalm.airportAena.dao.hibernate;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirportDAO;
import org.eu5.ainhoalm.airportAena.model.Airport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("airportDAO")
public class AirportDAOHibernateImpl extends GenericDAOHibernateImpl<Airport, Long> implements AirportDAO {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Airport findByKey(String icao) {
		List<Airport> listOfObj=null;
		Session session= getSessionFactory().getCurrentSession();
		Query q=session.createQuery(" from Airport  where icao=:i");
		q.setString("i",icao);
		listOfObj = q.list(); 
		return (Airport)listOfObj.get(0);
	}

	@Override
	@Transactional
	public Integer numberOfFreeGates(Long idAirport) {
		Integer number=null;
		Session session= getSessionFactory().getCurrentSession();
		//Query q=session.createQuery("select count(*) from Airport as airport left join airport.gates as gates where airport.id =:pid and gates.status = :pstatus");
		Query q=session.createQuery("select count(*) from Airport as airport left join airport.gates as gates where airport.id =:pid and gates.idAirplane is null");
		q.setLong("pid",idAirport);
		number= ((Long)q.uniqueResult()).intValue();
		return number;
	}



}
