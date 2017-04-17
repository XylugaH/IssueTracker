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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xylugah.issuetracker.entity.Priority;
import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.service.PriorityService;
import com.xylugah.issuetracker.service.UserService;
import com.xylugah.issuetracker.validator.PriorityValidator;

@Controller
@SessionAttributes("currentUser")
public class PriorityController {

	private static final Logger logger = LoggerFactory.getLogger(PriorityController.class);
	
	@Autowired
	private PriorityValidator priorityValidator;

	@Resource(name = "PriorityService")
	private PriorityService priorityService;

	@Resource(name = "UserService")
	private UserService userService;
	
	@RequestMapping(value = "/listpriorities", method = RequestMethod.GET)
	public String listPriorityes(ModelMap model) {
		List<Priority> listPriorities = priorityService.getAll();
		model.addAttribute("listpriorities", listPriorities);
		return "listpriorities";
	}

	@RequestMapping(value = "/addpriority", method = RequestMethod.GET)
	public String addPriority(ModelMap model) {
		Priority priority = new Priority();
		model.addAttribute("priority", priority);
		return "addpriority";
	}

	@RequestMapping(value = { "/savepriority" }, method = RequestMethod.POST)
	public String savePriority(@ModelAttribute("priority") Priority priority, BindingResult result, ModelMap model) {

		priorityValidator.validate(priority, result);

		if (priorityService.getByName(priority.getName()) != null
				|| priorityService.getById(priority.getId()) != null) {
			result.rejectValue("name", "Duplicate.priority");
		}
		if (result.hasErrors()) {
			return "addpriority";
		}
		
		priorityService.add(priority);

		if (logger.isInfoEnabled()) {
			logger.info(getAuthenticationUser() + " add " + priority);
		}
		
		return "redirect:/listpriorities";
	}

	@RequestMapping(value = "/editpriority/{id}", method = RequestMethod.GET)
	public String editPriority(@PathVariable int id, ModelMap model) {
		Priority priority = priorityService.getById(id);
		if (priority == null) {
			return "redirect:/listpriorities";
		}
		model.addAttribute("priority", priority);
		return "editpriority";
	}

	@RequestMapping(value = { "/updatepriority" }, method = RequestMethod.POST)
	public String updatePriority(@ModelAttribute("priority") Priority priority, BindingResult result, ModelMap model) {

		priorityValidator.validate(priority, result);

		if (priorityService.getByName(priority.getName()) != null) {
			result.rejectValue("name", "Duplicate.priority");
		}

		if (priorityService.getById(priority.getId()) == null) {
			result.rejectValue("name", "NotFound.priority");
		}

		if (result.hasErrors()) {
			return "editpriority";
		}

		priorityService.edit(priority);

		if (logger.isInfoEnabled()) {
			logger.info(getAuthenticationUser() + " update " + priority);
		}
		
		return "redirect:/listpriorities";
	}
	
	private User getAuthenticationUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}
}
