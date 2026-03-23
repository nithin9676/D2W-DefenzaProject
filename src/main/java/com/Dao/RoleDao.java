package com.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.entity.RoleDetails;
import com.repository.RoleRepository;

@Repository
public class RoleDao {
	@Autowired
	RoleRepository rolerepository;
	
	
	public void insertingDetails(RoleDetails roleDetails)
	{
		rolerepository.save(roleDetails);
	}
	
	public Optional<RoleDetails> findByRoleId(String rollId) {
		return rolerepository.findById(rollId);
		
	}
	
	public List<RoleDetails> getAllRoles()
	{
		return rolerepository.findAll();
	}
	
	public List<RoleDetails> findByStatus(String status)
	{
		 return rolerepository.findByStatus(status);
	}
	
	public long getallcount( )
	{
		return rolerepository.count();
	}
	public long getAvailableCount()
	{
		return rolerepository.countByStatus("AVAILABLE");
	}
	public long getUsedCount()
	{
		return rolerepository.countByStatus("USED");
	}
	public long getDamagedCount()
	{
		return rolerepository.countByStatus("DAMAGED");
	}

}
