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

import com.xylugah.issuetracker.entity.Type;
import com.xylugah.issuetracker.service.TypeService;

@Controller
public class TypeController {

	@Resource(name ="TypeService")
	private TypeService typeService;
	
	
	@RequestMapping(value = "/listtypes", method = RequestMethod.GET)
	public String listTypes(ModelMap model){
		List<Type> listTypes = typeService.getAll();
		model.addAttribute("listtypes", listTypes);
		return "listtypes";
	}
	
	@RequestMapping(value = "/edittype/{id}", method = RequestMethod.GET)
	public String editType(@PathVariable int id, ModelMap model) {
		Type type = typeService.getById(id);
		model.addAttribute("type", type);
		return "type";
	}
	
	
	@RequestMapping(value = { "/savetype" }, method = RequestMethod.POST)
	public String saveStatus(@Valid Type type, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "type";
		}
		
		typeService.edit(type);
		List<Type> listTypes = typeService.getAll();
		model.addAttribute("listtypes", listTypes);
		
		return "listtypes";
	}
	
}
