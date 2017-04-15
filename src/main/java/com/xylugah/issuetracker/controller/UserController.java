package com.xylugah.issuetracker.controller;

import java.util.List;

import javax.annotation.Resource;

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

import com.xylugah.issuetracker.entity.Role;
import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.entity.util.Password;
import com.xylugah.issuetracker.entity.util.UserProfile;
import com.xylugah.issuetracker.service.RoleService;
import com.xylugah.issuetracker.service.UserService;
import com.xylugah.issuetracker.validator.PasswordValidator;
import com.xylugah.issuetracker.validator.UserProfileValidator;
import com.xylugah.issuetracker.validator.UserValidator;

@Controller
@SessionAttributes("currentUser")
public class UserController {

	@Resource(name = "UserService")
	private UserService userService;

	@Resource(name = "RoleService")
	private RoleService roleService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private UserProfileValidator userProfileValidator;

	@Autowired
	private PasswordValidator passwordValidator;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model, String error, String logout) {

		if (error != null) {
			model.addAttribute("error", "Username or password is incorrect.");
		}

		if (logout != null) {
			model.addAttribute("message", "Logged out successfully.");
		}

		return "listissues";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/listissues";
	}

	@RequestMapping(value = "/listusers", method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<User> users = userService.getAll();
		model.addAttribute("users", users);
		return "listusers";
	}

	@RequestMapping(value = "/edituser/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable int id, ModelMap model) {
		User user = userService.getById(id);
		List<Role> roles = roleService.getAll();
		model.addAttribute("roles", roles);
		model.addAttribute("user", user);
		return "edituser";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = userService.getEmptyUser();
		List<Role> roles = roleService.getAll();
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		return "adduser";
	}

	@RequestMapping(value = { "/saveuser" }, method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {
		userValidator.validate(user, result);

		if (userService.getByEmail(user.getEmail()) != null || userService.getById(user.getId()) != null) {
			result.rejectValue("email", "Duplicate.user.email");
		}

		if (result.hasErrors()) {
			List<Role> roleList = roleService.getAll();
			model.addAttribute("roles", roleList);
			return "adduser";
		}

		userService.add(user);

		return "redirect:/listusers";
	}

	@RequestMapping(value = { "/updateuser" }, method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {

		userValidator.validate(user, result);

		if (result.hasErrors()) {
			List<Role> roleList = roleService.getAll();
			model.addAttribute("roles", roleList);
			return "edituser";
		}

		userService.edit(user);

		return "redirect:/listusers";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String changePassword(ModelMap model) {
		Password password = new Password();
		model.addAttribute("password", password);
		return "changepassword";
	}

	@RequestMapping(value = "/savepassword", method = RequestMethod.POST)
	public String savePassword(@ModelAttribute("password") Password password, BindingResult result, ModelMap model) {
		passwordValidator.validate(password, result);

		if (result.hasErrors()) {
			return "changepassword";
		}
		User user = getAuthenticationUser();
		user.setPassword(password.getPassword());

		userService.edit(user);

		return "redirect:/listissues";
	}

	@RequestMapping(value = "/editprofile", method = RequestMethod.GET)
	public String editProfile(ModelMap model) {
		User user = getAuthenticationUser();
		UserProfile userProfile = new UserProfile();
		userProfile.setFirstName(user.getFirstName());
		userProfile.setLastName(user.getLastName());
		userProfile.setEmail(user.getEmail());
		model.addAttribute("userprofile", userProfile);
		return "editprofile";
	}

	@RequestMapping(value = "/saveprofile", method = RequestMethod.POST)
	public String saveProfile(@ModelAttribute("userprofile") UserProfile userProfile, BindingResult result,
			ModelMap model) {
		userProfileValidator.validate(userProfile, result);

		if (result.hasErrors()) {
			return "editprofile";
		}
		User user = getAuthenticationUser();
		user.setFirstName(userProfile.getFirstName());
		user.setLastName(userProfile.getLastName());
		user.setEmail(userProfile.getEmail());

		userService.edit(user);

		return "redirect:/listissues";
	}

	@RequestMapping(value = { "/searchusers" }, method = RequestMethod.POST)
	public String searchIssue(@ModelAttribute("value") String value, ModelMap model) {

		List<User> users = getUsersByCriteria(value);

		model.addAttribute("users", users);

		return "listusers";
	}
	

	private List<User> getUsersByCriteria(String value) {
		return this.userService.getByPartName(value);
	}

	private User getAuthenticationUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}

}