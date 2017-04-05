package com.xylugah.issuetracker.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xylugah.issuetracker.entity.Issue;
import com.xylugah.issuetracker.entity.Role;
import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.entity.util.EmailPassword;
import com.xylugah.issuetracker.service.IssueService;

@Controller
@SessionAttributes("currentUser")
public class IssueController {
	
	@Resource(name ="IssueService")
	private IssueService issueService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String issueList(HttpSession httpSession, ModelMap model){
		httpSession.setAttribute("currentUser", new User("Andry","Dff","123","wew@email.com",new Role()));
		List<Issue> issueList = issueService.getAll();
		model.addAttribute("issues", issueList);
		model.addAttribute("emailPassword", new EmailPassword());
		return "listissues";
	}
}
