package com.xylugah.issuetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/listissues";
	}
	
	@RequestMapping(value = "/page403", method = RequestMethod.GET)
	public String accessDenied() {		
		return "page403";
	}
	
}
