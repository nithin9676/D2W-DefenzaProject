package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AdminEntity;
import com.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/Adminlogin")
	public String adminlogin()
	{
		return "AdminLogin";
	}
	
	@PostMapping("/admindetailsinserting")
	public String insertingdetails(@RequestBody AdminEntity admindetails)
	{
		 return adminService.insertingAdminDetails(admindetails);
		
	}
	
	@PostMapping("/AdminLogin")
	public String adminLogin(@RequestBody AdminEntity adminentity)
	{
		return adminService.adminlogin(adminentity.getEmail(), adminentity.getPassword());
	}

}
