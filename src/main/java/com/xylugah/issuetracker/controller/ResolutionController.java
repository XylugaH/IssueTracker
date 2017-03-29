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

import com.xylugah.issuetracker.entity.Resolution;
import com.xylugah.issuetracker.service.ResolutionService;

@Controller
public class ResolutionController {

	@Resource(name ="ResolutionService")
	private ResolutionService resolutionService;
	
	
	@RequestMapping(value = "/listresolutions", method = RequestMethod.GET)
	public String listResolutions(ModelMap model){
		List<Resolution> listResolutions = resolutionService.getAll();
		model.addAttribute("listresolutions", listResolutions);
		return "listresolutions";
	}
	
	@RequestMapping(value = "/editresolution/{id}", method = RequestMethod.GET)
	public String editResolution(@PathVariable int id, ModelMap model) {
		Resolution resolution = resolutionService.getById(id);
		model.addAttribute("resolution", resolution);
		return "resolution";
	}
	
	@RequestMapping(value = "/addresolution", method = RequestMethod.GET)
	public String addResolution(ModelMap model) {
		Resolution resolution = new Resolution();
		model.addAttribute("resolution", resolution);
		return "resolution";
	}
	
	@RequestMapping(value = { "/saveresolution" }, method = RequestMethod.POST)
	public String saveStatus(@Valid Resolution resolution, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "resolution";
		}
		
		resolutionService.add(resolution);
		List<Resolution> listResolutions = resolutionService.getAll();
		model.addAttribute("listresolutions", listResolutions);
		
		return "listresolutions";
	}
	
}
