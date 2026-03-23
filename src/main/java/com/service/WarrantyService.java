package com.service;

import com.repository.RoleRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.RoleDao;
import com.Dao.WarrantyDao;
import com.entity.RoleDetails;
import com.entity.WarrantyEntity;
import com.exception.RoleNotfounException;

@Service
public class WarrantyService {
	
	 ;

	@Autowired
	RoleDao roleDao;
	
	@Autowired
	WarrantyDao warrantyDao;

	
	
	public String createWarranty(WarrantyEntity warrantyEntity) {
		
		//exists its a box optional class is just a box it contains data we cannot use directly optional class
		Optional<RoleDetails> exists=roleDao.findByRoleId(warrantyEntity.getRoleId());
		
		if(!exists.isPresent())
		{
			throw new RoleNotfounException(" Roll Id not found");
		}
		
			//here we extracting data from optional classs
			RoleDetails role=exists.get();
			
			//Checking status
			if(!role.getStatus().equalsIgnoreCase("AVAILABLE"))
			{
				throw new RoleNotfounException("Role is not AVAILABLE ");
			}
			if(!role.getStatus().equalsIgnoreCase("DAMAGED"))
			{
				throw new RoleNotfounException("Damage cannot be use");
			}
			
			Optional<WarrantyEntity> alredy=warrantyDao.findByroleId(warrantyEntity.getRoleId());
			if(alredy.isPresent())
			{
				throw new RoleNotfounException("Warranty already exists for this roll");
			}
			
			//adding auto fileds
			
			warrantyEntity.setYear(LocalDate.now().getYear());
			warrantyEntity.setInstallationDate(LocalDate.now());
			
			warrantyDao.createWarranty(warrantyEntity);
			
			role.setStatus("USED");
			roleDao.insertingDetails(role);
			return "warranty Created succesfully";
			
		}
	
	public  List<WarrantyEntity> getAllWarranty() {
		
		return warrantyDao.getAllWarranty();
		
	}
	
	public Optional<WarrantyEntity> checkrollId(String rollId)
	{
		 return warrantyDao.findByroleId(rollId);
	}

}
