package com.xylugah.issuetracker.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Autowired
	ReloadableResourceBundleMessageSource messageSource;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/listissues";
	}
	
	@RequestMapping(value = "/page403", method = RequestMethod.GET)
	public ModelAndView accessDenied() {		
		ModelAndView model = new ModelAndView("page403");
		model.addObject("message", messageSource.getMessage("Access.denied", null, Locale.getDefault()));
		return model;
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView unknownSource() {
		ModelAndView model = new ModelAndView("page404");
		model.addObject("message", messageSource.getMessage("Invalid.request.status", null, Locale.getDefault()));
		return model;
	}
}
