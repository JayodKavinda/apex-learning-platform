package com.learning.apex.apexelearning;

import com.learning.apex.apexelearning.entity.Role;
import com.learning.apex.apexelearning.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ApexELearningApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApexELearningApplication.class, args);
	}

	@Autowired
	private RoleRepository roleRepository;
	@Override
	public void run(String... args) throws Exception {
		Role adminRole = new Role();
		adminRole.setRoleName("ROLE_INSTRUCTOR");
		roleRepository.save(adminRole);

		Role userRole = new Role();
		userRole.setRoleName("ROLE_STUDENT");
		roleRepository.save(userRole);

		Role guestUserRole = new Role();
		guestUserRole.setRoleName("ROLE_GUEST");
		roleRepository.save(guestUserRole);
	}
}
