package com.zad.eng.excellence.vsa.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zad.eng.excellence.vsa.domain.UserAccount;
import com.zad.eng.excellence.vsa.domain.UserRole;
import com.zad.eng.excellence.vsa.dto.UserAccountRequest;
import com.zad.eng.excellence.vsa.dto.UserAccountResponse;
import com.zad.eng.excellence.vsa.dto.UserRoleRequest;
import com.zad.eng.excellence.vsa.dto.UserRoleResponse;
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
	public UserAccountResponse createUserAccount(UserAccountRequest userAccountRequest) {
		
		UserAccount userAccount = buildUserAccountEntity(userAccountRequest);
		userAccount.setPassword(encoder.encode(userAccount.getPassword()));
		userAccount = userAccountRepository.save(userAccount);
		return prepareUserAccountResponse(userAccount);
	}

	private UserAccount buildUserAccountEntity(UserAccountRequest userAccountRequest) {
		UserAccount userAccount = new UserAccount();
		userAccount.setUsername(userAccountRequest.getUsername());
		userAccount.setPassword(userAccountRequest.getPassword());
		userAccount.setEnabled(userAccountRequest.isEnabled());
		
		userAccount.setUserRoles(buildUserRoleEntity(userAccountRequest.getUserRoleRequest()));		
		return userAccount;
	}

	private Set<UserRole> buildUserRoleEntity(List<UserRoleRequest> userRoleRequest) {
		Set<UserRole> userRoles = new HashSet<UserRole>();
		for(UserRoleRequest request : userRoleRequest)
		{
			UserRole userRole = userRoleRepository.findByName(request.getName());	
			userRoles.add(userRole);
		}
		return userRoles;
	}

	@Override
	public List<UserAccountResponse> getUserAccounts() {

		List<UserAccountResponse> userAccountList = new ArrayList<UserAccountResponse>();
		List<UserAccount> userAccounts = userAccountRepository.findAll();
		userAccountList = userAccounts.stream().map(userAccount -> prepareUserAccountResponse(userAccount))
				.collect(Collectors.toList());
		return userAccountList;
	}

	private UserAccountResponse prepareUserAccountResponse(UserAccount userAccount) {
		UserAccountResponse response = new UserAccountResponse();
		response.setAccountId(userAccount.getId().intValue());
		response.setUsername(userAccount.getUsername());
		response.setEnabled(userAccount.isEnabled());

		List<UserRoleResponse> userRoleResponseList = userAccount.getUserRoles().stream()
				.map(role -> prepareUserRoleResponse(role)).collect(Collectors.toList());
		response.setUserRoles(userRoleResponseList);
		return response;
	}

	private UserRoleResponse prepareUserRoleResponse(UserRole userRole) {
		UserRoleResponse userRoleResponse = new UserRoleResponse();
		userRoleResponse.setCode(userRole.getCode());
		userRoleResponse.setName(userRole.getName());
		return userRoleResponse;
	}

	@Override
	public UserAccount findByUsername(String username) {
		return userAccountRepository.findByUsername(username);
	}
}
