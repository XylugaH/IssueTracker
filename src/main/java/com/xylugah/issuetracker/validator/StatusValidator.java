package com.xylugah.issuetracker.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xylugah.issuetracker.entity.Status;

@Component
public class StatusValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Status.class.isAssignableFrom(arg0);
	}

	@Override
    public void validate(Object o, Errors errors) {
		Status status = (Status) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        
		if (status.getName().length() < 3 || status.getName().length() > 45) {
			errors.rejectValue("name", "Size.status.name");
		}
    }
}