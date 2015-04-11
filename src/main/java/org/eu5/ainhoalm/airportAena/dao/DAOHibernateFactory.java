package org.eu5.ainhoalm.airportAena.dao;

import org.eu5.ainhoalm.airportAena.dao.hibernate.AirplaneDAOHibernateImpl;
import org.eu5.ainhoalm.airportAena.dao.hibernate.AirplaneStateDAOHibernateImpl;

public class DAOHibernateFactory implements DAOFactory{
	
	public AirplaneStateDAO getAirplaneStateDAO() {
		return new AirplaneStateDAOHibernateImpl();
	}
	
	public AirplaneDAO getAirplaneDAO() {
		return new AirplaneDAOHibernateImpl();
	}
}
