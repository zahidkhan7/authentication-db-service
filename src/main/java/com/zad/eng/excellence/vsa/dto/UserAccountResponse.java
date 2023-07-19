package com.zad.eng.excellence.vsa.dto;

import java.util.List;

public class UserAccountResponse {

	private Integer accountId;
	private String username;
	private boolean enabled;
	
	private List<UserRoleResponse> userRoles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public List<UserRoleResponse> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoleResponse> userRoles) {
		this.userRoles = userRoles;
	}

}
