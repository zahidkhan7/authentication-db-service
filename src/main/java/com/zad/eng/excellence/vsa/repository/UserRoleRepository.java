package com.zad.eng.excellence.vsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zad.eng.excellence.vsa.domain.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
	
	UserRole findByName(String name);

}
