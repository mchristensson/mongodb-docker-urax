package org.mac.urax;

import org.mac.urax.service.PersonService;
import org.mac.urax.service.PersonServiceProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UraxApplication {

	public static void main(String[] args) {
		SpringApplication.run(UraxApplication.class, args);
	}

}
