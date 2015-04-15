package org.eu5.ainhoalm.airportAena.dao.hibernateTest;



import static org.junit.Assert.*;

import java.util.List;




import org.eu5.ainhoalm.airportAena.dao.AirplaneStateDAO;
//import org.eu5.ainhoalm.airportAena.dao.DAOAbstractFactory;
//import org.eu5.ainhoalm.airportAena.dao.DAOFactory;
import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AirplaneStateDAOHibernateTest {

	static AirplaneStateDAO sut=null;
	static ClassPathXmlApplicationContext factoria;

	@BeforeClass  
	public static void setUpClass() throws Exception {   
		 //airplaneStateDAO = new AirplaneStateDAOHibernateImpl();   
		//DAOFactory factoriaDAO=  DAOAbstractFactory.getInstance();
		//airplaneStateDAO = factoriaDAO.getAirplaneStateDAO();
		factoria =new ClassPathXmlApplicationContext("aplicationContext.xml");
		sut= (AirplaneStateDAO)factoria.getBean("airplaneStateDAO");
		System.out.println("========================================================================================================");
		System.out.println("TEST AIRPLANESTATE (Spring)" );
		System.out.println("========================================================================================================");
		
		
	}  

	@AfterClass  
	public static void tearDownClass() throws Exception {   
		//HibernateUtil.getSessionFactory().close();  
		factoria.close();
	} 
	
	@Test
	public void findAll() throws Exception {
		System.out.println("--findByAll()--->");
		List<AirplaneState> listOfObj = sut.findAll();
		ImprimirListado(listOfObj);  
		assertNotNull("Account list is null.", listOfObj);
		   
	}

	@Test
	public void findById() throws Exception {
		System.out.println("--findById()--->");
		AirplaneState obj = sut.findById(Long.valueOf(1));
		System.out.println(obj);     
		assertEquals(Long.valueOf(1),obj.getId());
		
	}
	
	@Test
	public void findByKey() throws Exception {
		System.out.println("--findByKey()--->"); 
		AirplaneState obj = sut.findByKey(10);
		System.out.println(obj);     
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
		String description="Para test";
		AirplaneState obj= new AirplaneState();
		obj.setCode(code);
		obj.setDescription(description);

		//Insertar
		System.out.println("--Insertar--->"); 
		String id=sut.insert(obj);	
		AirplaneState objPersist = sut.findById(Long.valueOf(id));
		System.out.println(objPersist);
		assertNotNull(objPersist);
		assertEquals(obj, objPersist);
		
		//Modificar
		System.out.println("--Modificar--->"); 
		String textUpdate="Para test modificado";		
		obj.setDescription(textUpdate);
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
	
	

	 



}
