package org.eu5.ainhoalm.airportAena.dao.hibernateTest;

import static org.junit.Assert.*;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirplaneDAO;
import org.eu5.ainhoalm.airportAena.dao.AirplaneStateDAO;
import org.eu5.ainhoalm.airportAena.dao.CompanyDAO;
import org.eu5.ainhoalm.airportAena.model.Airplane;
import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.eu5.ainhoalm.airportAena.model.Company;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AirplaneDAOHibernateTest {
	
	static AirplaneDAO sut;
	static AirplaneStateDAO state;
	static CompanyDAO company;
	static ClassPathXmlApplicationContext factoria;
	
	String id;
	String plateNumber="AAA";
	String msn ="111";
	String model="Modelo";
	int nSeats=20;
	int idCompany=1;
	AirplaneState objState;
	Company objCompany;

	@BeforeClass  
	public static void setUpClass() throws Exception {   
		factoria =new ClassPathXmlApplicationContext("aplicationContext.xml");
		sut= (AirplaneDAO)factoria.getBean("airplaneDAO");
		state= (AirplaneStateDAO)factoria.getBean("airplaneStateDAO");
		company= (CompanyDAO)factoria.getBean("companyDAOHibernate");

		System.out.println("========================================================================================================");
		System.out.println("TEST AIRPLANE (Spring)" );
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
		assertEquals("EC-LQV",obj.getPlateNumber());
	}
	
	@Test
	public void findByState() throws Exception {
		System.out.println("--findByState()--->50 Correcto");     
		List<Airplane> listOfObj = sut.findByState(50);
		ImprimirListado(listOfObj); 
		assertNotEquals(0, listOfObj.size());
	}
	
	@Test
	public void expirationDate() throws Exception {
		System.out.println("--expirationDate()-->");     
		List<Airplane> listOfObj = sut.expirationLicense();
		ImprimirListado(listOfObj); 
		assertNotNull("Account list is null.", listOfObj);
	}
	
	
	@Test
	public void crudAirplane() {
		
		Airplane obj= createObjAirplane(plateNumber, msn, model, nSeats, idCompany);
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
	
	private Airplane createObjAirplane(String plateNumber, String msn,String model, Integer nSeats, Integer idCompany){
		Airplane obj = new Airplane();
		obj.setPlateNumber(plateNumber);
		obj.setMsn(msn);
		obj.setModel(model);
		obj.setnSeats(nSeats);
		objState = state.findByKey(50);
		obj.setState(objState);
		objCompany = company.findById(1L);
		obj.setCompany(objCompany);
		
		return obj;
	}
	
	
	private void ImprimirListado(List<Airplane> lista)
	 {
	  for (Object item : lista) {
	         System.out.println(item);   
	        }
	 }
	
	
}
