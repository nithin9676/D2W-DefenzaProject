package com.entity;

import java.time.LocalDate;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class RoleDetails {
	
	@Id
	@Column(name="role_id",unique = true,nullable = false)
	private String roleid;
	
	private String batch;
	private String status;
	@Column(name = "added_date")
	private LocalDate addedDate;
	
	private long quantity;
	

	public RoleDetails() {
		super();
	}

	public RoleDetails(String roleId, String batch, String status, LocalDate addedDate, long quantity) {
		super();
		this.roleid = roleId;
		this.batch = batch;
		this.status = status;
		this.addedDate = addedDate;
		this.quantity = quantity;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleId) {
		this.roleid = roleId;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDate addedDate) {
		this.addedDate = addedDate;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "RoleDetails [roleId=" + roleid + ", batch=" + batch + ", status=" + status + ", addedDate=" + addedDate
				+ ", quantity=" + quantity + "]";
	}
	
	


	
	
	

}
