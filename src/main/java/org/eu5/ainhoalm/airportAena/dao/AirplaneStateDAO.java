package org.eu5.ainhoalm.airportAena.dao;

import org.eu5.ainhoalm.airportAena.model.AirplaneState;

public interface AirplaneStateDAO extends GenericDAO<AirplaneState, Integer> {
	public abstract AirplaneState findByKey(int code);
}
