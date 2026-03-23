package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.WarrantyEntity;

public interface WarrantyRepository extends JpaRepository<WarrantyEntity, Long>{
	
	Optional<WarrantyEntity> findByRoleId(String roleid);

}
