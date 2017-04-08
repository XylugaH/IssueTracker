package com.xylugah.issuetracker.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xylugah.issuetracker.entity.Type;

public class TypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Type.class.isAssignableFrom(arg0);
	}

	@Override
    public void validate(Object o, Errors errors) {
        Type type = (Type) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        
		if (type.getName().length() < 3 || type.getName().length() > 45) {
			errors.rejectValue("name", "Size.type.name");
		}
    }
}
