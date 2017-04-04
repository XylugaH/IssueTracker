package com.xylugah.issuetracker.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xylugah.issuetracker.entity.Build;
import com.xylugah.issuetracker.entity.Project;
import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.service.ProjectService;
import com.xylugah.issuetracker.service.UserService;

@Controller
public class ProjectController {
	
	@Resource(name ="ProjectService")
	private ProjectService projectService;
	
	@Resource(name ="UserService")
	private UserService userService;
	
	@RequestMapping(value = "/listprojects", method = RequestMethod.GET)
	public String listProjects(ModelMap model){
		List<Project> listProjects = projectService.getAll();
		model.addAttribute("listprojects", listProjects);
		return "listprojects";
	}
	
	@RequestMapping(value = "/addproject", method = RequestMethod.GET)
	public String addProject(ModelMap model) {
		Project project = new Project();
		Build build = new Build();
		List<Build> builds = new ArrayList<>();
		builds.add(build);
		project.setBuilds(builds);
		List<User> userList = userService.getAll();
		model.addAttribute("project", project);
		model.addAttribute("users", userList);
		return "newproject";
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
	
	@RequestMapping(value = { "/saveproject" }, method = RequestMethod.POST)
	public String saveProject(@Valid Project project, BindingResult result,
			ModelMap model) {
		System.out.println(project);
		if (result.hasErrors()) {
			List<User> userList = userService.getAll();
			model.addAttribute("users", userList);
			return "project";
		}
		
		projectService.add(project);
		
		List<Project> listProjects = projectService.getAll();
		model.addAttribute("listprojects", listProjects);
		return "listprojects";
	}
	
}
