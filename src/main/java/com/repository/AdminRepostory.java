package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.AdminEntity;

public interface AdminRepostory extends JpaRepository<AdminEntity, Integer> {
	
	
	Optional<AdminEntity> findByEmail(String email);

	

}
