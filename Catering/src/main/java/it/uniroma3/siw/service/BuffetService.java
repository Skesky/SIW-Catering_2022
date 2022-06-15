package it.uniroma3.siw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Buffet;
import it.uniroma3.siw.model.Chef;
import it.uniroma3.siw.repository.BuffetRepository;

@Service
public class BuffetService {
	
	@Autowired
	private BuffetRepository buffetRepo;
	
	@Autowired
	private ChefService chefService;
	
	@Transactional
	public Buffet save(Buffet buffet) {
		Chef chef = chefService.findChefById(buffet.getChef().getId());
		chef.getBuffets().add(buffet);
		return buffetRepo.save(buffet);
	}
	
	@Transactional
	public List<Buffet> findAllBuffet() {
		return (List<Buffet>) buffetRepo.findAll();
	}
	
	@Transactional
	public Buffet findBuffetById(Long id) {
		return  buffetRepo.findById(id).get();
	}

	
	@Transactional
	public void deleteById(Long id) {
		buffetRepo.deleteById(id);
	}
	
	@Transactional
	public void deleteBuffet(Buffet buffet) {
		buffetRepo.delete(buffet);
	}
	
	@Transactional
	public boolean duplicati(String nome) {
		return buffetRepo.existsByNome(nome);
	}
	
}


