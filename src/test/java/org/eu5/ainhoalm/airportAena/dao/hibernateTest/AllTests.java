package org.eu5.ainhoalm.airportAena.dao.hibernateTest;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AirplaneStateDAOHibernateTest.class,
				AirplaneDAOHibernateTest.class, 
				AirportDAOHibernateTest.class,
				AirportGatesDAOHibernateTest.class,
				FlightDAOHibernateTest.class})
public class AllTests {
	@AfterClass  
	public static void tearDownClass() throws Exception {   
		//HibernateUtil.getSessionFactory().close();		
	} 

}
