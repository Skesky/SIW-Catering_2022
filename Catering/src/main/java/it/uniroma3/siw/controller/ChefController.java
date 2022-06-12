package it.uniroma3.siw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Chef;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.ChefService;
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
	
	@GetMapping("/chefs")
	public String showChefs(Model model) {
		//List<Chef> allChefs = chefService.getAllChefs();
		//model.addAttribute("chefs",allChefs);
		
		List<User> allUsers = userService.getAllUsers();
		model.addAttribute("users",allUsers);

		return "chefs";
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
			model.addAttribute(chef);
			return "admin/confirmInsertChef";
		}
		
		return "admin/insertChef";
	}
	
	@PostMapping("admin/confirmInsertChef")
	public String confirmInsertChef(Model model) {
		Chef chef = (Chef)model.getAttribute("chef");
		chefService.save(chef);
		//model.addAttribute("chefs", chefService.getAllChefs());
		model.addAttribute("users",userService.getAllUsers());
		
		return "admin/chefs";
	}

}
