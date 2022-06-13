package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Buffet;
import it.uniroma3.siw.model.Chef;

public interface ChefRepository extends CrudRepository<Chef, Long> {
	
	//@Query("SELECT c.buffet FROM Chef c WHERE c.nome = ?")
	//public List<Buffet >getAllChefBuffet(Chef c);
	
	@Query("SELECT buffets FROM Chef c WHERE c =: chef")
	public List<Buffet>getAllChefBuffet(@Param("chef")Chef chef);
	
	public void deleteById(Long id);
		
	

}
