package org.eu5.ainhoalm.airportAena.dao;

import java.util.List;

import org.eu5.ainhoalm.airportAena.model.Airport;
import org.eu5.ainhoalm.airportAena.model.AirportGates;

public interface AirportDAO extends GenericDAO<Airport, Long> {
	public abstract List<AirportGates> findByFreeGates(Long idAirport);

}
