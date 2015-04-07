package org.eu5.ainhoalm.airportAena.dao.impl.hibernate;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirplaneStateDAO;
import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class AirplaneStateDAOHibernateImpl extends GenericDAOHibernateImpl<AirplaneState, Integer> implements AirplaneStateDAO {

	@SuppressWarnings("unchecked")
	@Override
	public AirplaneState findByKey(int code) {
		List<AirplaneState> listOfObj=null;
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try{

			session.beginTransaction();
			Query q = session.createQuery("from AirplaneState  where code = :pcode");
			q.setInteger("pcode", code);
			listOfObj = q.list(); 
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		return (AirplaneState)listOfObj.get(0);
	}

}
