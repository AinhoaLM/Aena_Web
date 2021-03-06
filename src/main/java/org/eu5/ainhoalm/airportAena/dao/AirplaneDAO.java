package org.eu5.ainhoalm.airportAena.dao;

import java.util.List;

import org.eu5.ainhoalm.airportAena.model.Airplane;

public interface AirplaneDAO extends GenericDAO<Airplane, Long> {
	public abstract Airplane findByKey(String plateNumber);
	public abstract List<Airplane> findByState(int code);
	public List<Airplane> expirationLicense();
	//public List<Airplane> airportInSpain();
}
