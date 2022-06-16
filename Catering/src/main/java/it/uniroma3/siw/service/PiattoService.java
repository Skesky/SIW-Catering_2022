package it.uniroma3.siw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Piatto;
import it.uniroma3.siw.repository.PiattoRepository;

@Service
public class PiattoService {
	
	@Autowired
	private PiattoRepository piattoRepo;
	
	@Transactional
	public Piatto aggiungiPiatto(Piatto piatto) {
		return piattoRepo.save(piatto);
		
	}
	
	@Transactional
	public Piatto findPiattoById(Long id) {
		
		return this.piattoRepo.findById(id).get();
	}
	
	@Transactional
	public List<Piatto> findAllPiatti() {
		
		return (List<Piatto>)this.piattoRepo.findAll();
	}
	
	
}
