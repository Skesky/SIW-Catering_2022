package it.uniroma3.siw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Buffet;
import it.uniroma3.siw.model.Chef;
import it.uniroma3.siw.repository.ChefRepository;

@Service
public class ChefService {

	@Autowired
	private ChefRepository chefRepo;
	
	@Transactional
	public Chef save(Chef chef) {
		return chefRepo.save(chef);
	}
	
	/*
	 * How to find all chef's buffet???
	 */
	
	//@Transactional
	//public List<Buffet> getChetBuffet(Chef c){
	//	return chefRepo.getAllChefBuffet(c);
	//}
		
	
	@Transactional
	public List<Buffet> getChefBuffets(Chef chef){
		return chefRepo.getAllChefBuffet(chef);
	}
	
	@Transactional
	public List<Chef> getAllChefs(){
		return (List<Chef>)chefRepo.findAll();
	}
	
	@Transactional
	public void deleteByid(Long id) {
		chefRepo.deleteById(id);
	}
	
	@Transactional
	public Chef findChefById(Long id) {
		return chefRepo.findById(id).get();
	}

}
