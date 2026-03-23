package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Dao.Admindao;
import com.entity.AdminEntity;
import com.exception.RoleAlreadyExist;
import com.exception.RoleNotfounException;

@Service
public class AdminService {
	@Autowired
	Admindao admindao;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String insertingAdminDetails(AdminEntity admindetails)
	{
		
		Optional<AdminEntity> existing = admindao.findingemailid(admindetails.getEmail());

		if(existing.isPresent()) {
		    throw new RoleNotfounException("Email id already used");
		} else {
			
			admindetails.setPassword(passwordEncoder.encode(admindetails.getPassword()));
		
			
		    admindao.insertingdetails(admindetails);
		    return "Admin Registered succesfully";
		}
	}
	
	public String adminlogin(String email, String passwrod)
	{
		 Optional<AdminEntity> admin=admindao.findingemailid(email);
		 if(!admin.isPresent())
		 {
			 throw new RoleAlreadyExist("user not found");
		 }
		 if(!passwordEncoder.matches(passwrod, admin.get().getPassword()))
		 {
			 throw new RoleAlreadyExist("Invaild Username or Passwrod");
		 }
		 return "Login successful";
	}

}
