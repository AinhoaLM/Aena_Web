package org.eu5.ainhoalm.airportAena.dao.jpaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;



import org.eu5.ainhoalm.airportAena.dao.CompanyDAO;
import org.eu5.ainhoalm.airportAena.model.annotation.Company;
import org.eu5.ainhoalm.airportAena.utils.JPAUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CompanyDAOJpaTest   {
	static CompanyDAO sut=null;
	static ClassPathXmlApplicationContext factoria =new ClassPathXmlApplicationContext("aplicationContext.xml");

	
	@BeforeClass  
	public static void setUpClass() throws Exception {  
		sut= (CompanyDAO)factoria.getBean("companyDAO");	
	}  

	@AfterClass  
	public static void tearDownClass() throws Exception {   
		JPAUtil.getJPAFactory().close();;  
		//factoria.close();
	} 
	
	@Test
	public void findAll() throws Exception {
		List<Company> listOfObj = sut.findAll();
		ImprimirListado(listOfObj);  
		assertNotNull("Account list is null.", listOfObj);
		   
	}

	@Test
	public void findById() throws Exception {
		Company obj = sut.findById(Long.valueOf(1));
		System.out.println("--findById()--->"+obj);     
		assertEquals(Long.valueOf(1),obj.getId());
	}
	
	private void ImprimirListado(List<Company> lista)
	{
		System.out.println("Listado");
		for (Company item : lista) {
			System.out.println("--findAll()--->"+item);   
		}
	}

	@Test
	public void crudCompany() {
		
		String licenseCode="99";
		String name="Para pruebas";
		Date expirationDate=new Date();
		Date concessionDate= new Date();
		
		Company obj= new Company();
		//obj.setId(idTemp);
		obj.setLicenseCode(licenseCode);
		obj.setName(name);
		obj.setExpirationDate(expirationDate);
		obj.setConcessionDate(concessionDate);

		//Insertar
		sut.insert(obj);	
		Long id=obj.getId();
		System.out.println("--Insertar--->"+obj.getId());
		Company objPersist = sut.findById(id);

		assertNotNull(objPersist);
		assertNotEquals("", obj.getId().toString());
		assertEquals("Código de licencia:", licenseCode,objPersist.getLicenseCode());
		assertEquals("Nombre:", name,objPersist.getName());
		
		//Modificar
		String textUpdate="Para pruebas modificado";
		objPersist.setName(textUpdate);		
		sut.save(objPersist);
		objPersist = sut.findById(id);
		assertEquals("Descripción modificada:", textUpdate,objPersist.getName());
		System.out.println("--Modificar--->"+objPersist.getName());
		
		//Eliminar
		sut.remove(objPersist);
		objPersist = sut.findById(id);
		System.out.println("--Eliminar--->"+objPersist);
		assertNull(objPersist);
	}

}
