package com.controller;

import com.service.RoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AdminEntity;
import com.entity.RoleDetails;
import com.service.AdminService;
@CrossOrigin(origins = "*")
@RestController
public class AdminController {
	private final RoleService roleService;
	@Autowired
	AdminService adminService;

	AdminController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@RequestMapping("/Adminlogin")
	public String adminlogin()
	{
		return "AdminLogin";
	}
	
	@PostMapping("/admindetailsinserting")
	public String insertingdetails(@RequestBody AdminEntity admindetails, @RequestParam(value="logedemail",required = false) String logedemail)
	{
		 return adminService.insertingAdminDetails(admindetails,logedemail);
		
	}
	
	@PostMapping("/AdminLogin")
	public AdminEntity adminLogin(@RequestBody AdminEntity adminentity)
	{
		return adminService.adminlogin(adminentity.getEmail(), adminentity.getPassword());
	}
	@DeleteMapping("/deleteadmin")
	public String deleteAdmin(@RequestParam String adminEmail,
			@RequestParam String loggedInEmail) {
		return adminService.deletingAdmin(adminEmail, loggedInEmail);
	}
	@GetMapping("AllAdminDetails")
	 public List<AdminEntity> getAdminDetails()
	 {
		 return adminService.getadimindetails();
	 }
}
