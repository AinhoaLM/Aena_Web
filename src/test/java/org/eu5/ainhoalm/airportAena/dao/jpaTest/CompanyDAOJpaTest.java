package org.eu5.ainhoalm.airportAena.dao.jpaTest;

import static org.junit.Assert.*;
import java.util.List;
import org.eu5.ainhoalm.airportAena.dao.jpa.CompanyDAO;
import org.eu5.ainhoalm.airportAena.model.annotation.Company;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CompanyDAOJpaTest   {
	static CompanyDAO sut=null;
	static ClassPathXmlApplicationContext factoria ;

	
	@BeforeClass  
	public static void setUpClass() throws Exception {  
		System.out.println("========================================================================================================");
		System.out.println("TEST COMPANY (Spring-JPA)" );
		System.out.println("========================================================================================================");
		factoria=new ClassPathXmlApplicationContext("aplicationContext.xml");
		sut= (CompanyDAO)factoria.getBean("companyDAO");	
		
	}  
	
	@AfterClass  
	public static void tearDownClass() throws Exception {   
		factoria.close();
	} 

	@Test
	public void findAll() throws Exception {
		System.out.println("--findByAll()--->");
		List<Company> listOfObj = sut.findAll();
		ImprimirListado(listOfObj);  
		assertNotNull("Account list is null.", listOfObj);
		   
	}

	@Test
	public void findById() throws Exception {
		System.out.println("--findById()--->");
		Company obj = sut.findById(Long.valueOf(1));
		System.out.println(obj);     
		assertEquals(Long.valueOf(1),obj.getId());
	}
	
	
	
	private void ImprimirListado(List<Company> lista)
	{
		System.out.println("Listado");
		for (Company item : lista) {
			System.out.println(item);   
		}
	}

//	@Test
//	public void crudCompany() {
//		
//		String licenseCode="99";
//		String name="Para pruebas";
//		Date expirationDate=new Date();
//		Date concessionDate= new Date();
//		
//		Company obj= new Company();
//		obj.setLicenseCode(licenseCode);
//		obj.setName(name);
//		obj.setExpirationDate(expirationDate);
//		obj.setConcessionDate(concessionDate);
//
//		//Insertar
//		System.out.println("--Insertar--->");
//		sut.insert(obj);	
//		Long id=obj.getId();
//		System.out.println(obj.getId());
//		Company objPersist = sut.findById(id);
//		assertNotNull(objPersist);
//		assertEquals(obj, objPersist);
//			
//		//Modificar
//		System.out.println("--Modificar--->");
//		String textUpdate="Para pruebas modificado";
//		obj.setName(textUpdate);		
//		sut.save(obj);
//		objPersist = sut.findById(id);
//		System.out.println(objPersist);
//		assertEquals(obj,objPersist);
//		
//		//Eliminar
//		System.out.println("--Eliminar--->"); 
//		sut.remove(objPersist);
//		objPersist = sut.findById(Long.valueOf(id));
//		System.out.println(objPersist);
//		assertNull(objPersist);
//	}

}
