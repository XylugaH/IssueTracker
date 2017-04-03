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

import com.xylugah.issuetracker.entity.Status;
import com.xylugah.issuetracker.service.StatusService;

@Controller
public class StatusController {

	@Resource(name ="StatusService")
	private StatusService statusService;
	
	
	@RequestMapping(value = "/liststatus", method = RequestMethod.GET)
	public String listStatus(ModelMap model){
		List<Status> listStatus = statusService.getAll();
		model.addAttribute("listStatus", listStatus);
		return "listStatus";
	}
	
	@RequestMapping(value = "/editstatus/{id}", method = RequestMethod.GET)
	public String editStatus(@PathVariable int id, ModelMap model) {
		Status status = statusService.getById(id);
		model.addAttribute("status", status);
		return "status";
	}
	
	
	@RequestMapping(value = { "/savestatus" }, method = RequestMethod.POST)
	public String saveStatus(@Valid Status status, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "status";
		}
		statusService.edit(status);
		List<Status> listStatus = statusService.getAll();
		model.addAttribute("listStatus", listStatus);
		
		return "listStatus";
	}
	
}
