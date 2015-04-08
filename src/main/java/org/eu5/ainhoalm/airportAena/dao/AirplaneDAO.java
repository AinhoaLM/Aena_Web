package org.eu5.ainhoalm.airportAena.dao;

import java.util.List;

import org.eu5.ainhoalm.airportAena.model.Airplane;
import org.eu5.ainhoalm.airportAena.model.AirplaneState;

public interface AirplaneDAO extends GenericDAO<Airplane, Integer> {
	public abstract Airplane findByKey(String registration);
	public abstract List<Airplane> findByState(int code);
}
