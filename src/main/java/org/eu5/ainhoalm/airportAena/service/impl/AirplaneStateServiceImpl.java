package org.eu5.ainhoalm.airportAena.service.impl;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirplaneStateDAO;
//import org.eu5.ainhoalm.airportAena.dao.DAOAbstractFactory;
//import org.eu5.ainhoalm.airportAena.dao.DAOFactory;
import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.eu5.ainhoalm.airportAena.service.AirplaneStateService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AirplaneStateServiceImpl implements AirplaneStateService{

	private AirplaneStateDAO airplaneStateDAO=null;
	//private ClassPathXmlApplicationContext factoria =new ClassPathXmlApplicationContext("aplicationContext.xml");
	
	public AirplaneStateServiceImpl() {
		//DAOFactory factory=DAOAbstractFactory.getInstance();
		//airplaneStateDAO= factory.getAirplaneStateDAO();
		//airplaneStateDAO =(AirplaneStateDAO)factoria.getBean("airplaneStateDAO");	
	}
	
	@Override
	public AirplaneStateDAO getAirplaneStateDAO() {
		return airplaneStateDAO;
	}

	@Override
	public void setAirplaneSateDAO(AirplaneStateDAO airplaneStateDAO) {
		this.airplaneStateDAO = airplaneStateDAO;
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
		return airplaneStateDAO.findByKey(code);
	}

	@Override
	public AirplaneState findByIdAirplaneState(Long id) {
		return airplaneStateDAO.findById(id);
	}

	
	

}
