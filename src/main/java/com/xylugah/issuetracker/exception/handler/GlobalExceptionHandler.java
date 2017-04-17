package com.xylugah.issuetracker.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView userNotFoundExceptionHandler(UserNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", "User Not Found!!");
		return model;
	}

	@ExceptionHandler(TypeNotFoundException.class)
	public ModelAndView typeNotFoundExceptionHandler(TypeNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", "Type Not Found!!");
		return model;
	}
	
	@ExceptionHandler(StatusNotFoundException.class)
	public ModelAndView statusNotFoundExceptionHandler(StatusNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", "Status Not Found!!");
		return model;
	}

	@ExceptionHandler(ResolutionNotFoundException.class)
	public ModelAndView resolutionNotFoundExceptionHandler(ResolutionNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", "Resolution Not Found!!");
		return model;
	}
	
	@ExceptionHandler(ProjectNotFoundException.class)
	public ModelAndView projectNotFoundExceptionHandler(ProjectNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", "Project Not Found!!");
		return model;
	}
	
	
	@ExceptionHandler(PriorityNotFoundException.class)
	public ModelAndView priorityNotFoundExceptionHandler(PriorityNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", "Priority Not Found!!");
		return model;
	}
	
	@ExceptionHandler(IssueNotFoundException.class)
	public ModelAndView issueNotFoundExceptionHandler(IssueNotFoundException e) {
		logger.error("Error: ", e);
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", "Issue Not Found!!");
		return model;
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ModelAndView handleOException() {
		logger.error("Error: ");
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", "Page Not Found!!");
		return model;
	}
}
