package com.xylugah.issuetracker.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xylugah.issuetracker.entity.Status;
import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.exception.StatusNotFoundException;
import com.xylugah.issuetracker.service.StatusService;
import com.xylugah.issuetracker.service.UserService;
import com.xylugah.issuetracker.validator.StatusValidator;

@Controller
@SessionAttributes("currentUser")
public class StatusController {

	private static final Logger logger = LoggerFactory.getLogger(StatusController.class);
	
	@Autowired
	private StatusValidator statusValidator;

	@Resource(name = "StatusService")
	private StatusService statusService;
	
	@Resource(name = "UserService")
	private UserService userService;

	@RequestMapping(value = "/liststatus", method = RequestMethod.GET)
	public String listStatus(ModelMap model) {
		List<Status> statuses = statusService.getAll();
		model.addAttribute("listStatus", statuses);
		return "listStatus";
	}

	@RequestMapping(value = "/editstatus", method = RequestMethod.GET)
	public String editStatus(@RequestParam int id, ModelMap model) {
		Status status = statusService.getById(id);

		if (status == null) {
			throw new StatusNotFoundException(id);
		}
		
		model.addAttribute("status", status);
		return "editstatus";
	}

	@RequestMapping(value = { "/updatestatus" }, method = RequestMethod.POST)
	public String saveStatus(@ModelAttribute("status") Status status, BindingResult result, ModelMap model) {

		if (statusService.getById(status.getId()) == null) {
			throw new StatusNotFoundException(status.getId());
		}
		
		statusValidator.validate(status, result);
	
		if (statusService.getByPartName(status.getName()) != null) {
			result.rejectValue("name", "Duplicate.status");
		}
				
		if (result.hasErrors()) {
			return "editstatus";
		}
				
		statusService.edit(status);

		if (logger.isInfoEnabled()) {
			logger.info(getAuthenticationUser() + " update " + status);
		}
		
		return "redirect:/liststatus";
	}

	private User getAuthenticationUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}
	
}
