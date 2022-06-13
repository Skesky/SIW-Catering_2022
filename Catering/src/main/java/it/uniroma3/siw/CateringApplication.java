package it.uniroma3.siw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class CateringApplication {
	//static DBInitalizer init = new DBInitalizer();
	public static void main(String[] args) {
		//init.inizializza();
		SpringApplication.run(CateringApplication.class, args);
	}

}
