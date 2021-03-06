package org.eu5.ainhoalm.airportAena.dao.jpa;


import org.eu5.ainhoalm.airportAena.dao.jpa.CompanyDAO;
import org.eu5.ainhoalm.airportAena.model.annotation.Company;
import org.springframework.stereotype.Repository;

@Repository("companyDAO")
public class CompanyDAOJpaImpl extends GenericDAOJpaImpl<Company, Long> implements CompanyDAO {

}
