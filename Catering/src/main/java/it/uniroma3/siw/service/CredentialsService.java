package it.uniroma3.siw.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.repository.CredentialRepository;

@Service
public class CredentialsService {
	
	 	@Autowired
	   protected PasswordEncoder passwordEncoder;

		@Autowired
		protected CredentialRepository credentialsRepository;
		
		@Transactional
		public Credentials getCredentials(Long id) {
			Optional<Credentials> result = this.credentialsRepository.findById(id);
			return result.orElse(null);
		}

		@Transactional
		public Credentials getCredentials(String username) {
			Optional<Credentials> result = this.credentialsRepository.findByUsername(username);
			return result.orElse(null);
		}
			
	   @Transactional
	   public Credentials saveCredentials(Credentials credentials) {
	       credentials.setRole(Credentials.DEFAULT_ROLE);
		   //credentials.setRole(Credentials.ADMIN_ROLE);
	       credentials.setPassword(this.passwordEncoder.encode(credentials.getPassword()));
	       return this.credentialsRepository.save(credentials);
	    }

}
