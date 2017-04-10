package com.xylugah.issuetracker.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xylugah.issuetracker.entity.util.UserProfile;

@Component
public class UserProfileValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Override
	public boolean supports(Class<?> arg0) {
		return UserProfile.class.isAssignableFrom(arg0);
	}

	@Override
    public void validate(Object o, Errors errors) {
		UserProfile userProfile = (UserProfile) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
		
		if (userProfile.getFirstName().length() < 3 || userProfile.getFirstName().length() > 45) {
			errors.rejectValue("firstName", "Size.user.firstname");
		}

		if (userProfile.getLastName().length() < 3 || userProfile.getLastName().length() > 45) {
			errors.rejectValue("lastName", "Size.user.lastname");
		}

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(userProfile.getEmail());
		if (!matcher.matches()) {
			errors.rejectValue("email", "Incorrect.user.email");
		}
		
    }
}

