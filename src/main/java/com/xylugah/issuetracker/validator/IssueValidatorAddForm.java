package com.xylugah.issuetracker.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xylugah.issuetracker.entity.Issue;

@Component
public class IssueValidatorAddForm implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Issue.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Issue issue = (Issue) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "summary", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "priority", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "project", "Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "build", "Required");

		if (issue.getId() != 0) {
			errors.rejectValue("summary", "Invalid.issue.id");
		}

		if (issue.getSummary().length() < 3 || issue.getSummary().length() > 45) {
			errors.rejectValue("summary", "Size.issue.summary");
		}

		if (issue.getDescription().length() < 3 || issue.getDescription().length() > 100) {
			errors.rejectValue("description", "Size.issue.description");
		}

		if (issue.getStatus() != null) {
			if (!issue.getStatus().getName().equals("New") && !issue.getStatus().getName().equals("Assigned")) {
				errors.rejectValue("status", "Invalid.issue.status");
			}

			if (issue.getStatus().getName().equals("New") && issue.getAssignee() != null) {
				errors.rejectValue("status", "Invalid.issue.status.assignee");
			}

			if (issue.getStatus().getName().equals("Assigned") && issue.getAssignee() == null) {
				errors.rejectValue("status", "Invalid.issue.status.new");
			}
		}
	}
}
