package com.entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class WarrantyEntity {
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    @NotBlank(message = "Role Id is required")
	    @Column(nullable = false)
	    private String roleId;

	    @NotBlank(message = "Customer name is required")
	    @Column(name = "customer_name")
	    private String customerName;

	    @Email
	    @NotBlank(message = "Customer email is required")
	    @Column(name = "customer_email")
	    private String customerEmail;

	    @NotBlank(message = "Make is required")
	    private String make;

	    @NotBlank(message = "Model is required")
	    private String model;

	    @NotNull(message = "Year is required")
	    @Column(nullable = false)
	    private Integer year;

	    @NotBlank(message = "VIN Number is required")
	    @Column(name = "vin_number")
	    private String vinNumber;

	    @NotBlank(message = "Product type is required")
	    @Column(name = "product_type")
	    private String productType;

	    @NotBlank(message = "Installer name is required")
	    @Column(name = "installer_name")
	    private String installerName;

	    @NotNull(message = "Installation date is required")
	    @Column(nullable = false,name = "installation_date")
	    private LocalDate installationDate;

	    @NotBlank(message = "Warranty period is required")
	    @Column(name = "warranty_period")
	    private String warrantyPeriod;

	    // 🔹 Default Constructor
	    public WarrantyEntity() {
	        super();
	    }

	    // 🔹 Parameterized Constructor
	    public WarrantyEntity(String roleId, String customerName, String customerEmail,
	                          String make, String model, Integer year,
	                          String vinNumber, String productType,
	                          String installerName, LocalDate installationDate,
	                          String warrantyPeriod) {

	        this.roleId = roleId;
	        this.customerName = customerName;
	        this.customerEmail = customerEmail;
	        this.make = make;
	        this.model = model;
	        this.year = year;
	        this.vinNumber = vinNumber;
	        this.productType = productType;
	        this.installerName = installerName;
	        this.installationDate = installationDate;
	        this.warrantyPeriod = warrantyPeriod;
	    }

	    // 🔹 Getters & Setters

	    public String getRoleId() {
	        return roleId;
	    }

	    public void setRoleId(String roleId) {
	        this.roleId = roleId;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getCustomerEmail() {
	        return customerEmail;
	    }

	    public void setCustomerEmail(String customerEmail) {
	        this.customerEmail = customerEmail;
	    }

	    public String getMake() {
	        return make;
	    }

	    public void setMake(String make) {
	        this.make = make;
	    }

	    public String getModel() {
	        return model;
	    }

	    public void setModel(String model) {
	        this.model = model;
	    }

	    public Integer getYear() {
	        return year;
	    }

	    public void setYear(Integer year) {
	        this.year = year;
	    }

	    public String getVinNumber() {
	        return vinNumber;
	    }

	    public void setVinNumber(String vinNumber) {
	        this.vinNumber = vinNumber;
	    }

	    public String getProductType() {
	        return productType;
	    }

	    public void setProductType(String productType) {
	        this.productType = productType;
	    }

	    public String getInstallerName() {
	        return installerName;
	    }

	    public void setInstallerName(String installerName) {
	        this.installerName = installerName;
	    }

	    public LocalDate getInstallationDate() {
	        return installationDate;
	    }

	    public void setInstallationDate(LocalDate installationDate) {
	        this.installationDate = installationDate;
	    }

	    public String getWarrantyPeriod() {
	        return warrantyPeriod;
	    }

	    public void setWarrantyPeriod(String warrantyPeriod) {
	        this.warrantyPeriod = warrantyPeriod;
	    }

	    // 🔹 toString()

	    @Override
	    public String toString() {
	        return "WarrantyEntity [roleId=" + roleId +
	                ", customerName=" + customerName +
	                ", customerEmail=" + customerEmail +
	                ", make=" + make +
	                ", model=" + model +
	                ", year=" + year +
	                ", vinNumber=" + vinNumber +
	                ", productType=" + productType +
	                ", installerName=" + installerName +
	                ", installationDate=" + installationDate +
	                ", warrantyPeriod=" + warrantyPeriod + "]";
	    }
	}