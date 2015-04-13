package org.eu5.ainhoalm.airportAena.service.implTest;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirplaneStateDAO;
import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.eu5.ainhoalm.airportAena.service.AirplaneStateService;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AirplaneStateServiceTest {
	
	static AirplaneStateService service=null;
	static AirplaneStateDAO dao= null;
	static private ClassPathXmlApplicationContext factoria =new ClassPathXmlApplicationContext("aplicationContext.xml");
	

	@BeforeClass  
	public static void setUpClass() throws Exception {   
		service=(AirplaneStateService)factoria.getBean("airplaneStateSERVICE");
		//dao=(AirplaneStateDAO)factoria.getBean("airplaneStateDAO");
		//service.setAirplaneSateDAO(dao);
	}  
	
	@AfterClass  
	public static void tearDownClass() throws Exception {   
		HibernateUtil.getSessionFactory().close();
		factoria.close();
	} 
	
	@Test
	public void findAllAirplaneState() throws Exception {
		List<AirplaneState> listOfObj = service.findAllAirplaneState();
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
