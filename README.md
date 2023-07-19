# authentication-db-service
Authentication Service API Using Database 
==========================================================================> 
1: The Application Manage User Roles and User Account for Authentication.

2: The Application using database for Spring Security Authentication.

3: SQL Script is added to populate USER_ROLE Data using Manual way.

4: API POST REQUEST: http://localhost:8090/api/accounts is build to Create new USER_ACCOUNT,
  This is without authentication at this stage. Need to modify.

5: API GET REQUEST: http://localhost:8090/api/accounts is build to display all USER_ACCOUNT
   with Roles. Need to Modify , should not show password.
   
6: Need to Add More change for Authentication regarding creating new USER_ACCOUNT and also 
   creating USER_ROLE as the same time.  
   
   
====================================== SAMPLE CODE ====================================> 
@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
		.antMatchers("/welcome/**")	
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
	
Note : As per above Code:
1: http://localhost:8090/welcome is free to access without authentication
2: http://localhost:8090/api/accounts GET REQUEST Requires Basic Authentication to be given: 
   Means username & password.
   
3: http://localhost:8090/api/accounts POST Request, Requires Basic Authentication to be given:
  Means username & password. 
  With Sample JSON :
  
  {
    "username" :"khan",
    "password":"khan123",
    "enabled":true,
    "userRoleRequest" : [
        {
        "name":"ROLE_ADMIN"
        }
    ]   
}


@Configuration
public class SecurityPasswordConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

With Above Code password is encrypted with BCryptPasswordEncoder.

Note : Application has been tested, If any issue may be later, need issue resolution.
============================ Closed Project 20 JULY 2023 ============================> 	
