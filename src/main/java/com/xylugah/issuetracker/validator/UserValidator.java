package com.xylugah.issuetracker.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.service.UserService;

@Component
public class UserValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Resource(name = "UserService")
	private UserService userService;

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "Required");

		if (user.getFirstName().length() < 3 || user.getFirstName().length() > 45) {
			errors.rejectValue("firstName", "Size.user.firstname");
		}

		if (user.getLastName().length() < 3 || user.getLastName().length() > 45) {
			errors.rejectValue("lastName", "Size.user.lastname");
		}

		if (user.getPassword().length() < 5 || user.getPassword().length() > 45) {
			errors.rejectValue("password", "Size.user.password");
		}

		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Different.user.password");
		}

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(user.getEmail());
		if (!matcher.matches()) {
			errors.rejectValue("email", "Incorrect.user.email");
		}
	}
}
