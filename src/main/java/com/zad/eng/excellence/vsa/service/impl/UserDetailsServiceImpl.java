package com.zad.eng.excellence.vsa.service.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

import com.zad.eng.excellence.vsa.domain.UserAccount;
import com.zad.eng.excellence.vsa.service.UserAccountService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final UserAccountService userAccountService;
	
	 public UserDetailsServiceImpl(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		 UserAccount userAccount = userAccountService.findByUsername(username);
	        if(userAccount == null) {
	            throw new UsernameNotFoundException("User " + username + " not found");
	        }
	        if(userAccount.getUserRoles() == null || userAccount.getUserRoles().isEmpty()) {
	            throw new RuntimeException("User has no roles");
	        }
	        Collection<GrantedAuthority> authorities = userAccount.getUserRoles().stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(toList());
	        return new User(userAccount.getUsername(), userAccount.getPassword(), userAccount.isEnabled(),
	                !userAccount.isExpired(), !userAccount.isCredentialsexpired(), !userAccount.isLocked(), authorities);
	    }
		
}
