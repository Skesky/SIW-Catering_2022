package it.uniroma3.siw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class CateringApplication {
	
	public static void main(String[] args) {
	
		SpringApplication.run(CateringApplication.class, args);
	}

}
