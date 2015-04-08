package org.eu5.ainhoalm.airportAena.service.impl;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirplaneStateDAO;
import org.eu5.ainhoalm.airportAena.dao.DAOAbstractFactory;
import org.eu5.ainhoalm.airportAena.dao.DAOFactory;
import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.eu5.ainhoalm.airportAena.service.AirplaneStateService;

public class AirplaneStateServiceImpl implements AirplaneStateService{

	private AirplaneStateDAO airplaneStateDAO=null;
	
	
	
	public AirplaneStateServiceImpl() {
		DAOFactory factory=DAOAbstractFactory.getInstance();
		airplaneStateDAO= factory.getAirplaneStateDAO();
		
	}

	@Override
	public void airplaneStateSave(AirplaneState airplaneState) {
		airplaneStateDAO.insert(airplaneState);
	}

	@Override
	public void airplaneStateUpdate(AirplaneState airplaneState) {
		airplaneStateDAO.save(airplaneState);	
	}

	@Override
	public void airplaneStateDelete(AirplaneState airplaneState) {
		airplaneStateDAO.remove(airplaneState);
		
	}

	@Override
	public List<AirplaneState> findAllAirplaneState() {
		return airplaneStateDAO.findAll();
	}

	@Override
	public AirplaneState findByKeyAirplaneState(int code) {
		return airplaneStateDAO.findById(code);
	}

	@Override
	public AirplaneState findByIdAirplaneState(Integer id) {
		return airplaneStateDAO.findById(id);
	}

	

}
