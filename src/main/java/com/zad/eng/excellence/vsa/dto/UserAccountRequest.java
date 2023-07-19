package com.zad.eng.excellence.vsa.dto;

import java.io.Serializable;
import java.util.List;

public class UserAccountRequest implements Serializable {
	
	private static final long serialVersionUID = 5036203253995981031L;
	
	private String username;
	private String password;
	private boolean enabled;
	
	private List<UserRoleRequest> userRoleRequest;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<UserRoleRequest> getUserRoleRequest() {
		return userRoleRequest;
	}

	public void setUserRoleRequest(List<UserRoleRequest> userRoleRequest) {
		this.userRoleRequest = userRoleRequest;
	}
	
}
