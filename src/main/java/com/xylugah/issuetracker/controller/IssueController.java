package com.xylugah.issuetracker.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xylugah.issuetracker.service.IssueService;

@Controller
public class IssueController {
	
	@Resource(name ="IssueService")
	private IssueService issueService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String issueList(ModelMap model){
		return "listissues";
	}
}
