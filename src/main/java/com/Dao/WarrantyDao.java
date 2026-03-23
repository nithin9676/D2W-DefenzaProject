package com.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.WarrantyEntity;
import com.repository.WarrantyRepository;

@Repository
public class WarrantyDao {
	
	@Autowired
	WarrantyRepository WarrantyRepository;
	
	public Optional<WarrantyEntity> findByroleId(String roleid)
	{
		 return WarrantyRepository.findByRoleId(roleid);
		
	}
	
	public void createWarranty(WarrantyEntity warrantyEntity)
	{
		WarrantyRepository.save(warrantyEntity);
	}
	
	public List<WarrantyEntity> getAllWarranty()
	{
		return WarrantyRepository.findAll();
	}
}
