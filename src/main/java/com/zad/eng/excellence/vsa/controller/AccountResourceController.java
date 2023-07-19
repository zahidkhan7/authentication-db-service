package com.zad.eng.excellence.vsa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zad.eng.excellence.vsa.dto.UserAccountRequest;
import com.zad.eng.excellence.vsa.dto.UserAccountResponse;
import com.zad.eng.excellence.vsa.service.UserAccountService;
import com.zad.eng.excellence.vsa.util.ApplicationUtil;

@RestController
@RequestMapping(path = "/api/accounts")
public class AccountResourceController {

	private final UserAccountService userAccountService;

	public AccountResourceController(UserAccountService userAccountService) {
		super();
		this.userAccountService = userAccountService;
	}

	@PostMapping
	public ResponseEntity<UserAccountResponse> createAccount(@RequestBody UserAccountRequest userAccountRequest) {
		UserAccountResponse newAccount = userAccountService.createUserAccount(userAccountRequest);
		return ResponseEntity.created(ApplicationUtil.getLocation(newAccount.getAccountId().intValue())).body(newAccount);
	}

	@GetMapping
	public ResponseEntity<List<UserAccountResponse>> getAccount() {
		return ResponseEntity.ok(userAccountService.getUserAccounts());
	}

}
