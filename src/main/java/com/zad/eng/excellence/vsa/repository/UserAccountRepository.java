package com.zad.eng.excellence.vsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zad.eng.excellence.vsa.domain.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
	
	UserAccount findByUsername(String username);

}
