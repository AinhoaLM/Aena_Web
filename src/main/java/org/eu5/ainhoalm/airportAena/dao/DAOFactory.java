package org.eu5.ainhoalm.airportAena.dao;

public interface DAOFactory {
	public AirplaneStateDAO getAirplaneStateDAO();
	public AirplaneDAO getAirplaneDAO();
}
