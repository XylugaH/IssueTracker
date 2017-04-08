package com.xylugah.issuetracker.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xylugah.issuetracker.entity.Resolution;

@Component
public class ResolutionValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Resolution.class.isAssignableFrom(arg0);
	}

	@Override
    public void validate(Object o, Errors errors) {
		Resolution resolution = (Resolution) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        
		if (resolution.getName().length() < 3 || resolution.getName().length() > 45) {
			errors.rejectValue("name", "Size.resolution.name");
		}
    }
}
