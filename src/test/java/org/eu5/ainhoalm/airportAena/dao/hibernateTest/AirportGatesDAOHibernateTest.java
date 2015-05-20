package org.eu5.ainhoalm.airportAena.dao.hibernateTest;


import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirplaneStateDAO;
import org.eu5.ainhoalm.airportAena.dao.AirportGatesDAO;
import org.eu5.ainhoalm.airportAena.dao.hibernate.AirportGatesDAOHibernateImpl;
import org.eu5.ainhoalm.airportAena.model.AirportGates;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AirportGatesDAOHibernateTest {
	static AirportGatesDAO sut;
	static ClassPathXmlApplicationContext factoria;
	

	@BeforeClass  
	public static void setUpClass() throws Exception {   
		 factoria =new ClassPathXmlApplicationContext("aplicationContext.xml");
		 sut= (AirportGatesDAO)factoria.getBean("airportGatesDAO");
		 System.out.println("========================================================================================================");
		 System.out.println("TEST AIRPORT GATES (Spring)" );
		 System.out.println("========================================================================================================");
	}  

	@AfterClass  
	public static void tearDownClass() throws Exception {   
		//HibernateUtil.getSessionFactory().close();		
	} 
	
	@Test
	public void findFreeGates() throws Exception {
		List<AirportGates> listOfObj = sut.findByFreeGates(1l);
		System.out.println("--findByFreeGates()--->1");     
		ImprimirListado(listOfObj); 
		assertNotEquals(0, listOfObj.size());
	}
	
	private void ImprimirListado(List<AirportGates> lista)
	 {
	  for (Object item : lista) {
	         System.out.println(item);   
	        }
	 }
}
