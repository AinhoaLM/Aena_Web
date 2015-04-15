package org.eu5.ainhoalm.airportAena.dao.hibernateTest;

import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AirplaneStateDAOHibernateTest.class,
				AirplaneDAOHibernateTest.class, 
				AirportGatesDAOHibernateTest.class})
public class AllTests {
	@AfterClass  
	public static void tearDownClass() throws Exception {   
		HibernateUtil.getSessionFactory().close();		
	} 

}
