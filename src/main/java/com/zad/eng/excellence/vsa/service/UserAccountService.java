package com.zad.eng.excellence.vsa.service;

import java.util.List;

import com.zad.eng.excellence.vsa.domain.UserAccount;

public interface UserAccountService {

	UserAccount createUserAccount(UserAccount userAccount);

	UserAccount findByUsername(String username);

	List<UserAccount> getUserAccounts();

}
