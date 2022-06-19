package it.uniroma3.siw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Buffet;
import it.uniroma3.siw.model.Chef;
import it.uniroma3.siw.model.Piatto;
import it.uniroma3.siw.service.BuffetService;
import it.uniroma3.siw.service.ChefService;
import it.uniroma3.siw.service.PiattoService;
import it.uniroma3.siw.validator.BuffetValidator;

@Controller
public class BuffetController {
	
	@Autowired
	BuffetService buffetService;
	
	@Autowired
	ChefService chefService;
	
	@Autowired
	PiattoService piattoService;
	
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
		Chef chef = buffetService.findBuffetById(id).getChef();
		chef.getBuffets().remove(this.buffetService.findBuffetById(id));
		this.buffetService.deleteById(id);
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
		model.addAttribute("piatti", piattoService.findAllPiatti());
		return "admin/insertBuffet";
	}
	
	@PostMapping("/admin/insertBuffet")
	public String inserimentoBuffet(@ModelAttribute("buffet") Buffet buffet, @RequestParam(name = "dishList") List<Long> ids,
			BindingResult buffetBindingResults, Model model) {
		List<Piatto> list = new ArrayList<>();
		for(Long id : ids) {
			list.add(this.piattoService.findPiattoById(id));
		}
		this.buffetValidator.validate(buffet, buffetBindingResults);
		
		if(!buffetBindingResults.hasErrors()) {
			model.addAttribute("buffet", buffetService.save(buffet, list));
			
			return "admin/buffet";
		}
		
		model.addAttribute("chefs", chefService.getAllChefs());
		model.addAttribute("piatti", piattoService.findAllPiatti());
		
		return "admin/insertBuffet";
		
	}
	
	@GetMapping("/chefBuffets/{id}")
	public String buffetForChef(@PathVariable("id") Long id, Model model) {
		
			model.addAttribute("chef", chefService.findChefById(id));
			
			return "buffetsPerChef";
	}
	

}
