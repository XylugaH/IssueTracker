package com.xylugah.issuetracker.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xylugah.issuetracker.entity.Build;
import com.xylugah.issuetracker.entity.Priority;
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
	public String addResolution(ModelMap model) {
		Project project = new Project();
		List<User> userList = userService.getAll();
		model.addAttribute("project", project);
		model.addAttribute("userList", userList);
		return "project";
	}
	
	@RequestMapping(value = { "/saveproject" }, method = RequestMethod.POST)
	public String saveStatus(@Valid Project project, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "project";
		}
		
		projectService.add(project);
		
		List<Project> listProjects = projectService.getAll();
		model.addAttribute("listprojects", listProjects);
		return "listprojects";
	}
	
}
