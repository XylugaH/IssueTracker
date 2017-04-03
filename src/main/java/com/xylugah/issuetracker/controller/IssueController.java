package com.xylugah.issuetracker.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xylugah.issuetracker.entity.Issue;
import com.xylugah.issuetracker.service.IssueService;

@Controller
public class IssueController {
	
	@Resource(name ="IssueService")
	private IssueService issueService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String issueList(ModelMap model){
		List<Issue> issueList = issueService.getAll();
		model.addAttribute("issues", issueList);
		return "listissues";
	}
}
