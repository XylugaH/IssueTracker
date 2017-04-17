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

import com.xylugah.issuetracker.entity.Type;
import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.exception.TypeNotFoundException;
import com.xylugah.issuetracker.service.TypeService;
import com.xylugah.issuetracker.service.UserService;
import com.xylugah.issuetracker.validator.TypeValidator;

@Controller
@SessionAttributes("currentUser")
public class TypeController {

	private static final Logger logger = LoggerFactory.getLogger(TypeController.class);
	
	@Autowired
    private TypeValidator typeValidator;

	@Resource(name ="TypeService")
	private TypeService typeService;
	
	@Resource(name = "UserService")
	private UserService userService;
	
	@RequestMapping(value = "/listtypes", method = RequestMethod.GET)
	public String listTypes(ModelMap model){
		List<Type> types = typeService.getAll();
		model.addAttribute("listtypes", types);
		return "listtypes";
	}
	
	@RequestMapping(value = "/edittype", method = RequestMethod.GET)
	public String editType(@RequestParam int id, ModelMap model) {
		Type type = typeService.getById(id);
		
		if (type == null){
			throw new TypeNotFoundException(id);
		}
		
		model.addAttribute("type", type);
		return "edittype";
	}
	
	@RequestMapping(value = "/addtype", method = RequestMethod.GET)
	public String addType(ModelMap model) {
		Type type = new Type();
		model.addAttribute("type", type);
		return "addtype";
	}
	
	@RequestMapping(value = { "/savetype" }, method = RequestMethod.POST)
	public String saveType(@ModelAttribute("type") Type type, BindingResult result,
			ModelMap model) {
		
		typeValidator.validate(type, result);
		
		if (typeService.getByName(type.getName()) != null || typeService.getById(type.getId()) != null) {
			result.rejectValue("name", "Duplicate.type");
		}
		
		if (result.hasErrors()) {
			return "addtype";
		}
		
		typeService.add(type);
		
		if (logger.isInfoEnabled()) {
			logger.info(getAuthenticationUser() + " add " + type);
		}
		
		return "redirect:/listtypes";
	}
	
	@RequestMapping(value = { "/updatetype" }, method = RequestMethod.POST)
	public String updateType(@ModelAttribute("type") Type type, BindingResult result,
			ModelMap model) {

		if (typeService.getById(type.getId())== null){
			throw new TypeNotFoundException(type.getId());
		}
		
		typeValidator.validate(type, result);
		
		if (typeService.getByName(type.getName()) != null) {
			result.rejectValue("name", "Duplicate.type");
		}
			
		if (result.hasErrors()) {
			return "edittype";
		}
		
		typeService.edit(type);
		
		if (logger.isInfoEnabled()) {
			logger.info(getAuthenticationUser() + " update " + type);
		}
		
		return "redirect:/listtypes";
	}
	
	private User getAuthenticationUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}
}
