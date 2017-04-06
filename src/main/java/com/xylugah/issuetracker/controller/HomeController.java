package com.xylugah.issuetracker.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.service.UserService;

@Controller
@SessionAttributes("currentUser")
public class HomeController {
	
	@Resource(name = "UserService")
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession httpSession) {
		User user = userService.getGuestUser();
		httpSession.setAttribute("currentUser", user);
		return "redirect:/listissues";
	}
}
