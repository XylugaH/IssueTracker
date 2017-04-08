package com.xylugah.issuetracker.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xylugah.issuetracker.entity.Status;
import com.xylugah.issuetracker.service.StatusService;

@Controller
@SessionAttributes("currentUser")
public class StatusController {

	@Resource(name = "StatusService")
	private StatusService statusService;

	@RequestMapping(value = "/liststatus", method = RequestMethod.GET)
	public String listStatus(ModelMap model) {
		List<Status> listStatus = statusService.getAll();
		model.addAttribute("listStatus", listStatus);
		return "listStatus";
	}

	@RequestMapping(value = "/editstatus/{id}", method = RequestMethod.GET)
	public String editStatus(@PathVariable int id, ModelMap model) {
		Status status = statusService.getById(id);
		if (status == null) {
			return "redirect:/listStatus";
		}
		model.addAttribute("status", status);
		return "editstatus";
	}

	@RequestMapping(value = { "/updatestatus" }, method = RequestMethod.POST)
	public String saveStatus(@Valid Status status, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "editstatus";
		}

		if (statusService.getById(status.getId()) == null) {
			FieldError addError = new FieldError("status", "name", "Not found!!!");
			result.addError(addError);
			return "editstatus";
		}

		statusService.edit(status);

		return "redirect:/liststatus";
	}

}
