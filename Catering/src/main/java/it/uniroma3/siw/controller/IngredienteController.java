package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.IngredienteService;
import it.uniroma3.siw.service.PiattoService;

@Controller
public class IngredienteController {
	
	@Autowired
	CredentialsService credentialsService;
	
	@Autowired
	IngredienteService ingredientiService;
	
	@Autowired
	PiattoService piattoService;
	
	@GetMapping("/ingredienti/{id}")
	public String ingredientiPerPiatto(@PathVariable("id") Long id, Model model) {
    	
    	model.addAttribute("piatto", this.piattoService.findPiattoById(id));
    	
    	return "ingredienti";
	}
	
	@GetMapping("/admin/ingredienti")
	public String ingredienti( Model model) {
    	
    	model.addAttribute("ingredienti", this.ingredientiService.findAllIngredients());
    	
        return "admin/ingredienti";
	}

}
