package org.eu5.ainhoalm.airportAena.dao.hibernateTest;

import static org.junit.Assert.*;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirplaneDAO;
import org.eu5.ainhoalm.airportAena.dao.AirplaneStateDAO;
import org.eu5.ainhoalm.airportAena.dao.hibernate.AirplaneDAOHibernateImpl;
import org.eu5.ainhoalm.airportAena.dao.hibernate.AirplaneStateDAOHibernateImpl;
import org.eu5.ainhoalm.airportAena.model.Airplane;
import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AirplaneDAOHibernateTest {
	
	static AirplaneDAO sut;
	static AirplaneStateDAO state;
	
	String id;
	String registration="AAA";
	String msn ="111";
	String model="Modelo";
	int nSeats=20;
	int idCompany=1;

	@BeforeClass  
	public static void setUpClass() throws Exception {   
		sut = new AirplaneDAOHibernateImpl(); 
		state= new AirplaneStateDAOHibernateImpl();
		System.out.println("========================================================================================================");
		System.out.println("TEST AIRPLANE" );
		System.out.println("========================================================================================================");
	}  

	@AfterClass  
	public static void tearDownClass() throws Exception {   
		//HibernateUtil.getSessionFactory().close();  
	} 
	

	@Test
	public void findAll() throws Exception {
		System.out.println("--findAll()--->");
		List<Airplane> listOfObj = sut.findAll();
		ImprimirListado(listOfObj); 
		assertNotNull("Account list is null.", listOfObj);
		assertNotEquals(0, listOfObj.size());
	}
	
	
	@Test
	public void findById() throws Exception {
		System.out.println("--findById()--->");
		Airplane obj = sut.findById(Long.valueOf(1));
		System.out.println(obj);
		assertEquals(Long.valueOf(1),obj.getId());     
	}
	
	@Test
	public void findByKey() throws Exception {
		System.out.println("--findByKey()--->"); 
		Airplane obj = sut.findByKey("EC-LQV");
		System.out.println(obj);     
		assertEquals("EC-LQV",obj.getRegistration());
	}
	
	@Test
	public void findByState() throws Exception {
		System.out.println("--findByKey()--->50 Correcto");     
		List<Airplane> listOfObj = sut.findByState(50);
		ImprimirListado(listOfObj); 
		assertNotEquals(0, listOfObj.size());
	}
	
	
	@Test
	public void crudAirplane() {
		
		Airplane obj= createObjAirplane(registration, msn, model, nSeats, idCompany);
		//Insertar
		System.out.println("--Insertar--->");
		String id=sut.insert(obj);	
		System.out.println(id);
		Airplane objPersist = sut.findById(Long.valueOf(id));
		System.out.println(objPersist);
		assertNotNull(objPersist);
		assertEquals(obj, objPersist);

		//Modificar
		System.out.println("--Modificar--->"); 
		String textUpdate="TEST";		
		obj.setModel(textUpdate);
		sut.save(obj);
		objPersist = sut.findById(Long.valueOf(id));
		System.out.println(objPersist);
		assertEquals(obj,objPersist);

		//Eliminar
		System.out.println("--Eliminar--->"); 
		sut.remove(objPersist);
		objPersist = sut.findById(Long.valueOf(id));
		System.out.println(objPersist);
		assertNull(objPersist);

	}
	
	private Airplane createObjAirplane(String registration, String msn,String model, Integer nSeats, Integer idCompany){
		Airplane obj = new Airplane();
		obj.setRegistration(registration);
		obj.setMsn(msn);
		obj.setModel(model);
		obj.setnSeats(nSeats);
		obj.setIdCompany(idCompany);
		AirplaneState objState = state.findByKey(50);
		obj.setState(objState);
		
		return obj;
	}
	
	
	private void ImprimirListado(List<Airplane> lista)
	 {
	  System.out.println("Listado");
	  for (Object item : lista) {
	         System.out.println(item);   
	        }
	 }
	
	
}
