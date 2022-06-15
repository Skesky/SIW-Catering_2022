package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.service.BuffetService;

@Controller
public class PiattoController {
	
	@Autowired
	BuffetService buffetService;
	
	@GetMapping("/buffetDishes/{id}")
	public String dishesForBuffet(@PathVariable("id") Long id, Model model) {
		
			model.addAttribute("buffet", buffetService.findBuffetById(id));
			
			return "piattiPerBuffet";
	}

}
