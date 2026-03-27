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
	
	
	// it will box will be not blank
	@NotBlank
	@Column(name ="user_name")
	private String userName;
	@Email
	@NotBlank
	@Column(nullable = false,unique = true)
	private String email;
	
	@NotBlank
	@Column(nullable = false)
	 private String password;
	
	@NotBlank
	private String desgination;

	public AdminEntity(int id,  String email, String password,String username ,String desgination) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.userName=username;
		this.desgination=desgination;
	}

	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	

	public String getDesgination() {
		return desgination;
	}

	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}

	@Override
	public String toString() {
		return "AdminEntity [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", desgination=" + desgination + "]";
	}

	

	
	
	

	
	
}
