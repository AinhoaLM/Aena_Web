package org.eu5.ainhoalm.airportAena.dao.impl.hibernate;




import java.util.List;
import org.eu5.ainhoalm.airportAena.dao.AirplaneDAO;
import org.eu5.ainhoalm.airportAena.model.Airplane;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;


public class AirplaneDAOHibernateImpl extends GenericDAOHibernateImpl<Airplane, Long> implements AirplaneDAO {



	@SuppressWarnings("unchecked")
	@Override
	public Airplane findByKey(String registration) {
		List<Airplane> listOfObj=null;
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query q=session.createQuery(" from Airplane  where registration=:r");
			q.setString("r",registration);
			listOfObj = q.list(); 
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		return (Airplane)listOfObj.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Airplane> findByState(int code) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		List<Airplane> listOfObj;
		try{
		session.beginTransaction();
		Query q=session.createQuery(" from Airplane  where state.code=:pcode");
		q.setInteger("pcode", code);
		listOfObj = q.list();       
        session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		return listOfObj;
	}

}
