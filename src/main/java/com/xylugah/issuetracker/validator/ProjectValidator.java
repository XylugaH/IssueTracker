package com.xylugah.issuetracker.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xylugah.issuetracker.entity.Project;

@Component
public class ProjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Project.class.isAssignableFrom(arg0);
	}

	@Override
    public void validate(Object o, Errors errors) {
		Project project = (Project) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manager", "Required");
        
        
		if (project.getName().length() < 3 || project.getName().length() > 45) {
			errors.rejectValue("name", "Size.project.name");
		}
		
		if (project.getDescription().length() < 3 || project.getDescription().length() > 100) {
			errors.rejectValue("description", "Size.project.description");
		}
		
    }
}