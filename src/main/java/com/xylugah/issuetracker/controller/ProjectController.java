package com.xylugah.issuetracker.controller;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xylugah.issuetracker.entity.Project;
import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.service.ProjectService;
import com.xylugah.issuetracker.service.UserService;
import com.xylugah.issuetracker.validator.ProjectValidator;

@Controller
@SessionAttributes("currentUser")
public class ProjectController {

	@Autowired
	private ProjectValidator projectValidator;
	
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
	public String saveProject(@ModelAttribute("project") Project project, BindingResult result, ModelMap model) {
		projectValidator.validate(project, result);
		if(project.getBuilds().get(0).getName().isEmpty()){
			result.rejectValue("builds", "Required");
		}
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
