package org.eu5.ainhoalm.airportAena.dao.hibernateTest;

import static org.junit.Assert.*;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirportDAO;
import org.eu5.ainhoalm.airportAena.dao.hibernate.AirportDAOHibernateImpl;
import org.eu5.ainhoalm.airportAena.model.Airport;
import org.eu5.ainhoalm.airportAena.model.AirportGates;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AirportDAOHibernateTest {
	
	static AirportDAO sut;
	String icao="TEST";
	String description="Airport Test";
	Integer nGates=3;
	String country="España";
	static ClassPathXmlApplicationContext factoria;

	@BeforeClass  
	public static void setUpClass() throws Exception {   
		sut = new AirportDAOHibernateImpl(); 
		factoria =new ClassPathXmlApplicationContext("aplicationContext.xml");
		sut= (AirportDAO)factoria.getBean("airportDAO");
		System.out.println("========================================================================================================");
		System.out.println("TEST AIRPORT (Spring)" );
		System.out.println("========================================================================================================");
	}  

	@AfterClass  
	public static void tearDownClass() throws Exception {   
		//HibernateUtil.getSessionFactory().close();  
	} 
	
	@Test
	public void findAll() throws Exception {
		System.out.println("--findAll()--->");
		List<Airport> listOfObj = sut.findAll();
		ImprimirListado(listOfObj); 
		assertNotNull("Account list is null.", listOfObj);
		assertNotEquals(0, listOfObj.size());
	}
	
	@Test
	public void findById() throws Exception {
		System.out.println("--findById()--->");
		Airport obj = sut.findById(Long.valueOf(1));
		System.out.println(obj);
		assertEquals(Long.valueOf(1),obj.getId());     
	}
	
	@Test
	public void findByKey() throws Exception {
		System.out.println("--findByKey()--->"); 
		Airport obj = sut.findByKey("LESO");
		System.out.println(obj);     
		assertEquals("LESO",obj.getIcao());
	}
	
	@Test
	public void numOfFreeGates() throws Exception {
		Integer num=null;
		num = sut.numberOfFreeGates(1l);
		System.out.println("--findByFreeGates()--->1");     
		System.out.println(num);
		assertNotNull(num);
	}
	
	@Test
	public void crudAirplane() {
		
		Airport obj= createObjAirport(icao, description, nGates,country);
		//Insertar
		System.out.println("--Insertar--->");
		String id=sut.insert(obj);	
		System.out.println(id);
		Airport objPersist = sut.findById(Long.valueOf(id));
		System.out.println(objPersist);
		assertNotNull(objPersist);
		assertEquals(obj.obtainGates().size(),objPersist.obtainGates().size());
		assertEquals(obj, objPersist);

		//Modificar
		System.out.println("--Modificar--->"); 
		String textUpdate="TEST";
		obj.setDescription(textUpdate);
		sut.save(obj);
		objPersist = sut.findById(Long.valueOf(id));
		System.out.println(objPersist);
		//assertEquals(obj,objPersist);

		//Eliminar
		System.out.println("--Eliminar--->"); 
		sut.remove(objPersist);
		objPersist = sut.findById(Long.valueOf(id));
		System.out.println(objPersist);
		assertNull(objPersist);

	}
	
	private Airport createObjAirport(String icao, String description,Integer nGates, String country){
		Airport obj = new Airport();
		obj.setIcao(icao);
		obj.setDescription(description);
		obj.setnGates(nGates);
		obj.setCountry(country);
	
		for (int i = 0; i < obj.getnGates(); i++) {
			AirportGates objGates= new AirportGates();
			objGates.setCode("P00"+i);
			objGates.setStatus(false);
			obj.addToGates(objGates);
		}
		return obj;
	}

	private void ImprimirListado(List<Airport> lista)
	 {
	  for (Object item : lista) {
	         System.out.println(item);   
	        }
	 }

}
