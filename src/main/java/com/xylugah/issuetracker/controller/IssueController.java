package com.xylugah.issuetracker.controller;

import java.util.ArrayList;
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
import com.xylugah.issuetracker.validator.IssueValidatorEditForm;

@Controller
@SessionAttributes("currentUser")
public class IssueController {

	@Autowired
	private IssueValidatorAddForm issueValidatorAddForm;

	@Autowired
	private IssueValidatorEditForm issueValidatorEditForm;

	@Resource(name = "IssueService")
	private IssueService issueService;

	@Resource(name = "StatusService")
	private StatusService statusService;

	@Resource(name = "TypeService")
	private TypeService typeService;

	@Resource(name = "PriorityService")
	private PriorityService priorityService;

	@Resource(name = "ProjectService")
	private ProjectService projectService;

	@Resource(name = "UserService")
	private UserService userService;

	@Resource(name = "ResolutionService")
	private ResolutionService resolutionService;

	@Resource(name = "BuildService")
	private BuildService buildService;

	@RequestMapping(value = "/listissues", method = RequestMethod.GET)
	public String issueList(ModelMap model) {
		List<Issue> issueList = issueService.getAll();
		model.addAttribute("issues", issueList);
		return "listissues";
	}

	@RequestMapping(value = "/viewissue/{id}", method = RequestMethod.GET)
	public String viewIssue(@PathVariable int id, ModelMap model) {
		Issue issue = issueService.getById(id);

		if (issue == null) {
			return "redirect:/listissues";
		}

		getModelAttributes(model);
		model.addAttribute("issue", issue);

		return "viewissue";
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
		Issue newIssue = issueService.getById(issue.getId());

		if (newIssue != null) {
			issue.setTempStatus(newIssue.getTempStatus());
			issue.setCreateDate(newIssue.getCreateDate());
			issue.setCreatedBy(newIssue.getCreatedBy());
			issue.setModifyDate(newIssue.getModifyDate());
			issue.setModifiedBy(newIssue.getModifiedBy());
			issueValidatorEditForm.validate(issue, result);
		} else {
			result.rejectValue("id", "Invalid.issue.id");
		}

		if (result.hasErrors()) {
			getModelAttributes(model);
			model.addAttribute("issue", issue);
			return "editissue";
		}

		newIssue.setSummary(issue.getSummary());
		newIssue.setDescription(issue.getDescription());
		newIssue.setStatus(issue.getStatus());
		newIssue.setResolution(issue.getResolution());
		newIssue.setType(issue.getType());
		newIssue.setPriority(issue.getPriority());
		newIssue.setProject(issue.getProject());
		newIssue.setBuild(issue.getBuild());
		newIssue.setAssignee(issue.getAssignee());
		newIssue.setModifiedBy(getAuthenticationUser());
		newIssue.setTempStatus(newIssue.getStatus());

		issueService.edit(newIssue);

		getModelAttributes(model);
		model.addAttribute("issue", newIssue);

		return "editissue";
	}

	@RequestMapping(value = { "/searchissue" }, method = RequestMethod.POST)
	public String searchIssue(@ModelAttribute("param") Integer param, @ModelAttribute("value") String value,
			ModelMap model) {

		List<Issue> issueList = getIssueByCriteria(param, value);

		model.addAttribute("issues", issueList);

		return "listissues";
	}

	private List<Issue> getIssueByCriteria(final Integer param, final String value) {

		if (value.isEmpty()) {
			return issueService.getAll();
		}

		List<Issue> issues = new ArrayList<Issue>();
		
		switch (param) {
		case 1:
			List<User> users = userService.getByPartName(value);
			if(users.isEmpty()){
				break;
			}else{
				issues = issueService.getAll(); 
			}
			
			break;
		case 2:
			System.out.println(projectService.getByPartName(value));
			break;
		case 3:
			System.out.println(statusService.getByPartName(value));
			break;
		case 4:
			System.out.println(priorityService.getByPartName(value));
			break;
		default:
			return issueService.getAll();
		}
		return issues;
	}

	private void getModelAttributes(final ModelMap model) {
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

	private User getAuthenticationUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}

}
