package org.eu5.ainhoalm.airportAena.service.impl;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.eu5.ainhoalm.airportAena.service.AirplaneStateService;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AirplaneStateServiceTest {
	static AirplaneStateService airplaneStateSERVICE=null;
	

	@BeforeClass  
	public static void setUpClass() throws Exception {   
		airplaneStateSERVICE= new AirplaneStateServiceImpl();
	}  
	
	@AfterClass  
	public static void tearDownClass() throws Exception {   
		HibernateUtil.getSessionFactory().close();  
	} 
	
	@Test
	public void findAllAirplaneState() throws Exception {
		List<AirplaneState> listOfObj = airplaneStateSERVICE.findAllAirplaneState();
		ImprimirListado(listOfObj);  
		assertNotNull("Account list is null.", listOfObj);    
	}
	
	private void ImprimirListado(List<AirplaneState> lista)
	{
		System.out.println("Listado");
		for (AirplaneState item : lista) {
			System.out.println("--findAll()--->"+item);   
		}
	}
}
