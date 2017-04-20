package com.xylugah.issuetracker.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.xylugah.issuetracker.entity.util.SearchBody;
import com.xylugah.issuetracker.exception.IssueNotFoundException;
import com.xylugah.issuetracker.service.*;
import com.xylugah.issuetracker.validator.IssueValidatorAddForm;
import com.xylugah.issuetracker.validator.IssueValidatorEditForm;

@Controller
@SessionAttributes("currentUser")
public class IssueController {

	private static final Logger logger = LoggerFactory.getLogger(IssueController.class);

	private static final double MAX_COUNT_RECORD = 10.0;
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

	@Resource(name = "SearchService")
	private SearchService searchService;

	@Resource(name = "CommentService")
	private CommentService commentService;

	@RequestMapping(value = "/listissues", method = RequestMethod.GET)
	public String issueList(@RequestParam(required = false) Integer page, ModelMap model) {
		int currentPage;
		SearchBody searchBody = searchService.getSearchBody();
		List<Issue> issues = this.issueService.search(searchBody);
		int pageCount = (int) (Math.ceil(issues.size() / MAX_COUNT_RECORD));

		if (page == null) {
			currentPage = 1;
		} else {
			if (page > pageCount || page < 1) {
				currentPage = 1;
			} else {
				currentPage = page;
			}
		}
		int firstIndex=(int) (currentPage*MAX_COUNT_RECORD-MAX_COUNT_RECORD);
		int lastIndex=(int) (currentPage*MAX_COUNT_RECORD);
		if(lastIndex>issues.size()){
			issues = issues.subList(firstIndex,issues.size());	
		}else{
			issues = issues.subList(firstIndex,lastIndex);
		}
		
		model.addAttribute("currentpage", currentPage);
		model.addAttribute("pagecount", pageCount);
		model.addAttribute("issues", issues);
		return "listissues";
	}

	@RequestMapping(value = "/viewissue", method = RequestMethod.GET)
	public String viewIssue(@RequestParam int id, ModelMap model) {
		Issue issue = issueService.getById(id);

		if (issue == null) {
			throw new IssueNotFoundException(id);
		}

		getModelAttributes(model);
		model.addAttribute("issue", issue);

		if (logger.isInfoEnabled()) {
			logger.info("View issue " + issue);
		}

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

		if (logger.isInfoEnabled()) {
			logger.info(getAuthenticationUser() + " save " + issue);
		}

		return "redirect:/listissues";
	}

	@RequestMapping(value = "/editissue", method = RequestMethod.GET)
	public String editIssue(@RequestParam int id, ModelMap model) {
		Issue issue = issueService.getById(id);

		if (issue == null) {
			throw new IssueNotFoundException(id);
		}

		getModelAttributes(model);
		model.addAttribute("issue", issue);

		return "editissue";
	}

	@RequestMapping(value = { "/updateissue" }, method = RequestMethod.POST)
	public String updateIssue(@ModelAttribute("issue") Issue issue, BindingResult result, ModelMap model) {
		Issue newIssue = issueService.getById(issue.getId());

		if (newIssue == null) {
			throw new IssueNotFoundException(issue.getId());
		}

		issue.setTempStatus(newIssue.getTempStatus());
		issue.setCreateDate(newIssue.getCreateDate());
		issue.setCreatedBy(newIssue.getCreatedBy());
		issue.setModifyDate(newIssue.getModifyDate());
		issue.setModifiedBy(newIssue.getModifiedBy());
		issueValidatorEditForm.validate(issue, result);

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

		if (logger.isInfoEnabled()) {
			logger.info(getAuthenticationUser() + " update " + issue);
		}

		getModelAttributes(model);
		model.addAttribute("issue", newIssue);

		return "editissue";
	}

	@RequestMapping(value = { "/searchissue" }, method = RequestMethod.POST)
	public String searchIssue(@ModelAttribute("value") String value, ModelMap model) {

		searchService.SetSeachValue(value);

		return "redirect:/listissues";
	}

	@RequestMapping(value = "/sortissue", method = RequestMethod.GET)
	public String sortIssue(@RequestParam String field, ModelMap model) {

		searchService.SetSortValue(field);

		return "redirect:/listissues";
	}

	@RequestMapping(value = "/addcomment", method = RequestMethod.POST)
	public String addBuild(@RequestParam(value = "issueid") Integer issueid,
			@RequestParam(value = "comment") String comment, ModelMap model) {
		Issue issue = issueService.getById(issueid);

		if (issue == null) {
			throw new IssueNotFoundException(issueid);
		}

		Comment newComment = new Comment();
		newComment.setIssue(issue);
		newComment.setComment(comment);
		newComment.setCreatedBy(getAuthenticationUser());

		commentService.add(newComment);

		if (logger.isInfoEnabled()) {
			logger.info(getAuthenticationUser() + " add " + newComment);
		}

		return "redirect:/editissue?id=" + issue.getId();
	}

	@RequestMapping(value = "/builds", method = RequestMethod.GET)
	public @ResponseBody List<Build> citiesForState(
			@RequestParam(value = "projectId", required = true) Project project) {
		System.out.println(project);
		return this.buildService.getByProject(project);
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
