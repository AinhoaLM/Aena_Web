package com.eu5.ainhoalm.airportAena.dao.impl.hibernate;

import static org.junit.Assert.*;


import java.util.List;

import org.eu5.ainhoalm.airportAena.model.Airplane;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

public class AirplaneTest {
	
	String id;
	String registration="AAA";
	String msn ="111";
	String model="Modelo";
	int nSeats=20;
	
	
//	@Test
//	public void createAirplane() {
//		
//		Airplane objAirplane= createAirplane(registration, msn, model, nSeats);
//		Session session= HibernateHelper.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		id=	session.save(objAirplane).toString();
//		session.getTransaction().commit();
//		HibernateHelper.getSessionFactory().close();
//		
//		assertNotNull(objAirplane);
//		assertNotEquals("", id);
//		assertEquals("Matrícula:", registration,objAirplane.getRegistration());
//		assertEquals("Tipo:", msn,objAirplane.getMsn());
//		assertEquals("Modelo:", model,objAirplane.getModel());
//		assertEquals("Asientos:", nSeats,objAirplane.getnSeats());
//		
//	}
	
	private Airplane createAirplane(String registration, String msn,String model, Integer nSeats){
		Airplane obj = new Airplane();
		obj.setRegistration(registration);
		obj.setMsn(msn);
		obj.setModel(model);
		obj.setnSeats(nSeats);
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	@Test
    public void findAll() throws Exception {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Airplane>listOfAirplane = session.createQuery(" from Airplane").list();
		assertNotNull("Account list is null.", listOfAirplane);
        ImprimirListado(listOfAirplane); 
        session.getTransaction().commit();
       // HibernateHelper.getSessionFactory().close();    
           
    }
	
	
	@SuppressWarnings("unchecked")
	@Test
    public void findAllConJoin() throws Exception {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Object>listOfAirplane = session.createQuery(" from Airplane as A left join A.state").list();
		assertNotNull("Account list is null.", listOfAirplane);
        ImprimirListadoObject(listOfAirplane); 
        session.getTransaction().commit();
        //HibernateHelper.getSessionFactory().close();    
           
    }
	
	private void ImprimirListado(List<Airplane> lista)
	 {
	  System.out.println("Listado");
	  for (Airplane item : lista) {
	         System.out.println(item);   
	        }
	 }
	
	private void ImprimirListadoObject(List<Object> lista)
	 {
	  System.out.println("Listado Object");
	  for (Object item : lista) {
	         System.out.println(item);   
	        }
	 }

	

//	@Test
//	public void findById(){
//		
//		Session session= HibernateHelper.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		Airplane objAirplane=(Airplane)session.load(Airplane.class,id);
//		session.getTransaction().commit();
//		HibernateHelper.getSessionFactory().close();
//		
//		assertNotNull(objAirplane);
//		assertEquals("Matrícula:", registration,objAirplane.getRegistration());
//		assertEquals("Tipo:", msn,objAirplane.getMsn());
//		assertEquals("Modelo:", model,objAirplane.getModel());
//		assertEquals("Asientos:", nSeats,objAirplane.getnSeats());
//	}
	
	
}
