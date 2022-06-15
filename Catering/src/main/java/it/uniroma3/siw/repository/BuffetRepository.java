package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Buffet;

public interface BuffetRepository extends CrudRepository<Buffet, Long>{
	
	boolean existsByNome(String nome);
	
	
}
