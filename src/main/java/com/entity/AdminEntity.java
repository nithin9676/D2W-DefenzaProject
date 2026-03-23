package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class AdminEntity {
	@Id
	//it tells create id utomatic and increase automatic
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	//we use validation dependenci because proper email wil be enter like abc@ like that
	@Email
	
	// it will box will be not blank
	@NotBlank
	@Column(nullable = false,unique = true)
	private String email;
	
	@NotBlank
	@Column(nullable = false)
	 private String password;

	public AdminEntity(int id,  String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminEntity [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	

	
	
}
