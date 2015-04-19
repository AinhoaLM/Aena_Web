package org.eu5.ainhoalm.airportAena.dao.hibernateTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;







import org.eu5.ainhoalm.airportAena.dao.FlightDAO;
import org.eu5.ainhoalm.airportAena.dao.hibernate.FlightDAOHibernateImpl;
import org.eu5.ainhoalm.airportAena.model.BoardingPass;
import org.eu5.ainhoalm.airportAena.model.Flight;
import org.junit.BeforeClass;
import org.junit.Test;

public class FlightDAOHibernateTest {
	
	static FlightDAO sut;
	
	@BeforeClass  
	public static void setUpClass() throws Exception {   
		sut = new FlightDAOHibernateImpl(); 
		

		System.out.println("========================================================================================================");
		System.out.println("TEST FLIGHT DAO" );
		System.out.println("========================================================================================================");
	}  

	

	@Test
	public void findAll() throws Exception {
		System.out.println("--findAll()--->");
		List<Flight> listOfObj = sut.findAll();
		ImprimirListado(listOfObj); 
		assertNotNull("Account list is null.", listOfObj);
		assertNotEquals(0, listOfObj.size());
	}
	
	@Test
	public void listReservedSeats() throws Exception {
		System.out.println("--listReservedSeats()--->");
		List<BoardingPass> listOfObj = sut.reservedSeats(Long.valueOf(1));
		ImprimirListadoBoardingPass(listOfObj); 
		assertNotNull("Account list is null.", listOfObj);
		
	}
	
	@Test
	public void listBoardedSeats() throws Exception {
		System.out.println("--listBoardedSeats()--->");
		List<BoardingPass> listOfObj = sut.boardedSeats(Long.valueOf(1));
		ImprimirListadoBoardingPass(listOfObj); 
		assertNotNull("Account list is null.", listOfObj);
		
	}
	
	@Test
	public void numOfReservedSeats() throws Exception {
		Integer num=null;
		num = sut.numberOfReservedSeats(1l);
		System.out.println("--numOfReservedSeats()--->1");     
		System.out.println(num);
		assertNotNull(num);
	}
	
	@Test
	public void numOfBoardedSeats() throws Exception {
		Integer num=null;
		num = sut.numberOfBoardedSeats(1l);
		System.out.println("--numOfBoardedSeats()--->1");     
		System.out.println(num);
		assertNotNull(num);
	}
	
	private void ImprimirListado(List<Flight> lista)
	 {
	  for (Object item : lista) {
	         System.out.println(item);   
	        }
	 }
	
	private void ImprimirListadoBoardingPass(List<BoardingPass> lista)
	 {
	  for (Object item : lista) {
	         System.out.println(item);   
	        }
	 }

}
