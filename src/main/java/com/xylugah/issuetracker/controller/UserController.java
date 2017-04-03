package com.xylugah.issuetracker.controller;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xylugah.issuetracker.entity.Role;
import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.service.RoleService;
import com.xylugah.issuetracker.service.UserService;

@Controller
public class UserController {

	@Resource(name = "UserService")
	private UserService userService;

	@Resource(name = "RoleService")
	private RoleService roleService;

	private MessageSource messageSource;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model) {
		System.out.println("111111");
		return "menu";
	}

	@RequestMapping(value = "/listusers", method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<User> listUsers = userService.getAll();
		model.addAttribute("users", listUsers);
		return "listusers";
	}

	@RequestMapping(value = "/edituser/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable int id, ModelMap model) {
		User user = userService.getById(id);
		List<Role> roleList = roleService.getAll();
		model.addAttribute("roles", roleList);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		List<Role> roleList = roleService.getAll();
		model.addAttribute("user", user);
		model.addAttribute("roles", roleList);
		model.addAttribute("edit", false);
		return "registration";
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			List<Role> roleList = roleService.getAll();
			model.addAttribute("roles", roleList);
			return "registration";
		}

		if (userService.getByEmail(user.getEmail()) != null || userService.getById(user.getId()) != null) {
			FieldError ssoError = new FieldError("user", "email", messageSource.getMessage("non.unique.ssoId",
					new String[] { user.getEmail() }, Locale.getDefault()));
			result.addError(ssoError);
			return "registration";
		}

		userService.add(user);

		model.addAttribute("success",
				"User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
		return "registrationsuccess";
	}

}