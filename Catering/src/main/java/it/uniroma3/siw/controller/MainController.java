package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping({"/index"})
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping({"/explore"})
	public String explore(Model model) {
		return "explore";
	}
	
	@GetMapping({"/insertIngredient"})
	public String inserdtIgredient(Model model) {
		return "admin/insertIngredient";
	}
	
	@GetMapping({"/editBuffet"})
	public String editBuffet(Model model) {
		return "admin/editBuffet";
	}
	
	@GetMapping({"/adminWelcomePage"})
	public String adminWelcomePage(Model model) {
		return "admin/adminWelcomePage";
	}
	
	@GetMapping({"/welcomePage"})
	public String welcomePage(Model model) {
		return "welcomePage";
	}
}
