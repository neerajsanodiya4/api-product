package com.product.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.product.common.NavigationURIConstants;
import com.product.domain.Login;
import com.product.domain.RegisterForm;
import com.product.domain.ReturnResponse;

@RequestMapping(value = NavigationURIConstants.SECURITY)
public interface ApiController {
	
	@RequestMapping(value = NavigationURIConstants.GET_COUNTRY, method = RequestMethod.GET)
	ReturnResponse getCountry(String countryId);
	
	@RequestMapping(value = NavigationURIConstants.GET_STATE, method = RequestMethod.GET)
	ReturnResponse getStates(String countryId);
	
	@RequestMapping(value = NavigationURIConstants.GET_CITY, method = RequestMethod.GET)
	ReturnResponse getCities(String stateId);
	
	@RequestMapping(value = NavigationURIConstants.DO_REGISTRATION, method = RequestMethod.POST)
	ReturnResponse doRegisteration(RegisterForm registerForm);
	
	@RequestMapping(value = NavigationURIConstants.LOGIN, method = RequestMethod.POST)
	ReturnResponse login(Login login);
	
	@RequestMapping(value = NavigationURIConstants.GET_REGISTER, method = RequestMethod.GET)
	ReturnResponse getRegisteration(int employeeId);
	
	@RequestMapping(value = NavigationURIConstants.DELETE_EMPLOYEE, method = RequestMethod.DELETE)
	ReturnResponse deleteEmployee(int employeeId);
}
