package com.jcombat.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRoleModal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Role_id")
	private int RoleId;
	@Column(name = "Role_name")
	private String RoleName;
	public int getRoleId() {
		return RoleId;
	}
	public void setRoleId(int roleId) {
		RoleId = roleId;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	
	

}
