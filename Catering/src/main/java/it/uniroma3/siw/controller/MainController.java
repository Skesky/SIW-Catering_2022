package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.CredentialsService;

@Controller
public class MainController {
	
	@Autowired
	private CredentialsService credentialsService;
	
	@GetMapping({"/index"})
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping({"/explore"})
	public String explore(Model model) {
		return "explore";
	}
	
	@GetMapping({"/admin/explore"})
	public String exploreAdmin(Model model) {
		//UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	//Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	//User user = credentials.getUser();
    	//model.addAttribute("user", user);
		return "admin/explore";
	}
	
	@GetMapping({"/insertIngredient"})
	public String inserdtIgredient(Model model) {
		return "admin/insertIngredient";
	}
	
	@GetMapping({"/editBuffet"})
	public String editBuffet(Model model) {
		return "admin/editBuffet";
	}
	
	@GetMapping({"/admin/adminWelcomePage"})
	public String adminWelcomePage(Model model) {
		return "admin/adminWelcomePage";
	}
	
	@GetMapping({"/welcomePage"})
	public String welcomePage(Model model) {
		return "welcomePage";
	}
}
