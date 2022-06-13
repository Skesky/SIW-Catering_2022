package it.uniroma3.siw;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.CredentialsService;

public class DBInitalizer {

	
	CredentialsService credentialsService = new CredentialsService();
	
	public  void inizializza() {
		User u = new User();
		u.setNome("Kevin");
		u.setCognome("Santodonato");
		Credentials c1 = new Credentials(u);
		c1.setUsername("davide");
		c1.setPassword("davide");
		c1.setRole("ADMIN");
		credentialsService.saveCredentials(c1);
	}


}
