package it.uniroma3.siw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.model.Buffet;
import it.uniroma3.siw.repository.BuffetRepository;

@Service
public class BuffetService {
	
	@Autowired
	private BuffetRepository buffetRepo;
	
	@Transactional
	public Buffet save(Buffet buffet) {
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
	public List<Buffet> buffetPerCategoria(String Categoria){
		return buffetRepo.findByCategoria(Categoria);
	}
	
	@Transactional
	public List<Buffet> buffetPerChef(String nomeChef, String cognomeChef){
		return buffetRepo.buffetPerChef(nomeChef, cognomeChef);
	}
	
	@Transactional
	public void deleteById(Long id) {
		buffetRepo.deleteById(id);
	}
}


