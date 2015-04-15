package org.eu5.ainhoalm.airportAena.dao;

import java.util.List;
import org.eu5.ainhoalm.airportAena.model.AirportGates;

public interface AirportGatesDAO extends GenericDAO<AirportGates, Long> {
	public abstract List<AirportGates> findByFreeGates(Long idAirport);

}
