package org.eu5.ainhoalm.airportAena.dao.hibernateTest;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirportDAO;
import org.eu5.ainhoalm.airportAena.dao.hibernate.AirportDAOHibernateImpl;
import org.eu5.ainhoalm.airportAena.model.AirportGates;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AirportDAOHibernateTest {
	
	static AirportDAO sut;
	

	@BeforeClass  
	public static void setUpClass() throws Exception {   
		sut = new AirportDAOHibernateImpl(); 

		System.out.println("========================================================================================================");
		System.out.println("TEST AIRPORT" );
		System.out.println("========================================================================================================");
	}  

	@AfterClass  
	public static void tearDownClass() throws Exception {   
		//HibernateUtil.getSessionFactory().close();  
	} 
	
//	@Test
//	public void findFreeGates() throws Exception {
//		List<AirportGates> listOfObj = sut.findByFreeGates(1l);
//		System.out.println("--findByFreeGates()--->1");     
//		ImprimirListado(listOfObj); 
//		assertNotEquals(0, listOfObj.size());
//	}
	
	private void ImprimirListado(List<AirportGates> lista)
	 {
	  System.out.println("Listado");
	  for (Object item : lista) {
	         System.out.println(item);   
	        }
	 }

}
