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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xylugah.issuetracker.entity.Build;
import com.xylugah.issuetracker.entity.Project;
import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.exception.ProjectNotFoundException;
import com.xylugah.issuetracker.service.BuildService;
import com.xylugah.issuetracker.service.ProjectService;
import com.xylugah.issuetracker.service.UserService;
import com.xylugah.issuetracker.validator.ProjectValidator;

@Controller
@SessionAttributes("currentUser")
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	private ProjectValidator projectValidator;

	@Resource(name = "ProjectService")
	private ProjectService projectService;

	@Resource(name = "BuildService")
	private BuildService buildService;

	@Resource(name = "UserService")
	private UserService userService;

	@RequestMapping(value = "/listprojects", method = RequestMethod.GET)
	public String listProjects(ModelMap model) {
		List<Project> listProjects = projectService.getAll();
		model.addAttribute("listprojects", listProjects);
		return "listprojects";
	}

	@RequestMapping(value = "/addproject", method = RequestMethod.GET)
	public String addProject(ModelMap model) {
		Project project = projectService.getEmptyProject();
		List<User> userList = userService.getAll();
		model.addAttribute("project", project);
		model.addAttribute("users", userList);
		return "addproject";
	}

	@RequestMapping(value = { "/saveproject" }, method = RequestMethod.POST)
	public String saveProject(@ModelAttribute("project") Project project, BindingResult result, ModelMap model) {
		projectValidator.validate(project, result);
		if (project.getBuilds().get(0).getName().isEmpty()) {
			result.rejectValue("builds", "Required");
		}
		if (result.hasErrors()) {
			List<User> userList = userService.getAll();
			model.addAttribute("users", userList);
			return "addproject";
		}
		project.getBuilds().get(0).setProject(project);
		projectService.add(project);

		if (logger.isInfoEnabled()) {
			logger.info(getAuthenticationUser() + " add " + project);
		}

		return "redirect:/listprojects";
	}

	@RequestMapping(value = "/editproject", method = RequestMethod.GET)
	public String editProject(@RequestParam int id, ModelMap model) {
		Project project = projectService.getById(id);

		if (project == null) {
			throw new ProjectNotFoundException(id);
		}

		List<User> userList = userService.getAll();
		model.addAttribute("project", project);
		model.addAttribute("users", userList);
		return "editproject";
	}

	@RequestMapping(value = { "/updateproject" }, method = RequestMethod.POST)
	public String updateProject(@ModelAttribute("project") Project project, BindingResult result, ModelMap model) {
		
		if (projectService.getById(project.getId()) == null) {
			throw new ProjectNotFoundException(project.getId());
		}
		
		projectValidator.validate(project, result);

		if (result.hasErrors()) {
			List<User> userList = userService.getAll();
			model.addAttribute("users", userList);
			return "editproject";
		}

		projectService.edit(project);

		if (logger.isInfoEnabled()) {
			logger.info(getAuthenticationUser() + " edit " + project);
		}

		return "redirect:/listprojects";
	}

	@RequestMapping(value = "/addbuild", method = RequestMethod.POST)
	public String addBuild(@ModelAttribute("build") Build build, ModelMap model, BindingResult result) {

		if (result.hasErrors()) {
			Project project = build.getProject();
			List<User> userList = userService.getAll();
			model.addAttribute("project", project);
			model.addAttribute("users", userList);
			return "editproject";
		}

		buildService.add(build);

		if (logger.isInfoEnabled()) {
			logger.info(getAuthenticationUser() + " add " + build);
		}

		return "redirect:/editproject/" + build.getProject().getId();
	}

	private User getAuthenticationUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}
}
