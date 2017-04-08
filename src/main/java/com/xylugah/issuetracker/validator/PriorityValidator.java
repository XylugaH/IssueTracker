package com.xylugah.issuetracker.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xylugah.issuetracker.entity.Priority;

@Component
public class PriorityValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Priority.class.isAssignableFrom(arg0);
	}

	@Override
    public void validate(Object o, Errors errors) {
		Priority priority = (Priority) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        
		if (priority.getName().length() < 3 || priority.getName().length() > 45) {
			errors.rejectValue("name", "Size.priority.name");
		}
    }
}
