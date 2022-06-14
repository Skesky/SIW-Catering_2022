package it.uniroma3.siw.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Buffet;
import it.uniroma3.siw.model.Chef;

@Component
public class BuffetValidator implements Validator {

	@Override
    public void validate(Object o, Errors errors) {
        Buffet buffet = (Buffet) o;
        String nome = buffet.getNome().trim();
        String categoria = buffet.getCategoria().trim();
        String descrizione = buffet.getDescrizione().trim();
        Chef chef = buffet.getChef();

        if (nome.isEmpty())
            errors.rejectValue("nome", "required");

        if (categoria.isEmpty())
            errors.rejectValue("categoria", "required");
        
        if (descrizione.isEmpty())
        	errors.rejectValue("descrizione", "required");
        
        if (chef == null)
        	errors.rejectValue("chef", "required");
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Buffet.class.equals(clazz);
    }

}
