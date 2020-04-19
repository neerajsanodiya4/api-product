package com.product.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.product.domain.RegisterForm;
import com.product.entity.CityRef;
import com.product.entity.CompanyEntity;
import com.product.entity.EmployeeRef;

public class Mapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(Mapper.class);

	 public static void main(String[] args) {
	        
	    }
	

	public static EmployeeRef getEmployeeRef(RegisterForm registerForm) {
		LOGGER.debug("Mapper getEmployee " + registerForm.toString());
		EmployeeRef employeeRef = new EmployeeRef();
		if (registerForm.getEmployeeId() != null && Integer.parseInt(registerForm.getEmployeeId()) > 0) {
			employeeRef.setEmployeeId(Integer.parseInt(registerForm.getEmployeeId()));
		}

		employeeRef.setCityId(new CityRef(registerForm.getCityId()));
		employeeRef.setCompanyId(new CompanyEntity(registerForm.getCompanyId()));
		employeeRef.setFullName(registerForm.getFullName());
		employeeRef.setSalary(registerForm.getSalary());

		return employeeRef;

	}

}