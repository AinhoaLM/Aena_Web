package com.eu5.ainhoalm.airportAena.dao.impl.hibernate;



import static org.junit.Assert.*;

import java.util.List;



import org.eu5.ainhoalm.airportAena.dao.AirplaneStateDAO;
import org.eu5.ainhoalm.airportAena.dao.impl.hibernate.AirplaneStateDAOHibernateImpl;
import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AirplaneStateDAOHibernateTest {

	static AirplaneStateDAO airplaneStateDAO;

	@BeforeClass  
	public static void setUpClass() throws Exception {   
		 airplaneStateDAO = new AirplaneStateDAOHibernateImpl();   
	}  

	@AfterClass  
	public static void tearDownClass() throws Exception {   
		HibernateUtil.getSessionFactory().close();  
	} 
	
	@Test
	public void findAll() throws Exception {

		List<AirplaneState> listOfObj = airplaneStateDAO.findAll();
		assertNotNull("Account list is null.", listOfObj);
		ImprimirListado(listOfObj);     
	}

	@Test
	public void findById() throws Exception {
		AirplaneState obj = airplaneStateDAO.findById(1);
		System.out.println("--findById()--->"+obj);     
		assertEquals(Integer.valueOf(1),obj.getId());
		
	}
	
	@Test
	public void findByKey() throws Exception {

		AirplaneState obj = airplaneStateDAO.findByKey(10);
		System.out.println("--findByKey()--->"+obj);     
		assertEquals(10,obj.getCode());
	}

	private void ImprimirListado(List<AirplaneState> lista)
	{
		System.out.println("Listado");
		for (AirplaneState item : lista) {
			System.out.println("--findAll()--->"+item);   
		}
	}

	@Test
	public void crudAirplaneState() {
		int code=99;
		String description="Para pruebas";
		AirplaneState obj= new AirplaneState();
		obj.setCode(code);
		obj.setDescription(description);

		//Insertar
		String id=airplaneStateDAO.insert(obj);	
		System.out.println("--Insertar--->"+id);
		AirplaneState objPersist = airplaneStateDAO.findById(Integer.valueOf(id));

		assertNotNull(objPersist);
		assertNotEquals("", id);
		assertEquals("Código:", code,objPersist.getCode());
		assertEquals("Descripción:", description,objPersist.getDescription());
		
		//Modificar
		String textUpdate="Para pruebas modificado";
		objPersist.setDescription(textUpdate);		
		airplaneStateDAO.save(objPersist);
		objPersist = airplaneStateDAO.findById(Integer.valueOf(id));
		assertEquals("Descripción modificada:", textUpdate,objPersist.getDescription());
		System.out.println("--Modificar--->"+objPersist.getDescription());
		//Eliminar
		airplaneStateDAO.remove(objPersist);
		objPersist = airplaneStateDAO.findById(Integer.valueOf(id));
		System.out.println("--Eliminar--->"+objPersist);
		assertNull(objPersist);
	}
	
	

	 



}
