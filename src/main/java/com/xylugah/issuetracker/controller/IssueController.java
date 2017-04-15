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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@RequestMapping(value = "/viewissue", method = RequestMethod.GET)
	public String viewIssue(@RequestParam int id, ModelMap model) {
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

	@RequestMapping(value = "/editissue", method = RequestMethod.GET)
	public String editIssue(@RequestParam int id, ModelMap model) {
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

	@RequestMapping(value = "/builds", method = RequestMethod.GET)
	public @ResponseBody List<Build> citiesForState(
			@RequestParam(value = "projectId", required = true) Project project) {
		System.out.println(project);
		return this.buildService.getByProject(project);
	}

	private List<Issue> getIssueByCriteria(final Integer param, final String value) {

		if (value.isEmpty()) {
			return issueService.getAll();
		}

		List<Issue> issues = new ArrayList<Issue>();

		switch (param) {
		case 1:
			List<User> users = userService.getByPartName(value);
			if (!users.isEmpty()) {
				issues = issueService.search("assignee", users);
			}
			break;
		case 2:
			List<Project> projects = projectService.getByPartName(value);
			if (!projects.isEmpty()) {
				issues = issueService.search("project", projects);
			}
			break;
		case 3:
			List<Status> statuses = statusService.getByPartName(value);
			if (!statuses.isEmpty()) {
				issues = issueService.search("status", statuses);
			}
			break;
		case 4:
			List<Priority> priorities = priorityService.getByPartName(value);
			if (!priorities.isEmpty()) {
				issues = issueService.search("priority", priorities);
			}
			break;
		default:
			issues = issueService.getAll();
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
		model.addAttribute("statuses", statuses);
		model.addAttribute("resolutions", resolutions);
		model.addAttribute("types", types);
		model.addAttribute("priorities", priorities);
		model.addAttribute("projects", projects);
		model.addAttribute("users", users);
	}

	private User getAuthenticationUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}

}
