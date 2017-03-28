package com.xylugah.issuetracker.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
}
