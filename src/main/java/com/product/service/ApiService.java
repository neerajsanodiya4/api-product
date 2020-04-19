package com.product.service;

import java.util.List;

import com.product.domain.RegisterForm;
import com.product.entity.CityRef;
import com.product.entity.CountryRef;
import com.product.entity.EmployeeRef;
import com.product.entity.StateRef;

public interface ApiService {
	List<EmployeeRef> getEmployies(int employeeId);

	void deleteEmployies(int employeeId);
	
	List<CountryRef> getCountries();

	EmployeeRef doRegisteration(RegisterForm registerForm);

	List<StateRef> getStateRefByCountry(int countryId);

	List<CityRef> getCityRefByState(int stateId);

}
