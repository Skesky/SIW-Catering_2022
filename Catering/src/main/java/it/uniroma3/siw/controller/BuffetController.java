package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Buffet;
import it.uniroma3.siw.model.Chef;
import it.uniroma3.siw.service.BuffetService;
import it.uniroma3.siw.service.ChefService;
import it.uniroma3.siw.validator.BuffetValidator;

@Controller
public class BuffetController {
	
	@Autowired
	BuffetService buffetService;
	
	@Autowired
	ChefService chefService;
	
	@Autowired
	BuffetValidator buffetValidator;
	
	@GetMapping("/admin/buffets")
	public String showAllBuffets(Model model) {
		model.addAttribute("buffets",buffetService.findAllBuffet());
		
		return "admin/buffets";
	}
	
	@GetMapping("/buffets")
	public String showAllBuffetsUsers(Model model) {
		model.addAttribute("buffets",buffetService.findAllBuffet());
		
		return "buffets";
	}
	
	@GetMapping("/admin/removeBuffet/{id}")
	public String removeBuffet(@PathVariable("id") Long id, Model model) {
		buffetService.deleteById(id);
		model.addAttribute("buffets", buffetService.findAllBuffet());
		
		return "admin/buffets";
	}
	
	@GetMapping("/admin/editBuffet/{id}")
	public String editBuffet(@PathVariable("id") Long id, Model model) {
		model.addAttribute("buffet", buffetService.findBuffetById(id));
		model.addAttribute("chefs", chefService.getAllChefs());
		
		return "admin/editBuffet";
	}
	
	@PostMapping("/admin/editBuffet/{id}")
	public String saveEditedBuffet(@PathVariable("id") Long id, @ModelAttribute("buffet") Buffet buffet , Model model) {
		Buffet originalBuffet = buffetService.findBuffetById(id);
		
		originalBuffet.setId(buffet.getId());
		originalBuffet.setNome(buffet.getNome());
		originalBuffet.setCategoria(buffet.getCategoria());
		originalBuffet.setDescrizione(buffet.getDescrizione());
		originalBuffet.setChef(buffet.getChef());
		//chef.getBuffets().add(buffet);
		buffetService.save(originalBuffet);
		
		model.addAttribute("buffets", buffetService.findAllBuffet());
		
		return "admin/buffets";
	}
	
	@GetMapping("/admin/insertBuffet")
	public String insertBuffet(Model model) {
		model.addAttribute("buffet", new Buffet());
		model.addAttribute("chefs", chefService.getAllChefs());
		return "admin/insertBuffet";
	}
	
	@PostMapping("/admin/insertBuffet")
	public String inserimentoBuffet(@ModelAttribute("buffet") Buffet buffet, 
			BindingResult buffetBindingResults, Model model) {
		this.buffetValidator.validate(buffet, buffetBindingResults);
		
		if(!buffetBindingResults.hasErrors()) {
			model.addAttribute("buffet", buffet);
			buffetService.save(buffet);
			
			return "admin/buffet";
		}
		
		return "admin/insertBuffet";
		
	}
	
	@GetMapping("/chefBuffets/{id}")
	public String buffetForChef(@PathVariable("id") Long id, Model model) {
		
			model.addAttribute("chef", chefService.findChefById(id));
			
			return "buffetsPerChef";
	}
	

}
