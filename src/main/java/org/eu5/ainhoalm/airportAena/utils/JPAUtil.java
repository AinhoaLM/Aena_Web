package org.eu5.ainhoalm.airportAena.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory emf = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
			return Persistence.createEntityManagerFactory("persistenceUnit");
			//return PersistenceProvi
		}catch (Throwable ex) {
			throw new RuntimeException("Error al crear la factoria de JPA");
		}
	}
	public static EntityManagerFactory getJPAFactory() {
		return emf;}

}
