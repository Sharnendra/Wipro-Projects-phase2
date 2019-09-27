package com.jcombat.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Login")
public class LoginModal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Login_id")
	private int id;
	@Column(name = "Login_name")
	private String Username;
	@Column(name = "Login_password")
	private String Password;
	
	@OneToMany
	@JoinTable(name="login_role_map_tb", joinColumns=@JoinColumn(name="Login_id"), inverseJoinColumns=@JoinColumn(name="Role_id"))
	private Collection<UserRoleModal> userrole=new ArrayList<UserRoleModal>();
	
	
	public Collection<UserRoleModal> getUserrole() {
		return userrole;
	}
	public void setUserrole(Collection<UserRoleModal> userrole) {
		this.userrole = userrole;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

}
