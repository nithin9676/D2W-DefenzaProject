package com.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.entity.RoleDetails;

public interface RoleRepository extends JpaRepository<RoleDetails, String> {
	List<RoleDetails> findByStatus(String status);
	
	long countByStatus(String status);
 List<RoleDetails> findByRoleidContainingOrBatchContaining(String rollid, String batch);

}
