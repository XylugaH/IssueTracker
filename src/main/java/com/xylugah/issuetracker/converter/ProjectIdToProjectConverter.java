package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Project;
import com.xylugah.issuetracker.service.ProjectService;

public class ProjectIdToProjectConverter implements Converter<String, Project>{

	@Resource(name ="ProjectService")
	private ProjectService projectService;
		
	@Override
	public Project convert(final String id) {
		try {
			Integer projectId = Integer.valueOf(id);
			return projectService.getById(projectId);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}