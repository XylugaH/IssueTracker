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

import com.xylugah.issuetracker.entity.*;
import com.xylugah.issuetracker.service.*;
import com.xylugah.issuetracker.validator.IssueValidatorAddForm;

@Controller
@SessionAttributes("currentUser")
public class IssueController {
	
	@Autowired
	private IssueValidatorAddForm issueValidatorAddForm;
	
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
	
	@Resource(name ="ResolutionService")
	private ResolutionService resolutionService;
	
	@Resource(name ="BuildService")
	private BuildService buildService;
	
	@RequestMapping(value = "/listissues", method = RequestMethod.GET)
	public String issueList(ModelMap model){
		List<Issue> issueList = issueService.getAll();
		model.addAttribute("issues", issueList);
		return "listissues";
	}
	
	@RequestMapping(value = "/addissue", method = RequestMethod.GET)
	public String newIssue(ModelMap model) {
		Issue issue = issueService.getEmptyIssue();
		getModelAttributes(model);
		model.addAttribute("issue", issue);
		return "addissue";
	}
	
	@RequestMapping(value = { "/saveissue" }, method = RequestMethod.POST)
	public String saveIssue(@ModelAttribute("issue") Issue issue, BindingResult result, ModelMap model) {
		issueValidatorAddForm.validate(issue, result);
		
		if (result.hasErrors()) {
			getModelAttributes(model);
			model.addAttribute("issue", issue);
			return "addissue";
		}

		issue.setCreatedBy(getAuthenticationUser());
		issue.setModifiedBy(getAuthenticationUser());
		issueService.add(issue);

		return "redirect:/listissues";
	}
	
	@RequestMapping(value = "/editissue/{id}", method = RequestMethod.GET)
	public String editIssue(@PathVariable int id, ModelMap model) {
		Issue issue = issueService.getById(id);
		if (issue == null) {
			return "redirect:/listissues";
		}
		getModelAttributes(model);
		model.addAttribute("issue", issue);

		return "editissue";
	}
	
	@RequestMapping(value = { "/updateissue" }, method = RequestMethod.POST)
	public String updateIssue(@ModelAttribute("issue") Issue issue, BindingResult result, ModelMap model) {
		//issueValidator.validate(issue, result);
		
		if (result.hasErrors()) {
			getModelAttributes(model);
			model.addAttribute("issue", issue);
			return "editissue";
		}

		issue.setModifiedBy(getAuthenticationUser());
		issueService.edit(issue);

		return "redirect:/listissues";
	}
	
	@RequestMapping(value = { "/search" }, method = RequestMethod.POST)
	public String searchIssue(@ModelAttribute("crit") String crit, ModelMap model) {
		System.out.println(crit);
		List<Issue> issueList = issueService.getAll();
		model.addAttribute("issues", issueList);

		return "listissues";
	}
	
	
	private void getModelAttributes(final ModelMap model){
		List<Status> statuses = statusService.getAll();
		List<Type> types = typeService.getAll();
		List<Priority> priorities = priorityService.getAll();
		List<Project> projects = projectService.getAll();
		List<User> users = userService.getAll();
		List<Resolution> resolutions = resolutionService.getAll();
		List<Build> builds = buildService.getAll();
		model.addAttribute("statuses", statuses);
		model.addAttribute("resolutions", resolutions);
		model.addAttribute("types", types);
		model.addAttribute("priorities", priorities);
		model.addAttribute("projects", projects);
		model.addAttribute("users", users);
		model.addAttribute("builds", builds);
	}
	
	private User getAuthenticationUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}
	
}
