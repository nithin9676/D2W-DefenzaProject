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
//			Optional<WarrantyEntity> alredyexist=warrantyDao.findByroleId(warrantyEntity.getRoleId());
//			if(!alredyexist.isPresent())
//			{
//				throw new RoleNotfounException("warranity alredy exist dor this role : "+warrantyEntity.getRoleId());
//			}
			
			Optional<WarrantyEntity> alredy=warrantyDao.findByroleId(warrantyEntity.getRoleId());
			if(alredy.isPresent())
			{
				throw new RoleNotfounException("Warranty already exists for this roll");
			}
			
			//adding auto fileds
			
			warrantyEntity.setYear(LocalDate.now().getYear());
			warrantyEntity.setInstallationDate(LocalDate.now());
			try{
				int years=Integer.parseInt(warrantyEntity.getWarrantyPeriod().split(" ")[0]);
				warrantyEntity.setExpiryDate(LocalDate.now().plusYears(years));
			}
			catch(Exception e)
			{
				throw new RoleNotfounException("please select the correct warinty period");
			}
			
		WarrantyEntity	saved=warrantyDao.createWarranty(warrantyEntity);
			String warrantyid=String.format("D2W-%05d", saved.getId());
			saved.setWarrantyId(warrantyid);
			warrantyDao.createWarranty(saved);
			
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
 public WarrantyEntity	findByWarrantyId(String warrantyid)
	{
	 Optional<WarrantyEntity> warrantyDetails= warrantyDao.findByWarrantyId(warrantyid);
	 if(!warrantyDetails.isPresent())
	 {
		 throw new RoleNotfounException("Warranty number not found. Please check your warranty card and try again");
	 }
	 return warrantyDetails.get();
		
	}

}
