package com.xylugah.issuetracker.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xylugah.issuetracker.entity.*;
import com.xylugah.issuetracker.service.*;

@Controller
@SessionAttributes("currentUser")
public class IssueController {
	
	@Resource(name ="IssueService")
	private IssueService issueService;
	
	@Resource(name ="StatusService")
	private StatusService statusService;
	
	@Resource(name ="TypeService")
	private TypeService typeService;
	
	@Resource(name ="PriorityService")
	private PriorityService priorityService;
	
	@Resource(name ="ProjectService")
	private ProjectService projectService;
	
	@Resource(name ="UserService")
	private UserService userService;
	
	
	@RequestMapping(value = "/listissues", method = RequestMethod.GET)
	public String issueList(ModelMap model){
		List<Issue> issueList = issueService.getAll();
		model.addAttribute("issues", issueList);
		return "listissues";
	}
	
	@RequestMapping(value = "/addissue", method = RequestMethod.GET)
	public String newIssue(ModelMap model) {
		Issue issue = issueService.getEmptyIssue();
		List<Status> statuses = statusService.getAll();
		List<Type> types = typeService.getAll();
		List<Priority> priorities = priorityService.getAll();
		List<Project> projects = projectService.getAll();
		List<User> users = userService.getAll();
		model.addAttribute("issue", issue);
		model.addAttribute("statuses", statuses);
		model.addAttribute("types", types);
		model.addAttribute("priorities", priorities);
		model.addAttribute("projects", projects);
		model.addAttribute("users", users);
		return "addissue";
	}
	
	@RequestMapping(value = { "/saveissue" }, method = RequestMethod.POST)
	public String saveUser(@Valid Issue issue, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {

			return "addissue";
		}
		
		issueService.add(issue);

		return "redirect:/listissues";
	}
	
	
}
