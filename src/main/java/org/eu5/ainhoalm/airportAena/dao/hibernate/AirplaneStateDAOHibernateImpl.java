package org.eu5.ainhoalm.airportAena.dao.hibernate;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.AirplaneStateDAO;
import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

public class AirplaneStateDAOHibernateImpl extends GenericDAOHibernateImpl<AirplaneState, Long> implements AirplaneStateDAO {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public AirplaneState findByKey(int code) {
		List<AirplaneState> listOfObj=null;
		Session session= getSessionFactory().getCurrentSession();
		Query q = session.createQuery("from AirplaneState  where code = :pcode");
		q.setInteger("pcode", code);
		listOfObj = q.list(); 
		return (AirplaneState)listOfObj.get(0);
	}

}
