package com.xylugah.issuetracker.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xylugah.issuetracker.entity.Project;
import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.service.ProjectService;
import com.xylugah.issuetracker.service.UserService;

@Controller
public class ProjectController {

	@Resource(name = "ProjectService")
	private ProjectService projectService;

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
	public String saveProject(@Valid Project project, BindingResult result, ModelMap model) {
		System.out.println(project);
		if (result.hasErrors()) {
			List<User> userList = userService.getAll();
			model.addAttribute("users", userList);
			return "addproject";
		}
		project.getBuilds().get(0).setProject(project);
		projectService.add(project);

		return "redirect:/listprojects";
	}

	@RequestMapping(value = "/editproject/{id}", method = RequestMethod.GET)
	public String editProject(@PathVariable int id, ModelMap model) {
		Project project = projectService.getById(id);
		List<User> userList = userService.getAll();
		System.out.println(project.getBuilds());
		model.addAttribute("project", project);
		model.addAttribute("users", userList);
		return "project";
	}

}
