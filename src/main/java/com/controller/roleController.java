package com.controller;

import java.util.List;
import java.util.Map;

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
import com.service.RoleService;
@CrossOrigin(origins = "*")
@RestController
public class roleController {

    @Autowired
    RoleService roleService;

    // Open HTML page
     
   // it will optional
//    @RequestMapping("/roll")
//    public String homePage() {
//        return "index";
//    }

    @PostMapping("/roleinventory")
    
    public String rollInventory(@RequestBody RoleDetails roleDetails) {
        roleService.insertingDetails(roleDetails);
        return "saved"; 
    }

    @GetMapping("/allroles")
 
    public List<RoleDetails> getallRoles() {
        return roleService.getAllRole();
    }
    @PostMapping("/mark_damagebutton")

    public String damagebutton(@RequestParam("roleId") String rollId) {
        roleService.markDamage(rollId);
        return "ok";
    }
    @PostMapping("/restorebutton")

    public String restorebutton(@RequestParam("roleId") String rollId) {
        roleService.restore(rollId);
        return "ok";
    }
    
    @GetMapping("/filter")
    public List<RoleDetails> findByStatus(@RequestParam(value = "status",required = false) String status)
    {
    	if(status==null || status.equalsIgnoreCase("All"))
    	{
    		return roleService.getAllRole(); 
    	}
    	else
    	{
    		return roleService.findByStatus(status.toUpperCase());
    	}
    	
    }
    
    @GetMapping("/counts")
    public Map<String, Long> getCounts()
    {
    	return roleService.getcounts();
    }
    
    @GetMapping("/findByRoleIdOrBatch")
	 public List<RoleDetails> findByRoleidOrBatch( @RequestParam("rollid") String rollid,@RequestParam("batch") String batch)
	{
		return roleService.findByRoleidOrBatch(rollid, batch);
	}

}