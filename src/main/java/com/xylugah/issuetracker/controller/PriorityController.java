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

import com.xylugah.issuetracker.entity.Priority;
import com.xylugah.issuetracker.service.PriorityService;


@Controller
public class PriorityController {

	@Resource(name ="PriorityService")
	private PriorityService priorityService;
	
	
	@RequestMapping(value = "/listpriorities", method = RequestMethod.GET)
	public String listPriorityes(ModelMap model){
		List<Priority> listPriorities = priorityService.getAll();
		model.addAttribute("listpriorities", listPriorities);
		return "listpriorities";
	}
	
	@RequestMapping(value = "/editpriority/{id}", method = RequestMethod.GET)
	public String editPriority(@PathVariable int id, ModelMap model) {
		Priority priority = priorityService.getById(id);
		model.addAttribute("priority", priority);
		return "priority";
	}
	
	@RequestMapping(value = "/addpriority", method = RequestMethod.GET)
	public String addPriority(ModelMap model) {
		Priority priority = new Priority();
		model.addAttribute("priority", priority);
		return "priority";
	}
	
	@RequestMapping(value = { "/savepriority" }, method = RequestMethod.POST)
	public String saveStatus(@Valid Priority priority, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "priority";
		}
		
		priorityService.add(priority);
		List<Priority> listPriorityes = priorityService.getAll();
		model.addAttribute("listpriorities", listPriorityes);
		
		return "listpriorities";
	}
	
}