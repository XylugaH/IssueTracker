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

import com.xylugah.issuetracker.entity.Resolution;
import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.service.ResolutionService;
import com.xylugah.issuetracker.service.UserService;
import com.xylugah.issuetracker.validator.ResolutionValidator;

@Controller
@SessionAttributes("currentUser")
public class ResolutionController {

	private static final Logger logger = LoggerFactory.getLogger(ResolutionController.class);
	
	@Autowired
	private ResolutionValidator resolutionValidator;

	@Resource(name = "UserService")
	private UserService userService;
	
	@Resource(name = "ResolutionService")
	private ResolutionService resolutionService;

	@RequestMapping(value = "/listresolutions", method = RequestMethod.GET)
	public String listResolutions(ModelMap model) {
		List<Resolution> listResolutions = resolutionService.getAll();
		model.addAttribute("listresolutions", listResolutions);
		return "listresolutions";
	}

	@RequestMapping(value = "/editresolution/{id}", method = RequestMethod.GET)
	public String editResolution(@PathVariable int id, ModelMap model) {
		Resolution resolution = resolutionService.getById(id);
		if (resolution == null) {
			return "redirect:/listresolutions";
		}
		model.addAttribute("resolution", resolution);
		return "editresolution";
	}

	@RequestMapping(value = "/addresolution", method = RequestMethod.GET)
	public String addResolution(ModelMap model) {
		Resolution resolution = new Resolution();
		model.addAttribute("resolution", resolution);
		return "addresolution";
	}

	@RequestMapping(value = { "/saveresolution" }, method = RequestMethod.POST)
	public String saveResolution(@ModelAttribute("resolution") Resolution resolution, BindingResult result,
			ModelMap model) {

		resolutionValidator.validate(resolution, result);

		if (resolutionService.getByName(resolution.getName()) != null
				|| resolutionService.getById(resolution.getId()) != null) {
			result.rejectValue("name", "Duplicate.resolution");
		}

		if (result.hasErrors()) {
			return "addresolution";
		}

		resolutionService.add(resolution);

		if (logger.isInfoEnabled()) {
			logger.info(getAuthenticationUser() + " add " + resolution);
		}

		return "redirect:/listresolutions";
	}

	@RequestMapping(value = { "/updateresolution" }, method = RequestMethod.POST)
	public String updateResolution(@ModelAttribute("resolution") Resolution resolution, BindingResult result,
			ModelMap model) {

		resolutionValidator.validate(resolution, result);

		if (resolutionService.getByName(resolution.getName()) != null) {
			result.rejectValue("name", "Duplicate.resolution");
		}

		if (resolutionService.getById(resolution.getId()) == null) {
			result.rejectValue("name", "NotFound.resolution");
		}

		if (result.hasErrors()) {
			return "editresolution";
		}

		resolutionService.edit(resolution);

		if (logger.isInfoEnabled()) {
			logger.info(getAuthenticationUser() + " update " + resolution);
		}
		
		return "redirect:/listresolutions";
	}
	
	private User getAuthenticationUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}

}
