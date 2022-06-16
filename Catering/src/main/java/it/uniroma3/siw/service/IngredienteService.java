package it.uniroma3.siw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.repository.IngredienteRepository;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteRepository ingredienteRepo;
	
	@Transactional
	public Ingrediente save(Ingrediente ingrediente) {
		return ingredienteRepo.save(ingrediente);
	}
	
	@Transactional
	public List<Ingrediente> findAllIngredients(){
		return (List<Ingrediente>)this.ingredienteRepo.findAll();
	}
	
}
