package com.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.AdminEntity;
import com.repository.AdminRepostory;


@Repository
public class Admindao {
	
	@Autowired
	AdminRepostory adminrepostory;
	
	
	public void insertingdetails(AdminEntity admindetails)
	{
		adminrepostory.save(admindetails);
	}
	
	public Optional<AdminEntity> findingemailid(String email)
	{
		 return adminrepostory.findByEmail(email);
	}
	
	 public void deletingAdmin(AdminEntity adminEntity) 
	 {
		 
			 adminrepostory.delete(adminEntity);
	 }
	 
	 public List<AdminEntity> getalldetails()
	 {
		 return adminrepostory.findAll();
	 }
	
	

	

}
