package org.eu5.ainhoalm.airportAena.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sf=  buildSessionFactory();

	private static SessionFactory buildSessionFactory(){
		try{
			Configuration cfg = new Configuration().configure();


			ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			return cfg.buildSessionFactory(serviceRegistry);


		} catch(Throwable e){
			System.err.println("Error creando una factoria de sesión:"+e);
			throw new ExceptionInInitializerError(e);}

	}

	public static SessionFactory getSessionFactory() {return sf;}
	
	
	
}
