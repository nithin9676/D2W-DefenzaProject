package com.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.management.relation.RoleInfoNotFoundException;
import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.RoleDao;

import com.entity.RoleDetails;
import com.exception.RoleAlreadyExist;
import com.exception.RoleNotfounException;

@Service 
public class RoleService {
	@Autowired
	RoleDao roleDao;
	
	public void insertingDetails(RoleDetails roledetails)
	{
		Optional<RoleDetails> exists=roleDao.findByRoleId(roledetails.getRoleid());
		if(exists.isPresent())
		{
			throw new RoleAlreadyExist("Role Already exists with id: "+roledetails.getRoleid());
		}
		else
		{
			 
			
			if(roledetails.getBatch()==null || roledetails.getBatch().isEmpty())
			{
			roledetails.setBatch("Batch "+LocalDate.now().toString());
			}
			
			roledetails.setStatus("AVAILABLE");
			roledetails.setAddedDate(LocalDate.now());
			roleDao.insertingDetails(roledetails);
	
			
		}
	}
	
	public void markDamage(String rollid)
	{
		//exists is abox which contain roledetais data
		Optional<RoleDetails> exists=roleDao.findByRoleId(rollid);
		
		//we are checking the in the box data is available or not 
		if(exists.isPresent())
		{
			
			//here we are getting data from the box
			RoleDetails roll=exists.get();
			roll.setStatus("DAMAGED");
			
			//saved in databse
			roleDao.insertingDetails(roll);
		}
		else
		{
			throw new RoleNotfounException(" RoleNot Found with Id "+rollid);
		}
	}
	
	
	public void restore(String rollid)
	{
		Optional<RoleDetails> exists=roleDao.findByRoleId(rollid);
		if(exists.isPresent())
		{
			RoleDetails roll=exists.get();
			
			roll.setStatus("AVAILABLE");
			roleDao.insertingDetails(roll);
		}
		else
		{
			throw new RoleNotfounException("Role not found"+rollid);
		}
	}
	
	public List<RoleDetails> getAllRole() {
		 return roleDao.getAllRoles();
		
	}
	
	
	public List<RoleDetails> findByStatus(String status)
	{
		return roleDao.findByStatus(status);
	}
	
	public Map<String, Long> getcounts()
	{
		Map<String, Long> map=new HashMap<>();
		map.put("total", roleDao.getallcount());
		map.put("available", roleDao.getAvailableCount());
		map.put("used", roleDao.getUsedCount());
		map.put("damaged", roleDao.getDamagedCount());
		return map;
	}

}
