package com.product.domain;

import java.io.Serializable;

public class RoleDto implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String roleName;
 
	public RoleDto() {
 
	}
 
	public Integer getId() {
		return id;
	}
 
	public void setId(Integer id) {
		this.id = id;
	}
 
	public String getRoleName() {
		return roleName;
	}
 
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
 
}