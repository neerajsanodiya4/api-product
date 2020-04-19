package com.product.rest.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.common.CommonUtils;
import com.product.common.NavigationConstants;
import com.product.domain.Login;
import com.product.domain.RegisterForm;
import com.product.domain.ReturnResponse;
import com.product.entity.CityRef;
import com.product.entity.CountryRef;
import com.product.entity.EmployeeRef;
import com.product.entity.StateRef;
import com.product.rest.controller.ApiController;
import com.product.service.ApiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Admin", description = "List of Admin Services", tags = {"Admin API"})
@RestController
public class ApiControllerImpl implements ApiController{
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiControllerImpl.class);

	@Autowired
	private ApiService apiService;
	
	@Override
	@ApiOperation(value="Get All States by countryId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ReturnResponse.class),
	@ApiResponse(code = 403, message = "FORBIDDEN"),
	@ApiResponse(code = 422, message = "Country_NOT_FOUND"),
	@ApiResponse(code = 417, message ="EXCEPTION_FAILED") })
	public ReturnResponse getStates(@PathVariable String countryId) {
		
			LOGGER.debug("Getting all getStates details controller begin");
			List<StateRef> stateRef = apiService.getStateRefByCountry(Integer.parseInt(countryId));
			LOGGER.debug("Getting all getStates details controller end");
			if (stateRef != null && stateRef.size()>0) {
				return CommonUtils.getHttpStatusResponse(NavigationConstants.SUCCESS, HttpStatus.OK, stateRef, null);
			} else
				return CommonUtils.getHttpStatusResponse(NavigationConstants.NO_RECORDS, HttpStatus.PRECONDITION_FAILED,
						null, null);
 
		
	}
	
	@Override
	@ApiOperation(value="Get All Cities by stateId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ReturnResponse.class),
	@ApiResponse(code = 403, message = "FORBIDDEN"),
	@ApiResponse(code = 422, message = "Country_NOT_FOUND"),
	@ApiResponse(code = 417, message ="EXCEPTION_FAILED") })
	public ReturnResponse getCities(@PathVariable String stateId) {
		LOGGER.debug("Getting all getCities details controller begin");
		List<CityRef> cittRefs = apiService.getCityRefByState(Integer.parseInt(stateId));
		LOGGER.debug("Getting all getCities details controller end");
		if (cittRefs != null && cittRefs.size()>0) {
			return CommonUtils.getHttpStatusResponse(NavigationConstants.SUCCESS, HttpStatus.OK, cittRefs, null);
		} else
			return CommonUtils.getHttpStatusResponse(NavigationConstants.NO_RECORDS, HttpStatus.PRECONDITION_FAILED,
					null, null);
	}
	
	@Override
	@ApiOperation(value="Get All County")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ReturnResponse.class),
	@ApiResponse(code = 403, message = "FORBIDDEN"),
	@ApiResponse(code = 422, message = "Country_NOT_FOUND"),
	@ApiResponse(code = 417, message ="EXCEPTION_FAILED") })
	public ReturnResponse getCountry(@RequestParam(required=false)String countryId) {
		LOGGER.debug("Getting all getStates details controller begin");
		List<CountryRef> countryRefs = apiService.getCountries();
		LOGGER.debug("Getting all getStates details controller end");
		if (countryRefs != null) {
			return CommonUtils.getHttpStatusResponse(NavigationConstants.SUCCESS, HttpStatus.OK, countryRefs, null);
		} else
			return CommonUtils.getHttpStatusResponse(NavigationConstants.NO_RECORDS, HttpStatus.PRECONDITION_FAILED,
					null, null);
	}
	
	@Override
	@ApiOperation(value="Insert Employee Data ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ReturnResponse.class),
	@ApiResponse(code = 403, message = "FORBIDDEN"),
	@ApiResponse(code = 422, message = "Country_NOT_FOUND"),
	@ApiResponse(code = 417, message ="EXCEPTION_FAILED") })
	public ReturnResponse doRegisteration(@RequestBody RegisterForm registerForm) {
		EmployeeRef employee=apiService.doRegisteration(registerForm);
		if (employee.getEmployeeId()>0) {
			return CommonUtils.getHttpStatusResponse(NavigationConstants.SUCCESS, HttpStatus.OK,employee, null);
		} else
			return CommonUtils.getHttpStatusResponse(NavigationConstants.FAILURE, HttpStatus.NO_CONTENT,
					NavigationConstants.INSERT_FAILURE, null);
	}
	
	@Override
	@ApiOperation(value="Get Registered user by employeeId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ReturnResponse.class),
	@ApiResponse(code = 403, message = "FORBIDDEN"),
	@ApiResponse(code = 422, message = "Country_NOT_FOUND"),
	@ApiResponse(code = 417, message ="EXCEPTION_FAILED") })
	public ReturnResponse getRegisteration(@RequestParam(required=false)int  employeeId) {
		LOGGER.debug("getRegisteration details controller begin");
		List<EmployeeRef> countryRefs = apiService.getEmployies(employeeId);
		LOGGER.debug("getRegisteration details controller end");
		if (countryRefs != null) {
			return CommonUtils.getHttpStatusResponse(NavigationConstants.SUCCESS, HttpStatus.OK, countryRefs, null);
		} else
			return CommonUtils.getHttpStatusResponse(NavigationConstants.NO_RECORDS, HttpStatus.PRECONDITION_FAILED,
					null, null);
	}
	
	@Override
	@ApiOperation(value="Delete Registered user by employeeId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ReturnResponse.class),
	@ApiResponse(code = 403, message = "FORBIDDEN"),
	@ApiResponse(code = 422, message = "Country_NOT_FOUND"),
	@ApiResponse(code = 417, message ="EXCEPTION_FAILED") })
	public ReturnResponse deleteEmployee(@PathVariable int employeeId) {
		apiService.deleteEmployies(employeeId);
		return CommonUtils.getHttpStatusResponse(NavigationConstants.SUCCESS, HttpStatus.OK, "Deleted Successfull", null);
	}

	@Override
	@ApiOperation(value="POST Login")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ReturnResponse.class),
	@ApiResponse(code = 403, message = "FORBIDDEN"),
	@ApiResponse(code = 422, message = "Country_NOT_FOUND"),
	@ApiResponse(code = 417, message ="EXCEPTION_FAILED") })
	public ReturnResponse login(@RequestBody Login login) {
		if(login!=null){
			if(login.getUserName().equalsIgnoreCase("neeraj") && login.getPassword().equalsIgnoreCase("neeraj")){
				return CommonUtils.getHttpStatusResponse("Login Successfull", HttpStatus.OK, login, null);
			}
		}
		return CommonUtils.getHttpStatusResponse(NavigationConstants.FAILURE, HttpStatus.NO_CONTENT, "Invalid user name && Password", null);
	}
	
	
	

}
