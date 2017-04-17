package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Project;
import com.xylugah.issuetracker.service.ProjectService;

public class ProjectIdToProjectConverter implements Converter<String, Project>{

	private static final Logger logger = LoggerFactory.getLogger(ProjectIdToProjectConverter.class);
	
	@Resource(name ="ProjectService")
	private ProjectService projectService;
		
	@Override
	public Project convert(final String id) {
		try {
			Integer projectId = Integer.valueOf(id);
			return projectService.getById(projectId);
		} catch (NumberFormatException e) {
			logger.error("Invalid id", e);
			return null;
		}
	}
}