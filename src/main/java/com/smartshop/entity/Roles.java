package com.smartshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int id;
	
	@Column(name="roles")
	private String roles;

	public Roles(String roles) {
		super();
		this.roles = roles;
	}
public Roles() {
	// TODO Auto-generated constructor stub
}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
}

