package org.eu5.ainhoalm.airportAena.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;







import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.eu5.ainhoalm.airportAena.dao.GenericDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class GenericDAOJpaImpl <T, Id extends Serializable>  implements GenericDAO<T,Id> {
	
	private Class<T> typeClass;
	
	private EntityManagerFactory entityManagerFactory;
	
	
	@SuppressWarnings("unchecked")
	public GenericDAOJpaImpl() {
		this.typeClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
	public EntityManagerFactory getEntityManagerFactory() {return entityManagerFactory;}
	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {this.entityManagerFactory = entityManagerFactory;}


	@Override
	@Transactional
	public T findById(Id id) {	
		return entityManagerFactory.createEntityManager().find(typeClass, id);

	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<T> findAll() {		
		return entityManagerFactory.createEntityManager().createQuery("select o from "+ typeClass.getSimpleName() + " o").getResultList();
	}

	@Override
	public String insert(T object) {
		entityManagerFactory.createEntityManager().persist(object);
		return "";

	}

	@Override
	public void save(T object) {
		entityManagerFactory.createEntityManager().merge(object);
	}

	@Override
	public void remove(T object) {
		entityManagerFactory.createEntityManager().remove(object);
		
	}

}
