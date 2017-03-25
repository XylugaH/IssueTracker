package com.xylugah.issuetracker.controller;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.service.UserService;

@Controller
public class UserController {

	@Resource(name ="UserService")
	private UserService userService;
	
	private static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/listusers", method = RequestMethod.GET)
	public String listUsers(ModelMap model){
		List<User> listUsers = userService.getAll();
		model.addAttribute("users", listUsers);
		return "listusers";
	}
	
	@RequestMapping(value = "/edituser/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable int id, ModelMap model) {
		User user = userService.getById(id);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "registration";
	}
	
	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		//return "success";
		return "registrationsuccess";
	}
	
	

}