package org.eu5.ainhoalm.airportAena.dao.hibernate;

import org.eu5.ainhoalm.airportAena.dao.CompanyDAO;
import org.eu5.ainhoalm.airportAena.model.Company;
import org.springframework.stereotype.Repository;


@Repository("companyDAOHibernate")
public class CompanyDAOHibernateImpl extends GenericDAOHibernateImpl<Company, Long> implements CompanyDAO {

}
