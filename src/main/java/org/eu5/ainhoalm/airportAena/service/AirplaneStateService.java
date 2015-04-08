package org.eu5.ainhoalm.airportAena.service;

import java.util.List;

import org.eu5.ainhoalm.airportAena.model.AirplaneState;

public interface AirplaneStateService {
	public void airplaneStateSave(AirplaneState airplaneState);
	public void airplaneStateUpdate(AirplaneState airplaneState);
	public void airplaneStateDelete(AirplaneState airplaneState);
	public List<AirplaneState> findAllAirplaneState();
	public AirplaneState findByKeyAirplaneState(int code);
	public AirplaneState findByIdAirplaneState(Integer id);
}


