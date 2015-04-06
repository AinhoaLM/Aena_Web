package org.eu5.ainhoalm.airportAena.dao;

import java.util.List;

import org.eu5.ainhoalm.airportAena.model.Airplane;
import org.eu5.ainhoalm.airportAena.model.AirplaneState;

public interface AirplaneDAO {
	public abstract int insert(Airplane airplane);
	public abstract int remove(Airplane airplane);
	public abstract int save(Airplane airplane);
	public abstract List<Airplane> findAll();
	public abstract Airplane findByKey(String registration);
	public abstract List<Airplane> findByState(AirplaneState state);
}
