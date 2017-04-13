package com.xylugah.issuetracker.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xylugah.issuetracker.entity.Issue;

@Component
public class IssueValidatorEditForm implements Validator {

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

		if (issue.getSummary().length() < 3 || issue.getSummary().length() > 45) {
			errors.rejectValue("summary", "Size.issue.summary");
		}

		if (issue.getDescription().length() < 3 || issue.getDescription().length() > 100) {
			errors.rejectValue("description", "Size.issue.description");
		}

		if (issue.getStatus() != null) {
			
			if (issue.getStatus().getName().equals("New") && issue.getAssignee() != null) {
				errors.rejectValue("status", "Invalid.issue.status.assignee");
			}

			if (!issue.getStatus().getName().equals("New") && issue.getAssignee() == null) {
				errors.rejectValue("status", "Invalid.issue.status.new");
			}
			
			if (issue.getTempStatus().getName().equals("New")){
				if (!issue.getStatus().getName().equals("New") && !issue.getStatus().getName().equals("Assigned")){
					errors.rejectValue("status", "Invalid.issue.status.unknown");
				}
			}
			
			if (issue.getTempStatus().getName().equals("Assigned")){
				if (!issue.getStatus().getName().equals("Assigned") && !issue.getStatus().getName().equals("In Progress")){
					errors.rejectValue("status", "Invalid.issue.status.unknown");
				}
			}
			
			if (issue.getTempStatus().getName().equals("In Progress")){
				if (!issue.getStatus().getName().equals("In Progress") && !issue.getStatus().getName().equals("Resolved") && !issue.getStatus().getName().equals("Closed")){
					errors.rejectValue("status", "Invalid.issue.status.unknown");
				}
			}
			
			if (issue.getTempStatus().getName().equals("Resolved")){
				if (!issue.getStatus().getName().equals("Resolved") && !issue.getStatus().getName().equals("Closed")){
					errors.rejectValue("status", "Invalid.issue.status.unknown");
				}
			}
			
			if (issue.getTempStatus().getName().equals("Closed")){
				if (!issue.getStatus().getName().equals("Closed") && !issue.getStatus().getName().equals("Reopened")){
					errors.rejectValue("status", "Invalid.issue.status.unknown");
				}
			}
			
			if (issue.getTempStatus().getName().equals("Reopened")){
				if (!issue.getStatus().getName().equals("Reopened") && !issue.getStatus().getName().equals("Assigned") && !issue.getStatus().getName().equals("In Progress")){
					errors.rejectValue("status", "Invalid.issue.status.unknown");
				}
			}
			
			if (issue.getStatus().getName().equals("Resolved") || issue.getStatus().getName().equals("Closed")){
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resolution", "Required");
			}	
		}
		
		if (issue.getResolution()!=null){
			if (!issue.getStatus().getName().equals("Resolved") && !issue.getStatus().getName().equals("Closed")) {
				errors.rejectValue("resolution", "Invalid.issue.resolution");
			}	
		}
	}
}