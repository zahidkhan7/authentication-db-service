package com.zad.eng.excellence.vsa.security;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration  {	
	
	private final AccountAuthenticationProvider authenticationProvider;		
	
	public WebSecurityConfiguration(AccountAuthenticationProvider authenticationProvider) {
		super();
		this.authenticationProvider = authenticationProvider;
	}

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
		.antMatchers(POST,"/api/accounts/**")		
		.permitAll()
		.antMatchers("/api/**")
		.authenticated()
        .anyRequest()
        .hasAnyRole("USER", "ADMIN")
        .and()       
        .authenticationProvider(authenticationProvider)
        .httpBasic(withDefaults())
        .sessionManagement()
        .sessionCreationPolicy(STATELESS);		
		 return http.build();
		
	}

}
