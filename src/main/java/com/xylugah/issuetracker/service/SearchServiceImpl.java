package com.xylugah.issuetracker.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xylugah.issuetracker.entity.util.SearchBody;
import com.xylugah.issuetracker.entity.util.SearchBody.Field;

@Service("SearchService")
public class SearchServiceImpl implements SearchService {

	@Resource(name = "StatusService")
	private StatusService statusService;

	@Resource(name = "PriorityService")
	private PriorityService priorityService;

	@Resource(name = "ProjectService")
	private ProjectService projectService;

	@Resource(name = "UserService")
	private UserService userService;

	@Autowired
	SearchBody searchBody;

	@Override
	public SearchBody getSearchBody() {
		return this.searchBody;
	}

	@Override
	public SearchBody SetSeachValue(String value) {
		this.searchBody.setValue(value);
		if (!value.isEmpty()) {
			this.searchBody.setUsers(userService.getByPartOfFirstName(value));
			this.searchBody.setProjects(projectService.getByPartName(value));
			this.searchBody.setStatuses(statusService.getByPartName(value));
			this.searchBody.setPriorities(priorityService.getByPartName(value));
		}else{
			this.searchBody.getUsers().clear();;
			this.searchBody.getProjects().clear();
			this.searchBody.getStatuses().clear();
			this.searchBody.getPriorities().clear();
		}
		
		return this.searchBody;
	}

	@Override
	public SearchBody SetSortValue(String field) {
		if(field.equals(searchBody.getField().getName())){
			searchBody.setASC(!searchBody.getASC());
		}
		switch (field) {
		case "id":
			searchBody.setField(Field.ID);
			break;
		case "priority":
			searchBody.setField(Field.PRIORITY);
			break;
		case "assignee":
			searchBody.setField(Field.ASSIGNEE);
			break;
		case "type":
			searchBody.setField(Field.TYPE);
			break;
		case "status":
			searchBody.setField(Field.STATUS);
			break;
		case "summary":
			searchBody.setField(Field.SUMMARY);
			break;
		default:
			searchBody.setField(Field.ID);
			break;
		}
		return this.searchBody;
	}
}
