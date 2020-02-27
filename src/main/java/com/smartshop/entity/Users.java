package com.smartshop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="user_registration")
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int userId;
	
	@Column(name="user_name")
	@NotNull
	@NotEmpty(message="User Name should be Empty")
	private String userName;
	
	@NotNull
	@NotEmpty(message="Email Name should be Empty")
	@Email(message="Please Enter a Valid Email Id")
	private String emailId;
	
	private String gender;
	
	private String address;
	
	@Pattern(regexp = "[0-9]{10}", message = "must conatins 10 digits only")
	private String contactNumber;
	
	private int enabled;

	@Transient
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})",
	message="Password should contain least one digit, one upper case letter, one lower case letter and one special symbol (@#$%)")
	private String password;
	
	private String encodedPassword;

	@OneToOne(cascade=CascadeType.ALL)
	private Roles role;
	
	
	public String getEncodedPassword() {
		return encodedPassword;
	}

	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}
}
