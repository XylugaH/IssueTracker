package com.xylugah.issuetracker.controller;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xylugah.issuetracker.entity.User;

@Controller
public class RegistrationController {

	private static final Logger logger = Logger.getLogger(RegistrationController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.");
		User user=new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);

		return "registration";
	}

}