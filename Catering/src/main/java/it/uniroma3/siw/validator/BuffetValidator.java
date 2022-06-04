package it.uniroma3.siw.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BuffetValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

	}

}
