package org.sned.modal.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserDetails {
	@Id
	private int Id;
	private String Name;
	public int getId() {
		return Id;
	}
	
	
	/*@OneToMany(mappedBy="userDetails",cascade=CascadeType.ALL)
	private Collection<UserRoleModal> userRoleModal=new ArrayList<UserRoleModal>();
	
	
	public Collection<UserRoleModal> getUserRoleModal() {
		return userRoleModal;
	}
	public void setUserRoleModal(Collection<UserRoleModal> userRoleModal) {
		this.userRoleModal = userRoleModal;
	}*/
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

}
