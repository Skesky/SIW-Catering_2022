package it.uniroma3.siw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Chef;
import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.service.ChefService;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.UserService;
import it.uniroma3.siw.validator.ChefValidator;

@Controller
public class ChefController {
	
	@Autowired
	ChefService  chefService;
	
	@Autowired
	UserService  userService;
	
	@Autowired
	ChefValidator chefValidator;
	
	@Autowired
	CredentialsService credentialsService;
	
	@GetMapping("/chefs")
	public String showChefs(Model model) {
		List<Chef> allChefs = chefService.getAllChefs();
		model.addAttribute("chefs",allChefs);
	
		return "chefs";
	}
	
	@GetMapping("/admin/chefs")
	public String showChefsAdmin(Model model) {
		List<Chef> allChefs = chefService.getAllChefs();
		model.addAttribute("chefs",allChefs);
	
		return "admin/chefs";
	}
	
	@GetMapping("/admin/insertChef")
	public String insertChef(Model model) {
		model.addAttribute("chef", new Chef());
		return "admin/insertChef";
	}
	
	@PostMapping("/admin/insertChef")
	public String registerChef(@ModelAttribute("chef") Chef chef,
					BindingResult chefBindingResults, Model model) {
		this.chefValidator.validate(chef, chefBindingResults);
		if(!chefBindingResults.hasErrors()) {
			model.addAttribute("chef", chef);
			chefService.save(chef);
			return "admin/chef";
		}
		
		return "admin/insertChef";
	}
	
	@GetMapping("/admin/removeChef/{id}")
	public String removeChef(@PathVariable("id") Long id, Model model) {
		chefService.deleteByid(id);
		model.addAttribute("chefs", chefService.getAllChefs());
		
		return "admin/chefs";
		
	}
	
	/*@PostMapping("/admin/confirmInsertChef")
	public String confirmInsertChef(@ModelAttribute("chef") Chef chef, Model model) {
		//Chef chef = (Chef) model.getAttribute("chef");//il problema si trova qui
		chefService.save(chef);
		//model.addAttribute("chefs", chefService.getAllChefs());
		model.addAttribute("users",userService.getAllUsers());
		
		return "chefs";
	}*/

}
