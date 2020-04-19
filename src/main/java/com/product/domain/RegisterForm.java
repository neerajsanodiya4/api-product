package com.product.domain;

import com.product.entity.BaseEntity;

public class RegisterForm extends BaseEntity {
	private static final long serialVersionUID = -1501653108327737434L;
	
	private String employeeId;
	private String fullName;
	private double salary;
	private int companyId;
	private int countryId;
	private int stateId;
	private int cityId;
	public RegisterForm() {

	}
	public RegisterForm(String employeeId, String fullName, double salary, int companyId, int countryId, int stateId,
			int cityId) {
		super();
		this.employeeId = employeeId;
		this.fullName = fullName;
		this.salary = salary;
		this.companyId = companyId;
		this.countryId = countryId;
		this.stateId = stateId;
		this.cityId = cityId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	@Override
	public String toString() {
		return "RegisterForm [employeeId=" + employeeId + ", fullName=" + fullName + ", salary=" + salary
				+ ", companyId=" + companyId + ", countryId=" + countryId + ", stateId=" + stateId + ", cityId="
				+ cityId + "]";
	}
	
	
}
