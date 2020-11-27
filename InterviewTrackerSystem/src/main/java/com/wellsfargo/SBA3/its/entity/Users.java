package com.wellsfargo.SBA3.its.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Users")
public class Users implements Serializable{
	
	@Id
	@Column(name="userId",unique=true)	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name="firstName")
	@NotNull(message="First Name cannot be blank")
	@Size(min=5, max =30, message="First Name should have length between 5 and 30 characters")
	private String firstName;
	
	@Column(name="lastName")
	@NotNull(message="Last Name cannot be blank")
	@Size(min=3, max=25,message="Last Name should have length between 3 and 25 characters")
	private String lastName;
	
	@Column(name="email")
	@NotNull(message="Email cannot be blank")
	@Email(message="Email should be a valid email ID")
	private String email;
	
	@Column(name="mobile")
	@NotNull(message="Mobile Number cannot be blank")
	@Size(min=10,max=10,message = "Mobile Number should have 10 chars")
	@Pattern(regexp="(^$|[0-9]{10})", message="Mobile Number should contain only 10 digits")
	private String mobile;


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Users(int userId, String firstName, String lastName,String email, String mobile) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}

	public Users() {
		
	}
}
