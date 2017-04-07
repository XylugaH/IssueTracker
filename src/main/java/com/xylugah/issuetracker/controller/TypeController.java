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
		if (type == null){
			return "redirect:/listtypes";
		}
		model.addAttribute("type", type);
		return "edittype";
	}
	
	@RequestMapping(value = "/addtype", method = RequestMethod.GET)
	public String addType(ModelMap model) {
		Type type = new Type();
		model.addAttribute("type", type);
		return "addtype";
	}
	
	@RequestMapping(value = { "/savetype" }, method = RequestMethod.POST)
	public String saveType(@Valid Type type, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "addtype";
		}
		
		typeService.add(type);
		
		return "redirect:/listtypes";
	}
	
	@RequestMapping(value = { "/updatetype" }, method = RequestMethod.POST)
	public String updateType(@Valid Type type, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "edittype";
		}
		
		typeService.edit(type);
		
		return "redirect:/listtypes";
	}
	
}
