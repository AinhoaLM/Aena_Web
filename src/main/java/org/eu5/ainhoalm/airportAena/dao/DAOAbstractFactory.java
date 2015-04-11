package org.eu5.ainhoalm.airportAena.dao;


public abstract class DAOAbstractFactory {
	
	public static DAOFactory getInstance() {
		return new DAOHibernateFactory();
	}

}
