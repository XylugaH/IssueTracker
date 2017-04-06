package com.xylugah.issuetracker.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("password") String password, @RequestParam("email") String email,
			ModelMap model) {
		String errorMessage="Incorrect email or password";
		if (password.isEmpty() || email.isEmpty()) {
			model.addAttribute("errorOut", errorMessage);
			return "listissues";
		}
		User user = userService.getByEmail(email);
		if (user == null){
			model.addAttribute("errorOut", errorMessage+"1");
			return "listissues";
		}
		
		if (!user.getPassword().equals(password)){
			model.addAttribute("errorOut", errorMessage+"2");
			return "listissues";
		}

		return "listissues";
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
		return "edituser";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = userService.getEmptyUser();
		List<Role> roleList = roleService.getAll();
		model.addAttribute("user", user);
		model.addAttribute("roles", roleList);
		model.addAttribute("edit", false);
		return "adduser";
	}

	@RequestMapping(value = { "/saveuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			List<Role> roleList = roleService.getAll();
			model.addAttribute("roles", roleList);
			return "adduser";
		}
		
		if (userService.getByEmail(user.getEmail()) != null || userService.getById(user.getId()) != null) {
			FieldError addError = new FieldError("user", "email", "Not unique email or Id");
			result.addError(addError);
			return "adduser";
		}

		userService.add(user);

		return "redirect:/listusers";
	}
	
	@RequestMapping(value = { "/updateuser" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			List<Role> roleList = roleService.getAll();
			model.addAttribute("roles", roleList);
			return "edituser";
		}

		userService.edit(user);

		return "redirect:/listusers";
	}
	
}