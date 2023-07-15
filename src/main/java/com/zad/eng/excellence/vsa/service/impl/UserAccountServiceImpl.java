package com.zad.eng.excellence.vsa.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zad.eng.excellence.vsa.domain.UserAccount;
import com.zad.eng.excellence.vsa.domain.UserRole;
import com.zad.eng.excellence.vsa.repository.UserAccountRepository;
import com.zad.eng.excellence.vsa.repository.UserRoleRepository;
import com.zad.eng.excellence.vsa.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	private final UserAccountRepository userAccountRepository;
	private final UserRoleRepository userRoleRepository;
	private final PasswordEncoder encoder;

	
	public UserAccountServiceImpl(UserAccountRepository userAccountRepository, UserRoleRepository userRoleRepository,
			PasswordEncoder encoder) {
		super();
		this.userAccountRepository = userAccountRepository;
		this.userRoleRepository = userRoleRepository;
		this.encoder = encoder;
	}
	   
	@Override
	public UserAccount createUserAccount(UserAccount userAccount) {
		userAccount.setPassword(encoder.encode(userAccount.getPassword()));
		UserRole userRole = userRoleRepository.findByName("ROLE_USER");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(userRole);
		userAccount.setUserRoles(userRoles);
		return userAccountRepository.save(userAccount);
	}

		@Override
		public UserAccount findByUsername(String username) {			
			return userAccountRepository.findByUsername(username);
		}

		@Override
		public List<UserAccount> getUserAccounts() {
			
			return userAccountRepository.findAll();
		}
}
