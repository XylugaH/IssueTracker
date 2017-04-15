package com.xylugah.issuetracker.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xylugah.issuetracker.entity.util.SearchBody;

@Service("SearchService")
public class SearchServiceImpl implements SearchService{

	@Resource(name = "StatusService")
	private StatusService statusService;

	@Resource(name = "PriorityService")
	private PriorityService priorityService;

	@Resource(name = "ProjectService")
	private ProjectService projectService;

	@Resource(name = "UserService")
	private UserService userService;

	private SearchBody searchBody = new SearchBody();
	
	@Override
	public SearchBody getSearchBody(String value) {
		this.searchBody.setValue(value);
		this.searchBody.setUsers(userService.getByPartOfFirstName(value));
		this.searchBody.setProjects(projectService.getByPartName(value));
		this.searchBody.setStatuses(statusService.getByPartName(value));
		this.searchBody.setPriorities(priorityService.getByPartName(value));
		return this.searchBody;
	}
	
}
