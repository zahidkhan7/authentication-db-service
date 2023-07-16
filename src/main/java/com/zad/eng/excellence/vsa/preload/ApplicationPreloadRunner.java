package com.zad.eng.excellence.vsa.preload;

import static java.util.Arrays.asList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.zad.eng.excellence.vsa.domain.UserRole;
import com.zad.eng.excellence.vsa.repository.UserRoleRepository;


@Component
public class ApplicationPreloadRunner implements CommandLineRunner {
	
	private final UserRoleRepository userRoleRepository;

	public ApplicationPreloadRunner(UserRoleRepository userRoleRepository) {
		super();
		this.userRoleRepository = userRoleRepository;
	}


	@Override
	public void run(String... args) throws Exception
	{
		System.out.print("Below Line is Commented");
		/*
		 * UserRole roleUser = new UserRole(1L, "123", "ROLE_USER"); UserRole roleAdmin
		 * = new UserRole(2L, "456", "ROLE_ADMIN"); UserRole traineeAdmin = new
		 * UserRole(3L, "786", "TRAINEE_ADMIN");
		 * userRoleRepository.saveAll(asList(roleUser, roleAdmin,traineeAdmin));
		 */
	}

}
