package org.eu5.ainhoalm.airportAena.dao.impl.hibernate;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirplaneStateDAO;
import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.hibernate.Session;

public class AirplaneStateDAOHibernateImpl extends GenericDAOHibernateImpl<AirplaneState, Integer> implements AirplaneStateDAO {

	@Override
	public AirplaneState findByKey(int code) {
		List<AirplaneState> listOfObj=null;
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try{

			session.beginTransaction();
			listOfObj = session.createQuery(" from AirplaneState  where code="+code).list(); 
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}
		return (AirplaneState)listOfObj.get(0);
	}

}
