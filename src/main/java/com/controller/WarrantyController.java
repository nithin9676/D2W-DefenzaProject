package com.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.RoleDetails;
import com.entity.WarrantyEntity;
import com.service.RoleService;
import com.service.WarrantyService;
@CrossOrigin(origins = "*")
@RestController
public class WarrantyController {
	
	@Autowired 
	WarrantyService warrantyService;
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping("/WarrantyHome")
	public void warrantyhome()
	{
		
	}
	
	@PostMapping("/createWarranty")
	
	public String creatingWarranty(@RequestBody WarrantyEntity warrantyEntity)

	{
		
	 return warrantyService.createWarranty(warrantyEntity);
		
		
	}
	
	@GetMapping("allWarranty")
	
	public List<WarrantyEntity> getAllWarranty() {
		
		
		return warrantyService.getAllWarranty();

	}
	
	@GetMapping("/checkRoll")
	public String checkrollid(@RequestParam("rollId") String rollId)
	{
		Optional<WarrantyEntity> exists=warrantyService.checkrollId(rollId);
		 
		if(!exists.isPresent())
		{
			return "Not found";
		}
		WarrantyEntity warrantyentity= exists.get();
		return warrantyentity.getRoleId();
	}
	@GetMapping("/availableroles")
	public List<RoleDetails> getAvailbleRolls()
	{
		return roleService.findByStatus("AVAILABLE");
	}
	
	@GetMapping("Find_Warranty")
	 public WarrantyEntity findByWarranty(@RequestParam("warrantyid") String warrantyid)
	 {
		 return warrantyService.findByWarrantyId(warrantyid);
	 }

}
