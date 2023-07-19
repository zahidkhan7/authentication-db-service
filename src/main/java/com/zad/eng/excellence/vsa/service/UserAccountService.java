package com.zad.eng.excellence.vsa.service;

import java.util.List;

import com.zad.eng.excellence.vsa.domain.UserAccount;
import com.zad.eng.excellence.vsa.dto.UserAccountRequest;
import com.zad.eng.excellence.vsa.dto.UserAccountResponse;

public interface UserAccountService {

	UserAccountResponse createUserAccount(UserAccountRequest userAccountRequest);
	
	UserAccount findByUsername(String username);

	List<UserAccountResponse> getUserAccounts();

}
