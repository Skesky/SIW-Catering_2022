package it.uniroma3.siw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
