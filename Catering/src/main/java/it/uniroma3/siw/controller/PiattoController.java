package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.service.BuffetService;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.PiattoService;

@Controller
public class PiattoController {
	
	@Autowired
	BuffetService buffetService;
	
	@Autowired
	PiattoService piattoService;
	
	@Autowired
	CredentialsService credentialsService;
	
	@GetMapping("/buffetDishes/{id}")
	public String dishesForBuffet(@PathVariable("id") Long id, Model model) {
		
			model.addAttribute("buffet", buffetService.findBuffetById(id));
			
			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
	    	
	    	if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
	            return "admin/piatti";
	        }
			
			
			return "piattiPerBuffet";
	}
	
	@GetMapping("/admin/piatti")
	public String allDishes(Model model) {
		model.addAttribute("piatti", piattoService.findAllPiatti());
		
		return "admin/piatti";
	}

}
