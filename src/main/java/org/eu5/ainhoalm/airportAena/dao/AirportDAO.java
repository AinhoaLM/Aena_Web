package org.eu5.ainhoalm.airportAena.dao;


import org.eu5.ainhoalm.airportAena.model.Airport;

public interface AirportDAO extends GenericDAO<Airport, Long> {
	public abstract Airport findByKey(String icao);
	public abstract Integer numberOfFreeGates(Long idAirport);
	
}
