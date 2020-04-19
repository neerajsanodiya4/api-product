package com.product.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.product.dao.ApiDao;
import com.product.domain.RegisterForm;
import com.product.entity.CityRef;
import com.product.entity.CountryRef;
import com.product.entity.EmployeeRef;
import com.product.entity.StateRef;
import com.product.service.ApiService;

public class ApiServiceImpl implements ApiService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiServiceImpl.class);
	@Autowired
	private ApiDao apiDao;

	public ApiDao getApiDao() {
		return apiDao;
	}

	public void setApiDao(ApiDao apiDao) {
		this.apiDao = apiDao;
	}

	@Override
	public List<StateRef> getStateRefByCountry(int countryId) {
		LOGGER.debug("getStateRefByCountry details begin");
		return apiDao.getStateRefByCountry(countryId);
	}

	@Override
	public List<CityRef> getCityRefByState(int stateId) {
		LOGGER.debug("getCityRefByState details begin");
		return apiDao.getCityRefByState(stateId);
	}

	@Override
	public List<CountryRef> getCountries() {
		return apiDao.getCountries();
	}

	@Override
	public List<EmployeeRef> getEmployies(int employeeId) {
		return apiDao.getEmployies(employeeId);
	}

	@Override
	public EmployeeRef doRegisteration(RegisterForm registerForm) {
		return apiDao.doRegisteration(registerForm);
	}

	@Override
	public void deleteEmployies(int employeeId) {
		apiDao.deleteEmployies(employeeId);
		
	}

}
