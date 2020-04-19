package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="employeeRef")
@NamedQuery(name = "EmployeeRef.findAll", query = "SELECT employeeRef FROM EmployeeRef employeeRef")
public class EmployeeRef extends BaseEntity {
	private static final long serialVersionUID = -1501653108327737434L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employeeId")
	private int employeeId;
	
	@Column(name="fullName")
	private String fullName;
	
	@Column(name="price")
	private double salary;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="companyId")
	private CompanyEntity companyId;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cityId")
	private CityRef cityId;

	public EmployeeRef() {
	
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
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

	public CompanyEntity getCompanyId() {
		return companyId;
	}

	public void setCompanyId(CompanyEntity companyId) {
		this.companyId = companyId;
	}

	public CityRef getCityId() {
		return cityId;
	}

	public void setCityId(CityRef cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "EmployeeRef [employeeId=" + employeeId + ", fullName=" + fullName + ", salary=" + salary
				+ ", companyId=" + companyId + ", cityId=" + cityId + "]";
	}
	
	
	
	
}