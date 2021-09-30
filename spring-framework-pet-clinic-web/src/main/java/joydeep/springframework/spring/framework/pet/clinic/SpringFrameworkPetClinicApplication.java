package joydeep.springframework.spring.framework.pet.clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringFrameworkPetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFrameworkPetClinicApplication.class, args);
	}

}
