package org.eu5.ainhoalm.airportAena.dao.hibernate;

import java.util.List;

import org.eu5.ainhoalm.airportAena.dao.FlightDAO;
import org.eu5.ainhoalm.airportAena.model.BoardingPass;
import org.eu5.ainhoalm.airportAena.model.Flight;
import org.eu5.ainhoalm.airportAena.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class FlightDAOHibernateImpl extends GenericDAOHibernateImpl<Flight, Long> implements FlightDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<BoardingPass> reservedSeats(Long idAirplane) {
		List<BoardingPass> listOfObj=null;
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query q=session.createQuery(" select boardingPass from Flight  where idAirplane = :pid");
			q.setLong("pid",idAirplane);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<BoardingPass> boardedSeats(Long idAirplane) {
		List<BoardingPass> listOfObj=null;
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query q=session.createQuery(" select boardingPass from Flight  where idAirplane = :pid and boarded = :pboarded");
			q.setLong("pid",idAirplane);
			q.setBoolean("pboarded", true);
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

	@Override
	public Integer numberOfReservedSeats(Long idAirplane) {
		Integer number=null;
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query q=session.createQuery("select flight.boardingPass.size from Flight as flight where flight.idAirplane = :pid");
			q.setLong("pid",idAirplane);
			number= (Integer)q.uniqueResult();
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		return number;
	}

	@Override
	public Integer numberOfBoardedSeats(Long idAirplane) {
		Integer number=null;
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query q=session.createQuery("select count(*) from Flight flight inner join flight.boardingPass as boardingpass"
									+ " where flight.idAirplane = :pid  and boardingpass.boarded = :pboarded");
			q.setLong("pid",idAirplane);
			q.setBoolean("pboarded", true);
			number= ((Long)q.uniqueResult()).intValue();
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		return number;	}

}
