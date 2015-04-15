package org.eu5.ainhoalm.airportAena.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;




import org.eu5.ainhoalm.airportAena.dao.GenericDAO;
import org.springframework.orm.jpa.support.JpaDaoSupport;

@SuppressWarnings("deprecation")
public abstract class GenericDAOJpaImpl <T, Id extends Serializable> extends JpaDaoSupport implements GenericDAO<T,Id> {
	
	private Class<T> typeClass;

	
	@SuppressWarnings("unchecked")
	public GenericDAOJpaImpl() {
		this.typeClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public T findById(Id id) {	
		return getJpaTemplate().find(typeClass, id);

	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<T> findAll() {		
		return getJpaTemplate().find("select o from "+ typeClass.getSimpleName() + " o");
	}

	@Override
	public String insert(T object) {
		getJpaTemplate().persist(object);
		
		return "";

	}

	@Override
	public void save(T object) {
		getJpaTemplate().merge(object);
	}

	@Override
	public void remove(T object) {
		getJpaTemplate().remove(getJpaTemplate().merge(object));
		
	}

}
