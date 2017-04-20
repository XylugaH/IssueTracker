package com.xylugah.issuetracker.exception.handler;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.xylugah.issuetracker.exception.IssueNotFoundException;
import com.xylugah.issuetracker.exception.PriorityNotFoundException;
import com.xylugah.issuetracker.exception.ProjectNotFoundException;
import com.xylugah.issuetracker.exception.ResolutionNotFoundException;
import com.xylugah.issuetracker.exception.StatusNotFoundException;
import com.xylugah.issuetracker.exception.TypeNotFoundException;
import com.xylugah.issuetracker.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@Autowired
	ReloadableResourceBundleMessageSource messageSource;
	
	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView userNotFoundExceptionHandler(UserNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", messageSource.getMessage("User.not.found", null, Locale.getDefault()));
		return model;
	}

	@ExceptionHandler(TypeNotFoundException.class)
	public ModelAndView typeNotFoundExceptionHandler(TypeNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", messageSource.getMessage("Type.not.found", null, Locale.getDefault()));
		return model;
	}
	
	@ExceptionHandler(StatusNotFoundException.class)
	public ModelAndView statusNotFoundExceptionHandler(StatusNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", messageSource.getMessage("Status.not.found", null, Locale.getDefault()));
		return model;
	}

	@ExceptionHandler(ResolutionNotFoundException.class)
	public ModelAndView resolutionNotFoundExceptionHandler(ResolutionNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", messageSource.getMessage("Resolution.not.found", null, Locale.getDefault()));
		return model;
	}
	
	@ExceptionHandler(ProjectNotFoundException.class)
	public ModelAndView projectNotFoundExceptionHandler(ProjectNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", messageSource.getMessage("Project.not.found", null, Locale.getDefault()));
		return model;
	}
	
	
	@ExceptionHandler(PriorityNotFoundException.class)
	public ModelAndView priorityNotFoundExceptionHandler(PriorityNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", messageSource.getMessage("Priority.not.found", null, Locale.getDefault()));
		return model;
	}
	
	@ExceptionHandler(IssueNotFoundException.class)
	public ModelAndView issueNotFoundExceptionHandler(IssueNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", messageSource.getMessage("Issue.not.found", null, Locale.getDefault()));
		return model;
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ModelAndView handleException(Exception e) {
		logger.error("Error: ");
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", messageSource.getMessage("Invalid.request.status", null, Locale.getDefault()));
		return model;
	}
}
