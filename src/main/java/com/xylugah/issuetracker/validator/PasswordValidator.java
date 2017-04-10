package com.xylugah.issuetracker.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xylugah.issuetracker.entity.util.Password;

@Component
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Password.class.isAssignableFrom(arg0);
	}

	@Override
    public void validate(Object o, Errors errors) {
		Password password = (Password) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "Required");
		
		if (password.getPassword().length() < 5 || password.getPassword().length() > 45) {
			errors.rejectValue("password", "Size.user.password");
		}

		if (!password.getPasswordConfirm().equals(password.getPassword())) {
			errors.rejectValue("passwordConfirm", "Different.user.password");
		}
    }
}
