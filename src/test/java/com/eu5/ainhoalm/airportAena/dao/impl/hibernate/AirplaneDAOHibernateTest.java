package com.eu5.ainhoalm.airportAena.dao.impl.hibernate;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirplaneDAO;
import org.eu5.ainhoalm.airportAena.dao.AirplaneStateDAO;
import org.eu5.ainhoalm.airportAena.dao.impl.hibernate.AirplaneDAOHibernateImpl;
import org.eu5.ainhoalm.airportAena.dao.impl.hibernate.AirplaneStateDAOHibernateImpl;
import org.eu5.ainhoalm.airportAena.model.Airplane;
import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AirplaneDAOHibernateTest {
	
	static AirplaneDAO airplaneDAO;
	static AirplaneStateDAO airplaneStateDAO;
	
	String id;
	String registration="AAA";
	String msn ="111";
	String model="Modelo";
	int nSeats=20;

	@BeforeClass  
	public static void setUpClass() throws Exception {   
		 airplaneDAO = new AirplaneDAOHibernateImpl();  
		 airplaneStateDAO = new AirplaneStateDAOHibernateImpl();
	}  

	@AfterClass  
	public static void tearDownClass() throws Exception {   
		HibernateUtil.getSessionFactory().close();  
	} 
	

	@Test
	public void findAll() throws Exception {
		List<Airplane> listOfObj = airplaneDAO.findAll();
		System.out.println("--findAll()--->");
		ImprimirListado(listOfObj); 
		assertNotNull("Account list is null.", listOfObj);
		assertNotEquals(0, listOfObj.size());
	}
	
	
	@Test
	public void findById() throws Exception {
		Airplane obj = airplaneDAO.findById(1);
		System.out.println("--findById()--->"+obj);
		assertEquals(Integer.valueOf(1),obj.getId());     
	}
	
	@Test
	public void findByKey() throws Exception {
		Airplane obj = airplaneDAO.findByKey("EC-LQV");
		System.out.println("--findByKey()--->"+obj);     
		assertEquals("EC-LQV",obj.getRegistration());
	}
	
	@Test
	public void findByState() throws Exception {
		AirplaneState obj=airplaneStateDAO.findByKey(50);
		List<Airplane> listOfObj = airplaneDAO.findByState(obj);
		System.out.println("--findByKey()--->"+obj);     
		ImprimirListado(listOfObj); 
		assertNotEquals(0, listOfObj.size());
	}
	
	
	@Test
	public void crudAirplane() {
		
		Airplane obj= createAirplane(registration, msn, model, nSeats);
		//Insertar
		String id=airplaneDAO.insert(obj);	
		System.out.println("--Insertar--->"+id);
		Airplane objPersist = airplaneDAO.findById(Integer.valueOf(id));
		
		assertNotNull(objPersist);
		assertNotEquals("", id);
		assertEquals("Matrícula:", registration,objPersist.getRegistration());
		assertEquals("Tipo:", msn,objPersist.getMsn());
		assertEquals("Modelo:", model,objPersist.getModel());
		assertEquals("Asientos:", nSeats,objPersist.getnSeats());
		
		//Modificar
		String textUpdate="Modificado";
		objPersist.setModel(textUpdate);		
		airplaneDAO.save(objPersist);
		objPersist = airplaneDAO.findById(Integer.valueOf(id));
		assertEquals("Descripción modificada:", textUpdate,objPersist.getModel());
		System.out.println("--Modificar--->"+objPersist.getModel());
		
		//Eliminar
		airplaneDAO.remove(objPersist);
		objPersist = airplaneDAO.findById(Integer.valueOf(id));
		System.out.println("--Eliminar--->"+objPersist);
		assertNull(objPersist);
		
	}
	
	private Airplane createAirplane(String registration, String msn,String model, Integer nSeats){
		Airplane obj = new Airplane();
		obj.setRegistration(registration);
		obj.setMsn(msn);
		obj.setModel(model);
		obj.setnSeats(nSeats);
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
