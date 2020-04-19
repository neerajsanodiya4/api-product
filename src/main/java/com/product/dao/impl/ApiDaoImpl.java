package com.product.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.product.dao.ApiDao;
import com.product.domain.RegisterForm;
import com.product.entity.CityRef;
import com.product.entity.CompanyEntity;
import com.product.entity.CountryRef;
import com.product.entity.EmployeeRef;
import com.product.entity.StateRef;
import com.product.mapper.Mapper;

public class ApiDaoImpl extends HibernateDaoSupport implements ApiDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiDaoImpl.class);

	@Override
	public List<CountryRef> getCountries() {
		LOGGER.debug("getCountries");
		return getHibernateTemplate().loadAll(CountryRef.class);
	}

	@Override
	public List<StateRef> getStateRefByCountry(int countryId) {
		LOGGER.debug("getStateRefByCountry");
		@SuppressWarnings("unchecked")
		List<StateRef> stateRefs = getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("from StateRef stateRef where stateRef.countryRef.countryId = ?").setCacheable(true).setInteger(0, countryId).setCacheable(true)
				.list();
		return stateRefs;
	}

	@Override
	public List<CityRef> getCityRefByState(int stateId) {
		LOGGER.debug("getCityRefByState");
		@SuppressWarnings("unchecked")
		List<CityRef> cityRefs = getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("from CityRef cityRef where cityRef.stateRef.stateId = ?").setCacheable(true).setInteger(0, stateId).list();
		return cityRefs;
	}

	public CompanyEntity getCompany(int companyId) {
		LOGGER.debug("getCityRefByState");
		@SuppressWarnings("unchecked")
		List<CompanyEntity> companyEntities = getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("from CompanyEntity companyEntity where companyEntity.companyId = ?").setCacheable(true).setInteger(0, companyId).list();
		return companyEntities.get(0);
	}
	
	
	public CountryRef getCountryRef(int countryId) {
		LOGGER.debug("getCityRefByState");
		@SuppressWarnings({ "unchecked" })
		List<CountryRef> countryRefs = getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("from CountryRef countryRef where countryRef.countryId = ?").setCacheable(true).setInteger(0, countryId).list();
		return countryRefs.get(0);
	}
	
	public StateRef getStateRef(int stateId) {
		LOGGER.debug("getCityRefByState");
		@SuppressWarnings("unchecked")
		List<StateRef> stateRefs = getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("from StateRef stateRef where stateRef.stateId = ?").setCacheable(true).setInteger(0, stateId).list();
		return stateRefs.get(0);
	}
	
	
	
	public CityRef getCity(int cityId) {
		LOGGER.debug("getCityRefByState");
		@SuppressWarnings("unchecked")
		List<CityRef> cityRefs = getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("from CityRef cityRef where cityRef.cityId = ?").setCacheable(true).setInteger(0, cityId).list();
		return cityRefs.get(0);
	}
	
	

	@Override
	public EmployeeRef doRegisteration(RegisterForm registerForm) {
		LOGGER.debug("doRegister");
		EmployeeRef employee = Mapper.getEmployeeRef(registerForm);
		
		try {
			if (employee.getEmployeeId() > 0) {
				getHibernateTemplate().getSessionFactory().getCurrentSession().update(employee);
			} else {
				Integer id= (Integer) getHibernateTemplate().getSessionFactory().getCurrentSession().save(employee);
	
				employee.setEmployeeId(id);
			}
			employee.setCityId(getCity(registerForm.getCityId()));
			employee.setCompanyId(getCompany(registerForm.getCompanyId()));
			
			LOGGER.debug("doRegister employee Id : "+employee.toString());
			return employee;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	@Override
	public List<EmployeeRef> getEmployies(int employeeId) {
		LOGGER.debug("getCountries");
		if(employeeId>0) {
			@SuppressWarnings("unchecked")
			List<EmployeeRef> list = getHibernateTemplate().getSessionFactory().getCurrentSession()
					.createQuery("from EmployeeRef employeeRef where employeeRef.employeeId = ?").setCacheable(true).setInteger(0, employeeId).list();
			return list;
		} else
			return getHibernateTemplate().loadAll(EmployeeRef.class);
	}

	@Override
	public void deleteEmployies(int employeeId) {
	EmployeeRef employeeRef=getEmployies(employeeId).get(0);
	getHibernateTemplate().delete(employeeRef);
		
	}
}
